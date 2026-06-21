/*
*AUTORES:
*Diego Rosales Peroza 
*Laura Ruiz Mora 
*Ángel Sanabria Suarez 
*Martha Liliana Salazar Betancur 
*Laura Vanessa Romero Jiménez 
*/


package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GamePanel;
import main.UI;
import main.Quiz;
import object.OBJ_Salida_Quiz;

public class UITest {

    GamePanel gp;
    UI ui;
    Quiz quiz;

    @BeforeEach
    void setUp() {
        gp = new GamePanel();
        ui = gp.ui;

        quiz = new Quiz(
                "Pregunta test",
                new String[]{"A", "B", "C"},
                1
        );

        gp.gameState = gp.playState;
        gp.remainingTime = 100;
    }

    // -----------------------------------------
    // 1. Validación startQuiz
    // -----------------------------------------
    @Test
    void testStartQuiz() {

        ui.startQuiz(quiz, 2);

        assertEquals(quiz, ui.currentQuiz);
        assertEquals(2, ui.currentDoorIndex);
        assertEquals(0, ui.selectedOption);
        assertEquals("", ui.feedbackMessage);
    }

    // -----------------------------------------
    // 2. Validación selección hacia abajo (loop)
    // -----------------------------------------
    @Test
    void testMoveSelectionDown() {

        ui.startQuiz(quiz, 0);

        ui.selectedOption = 2;
        ui.moveSelectionDown();

        assertEquals(0, ui.selectedOption);
    }

    // -----------------------------------------
    // 3. Validación selección hacia arriba (loop)
    // -----------------------------------------
    @Test
    void testMoveSelectionUp() {

        ui.startQuiz(quiz, 0);

        ui.selectedOption = 0;
        ui.moveSelectionUp();

        assertEquals(2, ui.selectedOption);
    }

    // -----------------------------------------
    // 4. Validación selección opción correcta
    // -----------------------------------------
    @Test
    void testConfirmSelectionCorrecta() {

        gp.obj[0] = new OBJ_Salida_Quiz(quiz);

        ui.startQuiz(quiz, 0);
        ui.selectedOption = 1; // correcta
        gp.gameState = gp.quizState;

        ui.confirmSelection();

        OBJ_Salida_Quiz door = (OBJ_Salida_Quiz) gp.obj[0];

        assertTrue(door.answered);
        assertFalse(door.collision);

        assertNull(ui.currentQuiz);
        assertNull(ui.currentDoorIndex);
        assertEquals(gp.playState, gp.gameState);
    }

    // -----------------------------------------
    // 5. Validación selección opción incorrecta
    // -----------------------------------------
    @Test
    void testConfirmSelectionIncorrecta() {

        ui.startQuiz(quiz, 0);
        ui.selectedOption = 0; // incorrecta
        gp.gameState = gp.quizState;
        gp.remainingTime = 100;

        ui.confirmSelection();

        assertEquals("Incorrecto, -25s", ui.feedbackMessage);
        assertEquals(75, gp.remainingTime);
    }

    // -----------------------------------------
    // 6. Validación GameOver por tiempo
    // -----------------------------------------
    @Test
    void testLosePorTiempo() {

        ui.startQuiz(quiz, 0);
        ui.selectedOption = 0; // incorrecta
        gp.gameState = gp.quizState;
        gp.remainingTime = 20;

        ui.confirmSelection();

        assertEquals(0, gp.remainingTime);
        assertEquals(gp.loseState, gp.gameState);
        assertNull(ui.currentQuiz);
        assertNull(ui.currentDoorIndex);
    }

    // -----------------------------------------
    // 7. Validación tiempo
    // -----------------------------------------
    @Test
    void testFeedbackTimerUpdate() {

        ui.feedbackMessage = "TEST";
        ui.feedbackTimer = 1;

        ui.update();

        assertEquals(0, ui.feedbackTimer);
        assertEquals("", ui.feedbackMessage);
    }

    // -----------------------------------------
    // 8. Validación caso inválido
    // -----------------------------------------
    @Test
    void testConfirmSelectionSinQuiz() {

        ui.currentQuiz = null;
        ui.currentDoorIndex = null;

        ui.confirmSelection();

        assertNull(ui.currentQuiz);
        assertNull(ui.currentDoorIndex);
    }
}
