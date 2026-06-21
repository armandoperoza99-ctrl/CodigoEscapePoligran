package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import object.OBJ_Salida_Quiz;

public class UI {

    GamePanel gp;
    public Quiz currentQuiz;
    public int selectedOption = 0;
    public Integer currentDoorIndex = null;
    public String feedbackMessage = "";
    int feedbackTimer = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
    }

    public void startQuiz(Quiz quiz, int doorIndex) {
        currentQuiz = quiz;
        currentDoorIndex = doorIndex;
        selectedOption = 0;
        feedbackMessage = "";
    }

    public void moveSelectionUp() {
        if (currentQuiz == null) return;
        selectedOption--;
        if (selectedOption < 0) selectedOption = currentQuiz.options.length - 1;
    }

    public void moveSelectionDown() {
        if (currentQuiz == null) return;
        selectedOption++;
        if (selectedOption >= currentQuiz.options.length) selectedOption = 0;
    }

    public void confirmSelection() {
        if (currentQuiz == null || currentDoorIndex == null) return;

        if (selectedOption == currentQuiz.correctIndex) {
            OBJ_Salida_Quiz door = (OBJ_Salida_Quiz) gp.obj[currentDoorIndex];
            door.answered = true;
            door.collision = false;

            currentQuiz = null;
            currentDoorIndex = null;
            gp.gameState = gp.playState;
        } else {
            feedbackMessage = "Incorrecto, -25s";
            feedbackTimer = 90;

            gp.remainingTime -= 25;
            if (gp.remainingTime <= 0) {
                gp.remainingTime = 0;
                gp.gameState = gp.loseState;
                currentQuiz = null;
                currentDoorIndex = null;
            }
        }
    }

    public void update() {
        if (feedbackTimer > 0) {
            feedbackTimer--;
            if (feedbackTimer == 0) feedbackMessage = "";
        }
    }

    public void draw(Graphics2D g2) {

        if (gp.gameState == gp.playState || gp.gameState == gp.quizState) {
            drawTimer(g2);
        }
        if (gp.gameState == gp.quizState && currentQuiz != null) {
            drawQuizScreen(g2);
        }
        // anterior
//        if (gp.gameState == gp.winState) {
//            drawEndScreen(g2, "¡LO LOGRASTE!", "Escapaste del laboratorio a tiempo.", new Color(20, 80, 30));
//        }
        if (gp.gameState == gp.winState) {
            drawEndScreen(
                    g2,
                    "¡GANASTE!",
                    "¡Felicidades! Escapaste del laboratorio.",
                    new Color(20, 80, 30));
        }
        if (gp.gameState == gp.loseState) {
            drawEndScreen(g2, "TE QUEMASTE ADENTRO", "Se acabó el tiempo...", new Color(90, 20, 20));
        }
    }

    private void drawTimer(Graphics2D g2) {
        int totalSeconds = (int) Math.max(0, gp.remainingTime);
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        String text = String.format("%02d:%02d", minutes, seconds);

        g2.setFont(new Font("Arial", Font.BOLD, 26));
        g2.setColor(Color.black);
        g2.drawString(text, gp.screenWidth - 92, 38);
        g2.setColor(totalSeconds <= 20 ? Color.red : Color.white);
        g2.drawString(text, gp.screenWidth - 95, 35);
    }

    private void drawQuizScreen(Graphics2D g2) {

        g2.setColor(new Color(0, 0, 0, 190));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        int boxWidth = 420;
        int boxHeight = 60 + currentQuiz.options.length * 34 + 45;
        int boxX = (gp.screenWidth - boxWidth) / 2;
        int boxY = (gp.screenHeight - boxHeight) / 2;

        g2.setColor(new Color(20, 20, 60));
        g2.fillRoundRect(boxX, boxY, boxWidth, boxHeight, 20, 20);
        g2.setColor(Color.white);
        g2.drawRoundRect(boxX, boxY, boxWidth, boxHeight, 20, 20);

        g2.setFont(new Font("Arial", Font.BOLD, 16));
        drawWrappedString(
                g2,
                currentQuiz.question,
                boxX + 20,
                boxY + 30,
                boxWidth - 40,
                20
        );

        g2.setFont(new Font("Arial", Font.PLAIN, 15));
        int optionY = boxY + 90;
        for (int i = 0; i < currentQuiz.options.length; i++) {
            if (i == selectedOption) {
                g2.setColor(Color.yellow);
                g2.drawString(">", boxX + 20, optionY);
            } else {
                g2.setColor(Color.white);
            }
            g2.drawString(currentQuiz.options[i], boxX + 40, optionY);
            optionY += 34;
        }

        if (!feedbackMessage.isEmpty()) {
            g2.setColor(Color.red);
            g2.setFont(new Font("Arial", Font.BOLD, 14));
            g2.drawString(feedbackMessage, boxX + 20, boxY + boxHeight - 15);
        }
    }

    private void drawEndScreen(Graphics2D g2, String title, String subtitle, Color bg) {

        g2.setColor(new Color(0, 0, 0, 220));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        int boxWidth = 420;
        int boxHeight = 180;
        int boxX = (gp.screenWidth - boxWidth) / 2;
        int boxY = (gp.screenHeight - boxHeight) / 2;

        g2.setColor(bg);
        g2.fillRoundRect(boxX, boxY, boxWidth, boxHeight, 20, 20);
        g2.setColor(Color.white);
        g2.drawRoundRect(boxX, boxY, boxWidth, boxHeight, 20, 20);

        g2.setFont(new Font("Arial", Font.BOLD, 22));
        g2.drawString(title, boxX + 30, boxY + 55);

        g2.setFont(new Font("Arial", Font.PLAIN, 16));
        g2.drawString(subtitle, boxX + 30, boxY + 90);

        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.setColor(Color.yellow);
        g2.drawString("Presiona ENTER para jugar de nuevo", boxX + 30, boxY + 145);
    }
    
    private void drawWrappedString(
            Graphics2D g2,
            String text,
            int x,
            int y,
            int maxWidth,
            int lineHeight) {

        String[] words = text.split(" ");
        String line = "";

        for (String word : words) {

            String testLine = line + word + " ";

            if (g2.getFontMetrics().stringWidth(testLine) > maxWidth) {

                g2.drawString(line, x, y);
                y += lineHeight;
                line = word + " ";

            } else {

                line = testLine;
            }
        }

        g2.drawString(line, x, y);
    }
}