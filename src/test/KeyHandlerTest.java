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

import java.awt.Canvas;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GamePanel;
import main.KeyHandler;

public class KeyHandlerTest {

    GamePanel gp;
    KeyHandler kh;

    @BeforeEach
    void setUp() {
        gp = new GamePanel();
        kh = new KeyHandler(gp);
    }

    // ---------------------------------------------------
    // 1. Validación del movimiento
    // ---------------------------------------------------

    @Test
    void testPresionarW() {

        gp.gameState = gp.playState;

        KeyEvent e = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');

        kh.keyPressed(e);

        assertTrue(kh.upPressed);
    }

    @Test
    void testPresionarA() {

        gp.gameState = gp.playState;

        KeyEvent e = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');

        kh.keyPressed(e);

        assertTrue(kh.leftPressed);
    }

    @Test
    void testPresionarS() {

        gp.gameState = gp.playState;

        KeyEvent e = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');

        kh.keyPressed(e);

        assertTrue(kh.downPressed);
    }

    @Test
    void testPresionarD() {

        gp.gameState = gp.playState;

        KeyEvent e = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');

        kh.keyPressed(e);

        assertTrue(kh.rightPressed);
    }

    // ---------------------------------------------------
    // 2. Validación soltar las teclas
    // ---------------------------------------------------

    @Test
    void testSoltarW() {

        kh.upPressed = true;

        KeyEvent e = new KeyEvent(new Canvas(), KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');

        kh.keyReleased(e);

        assertFalse(kh.upPressed);
    }

    @Test
    void testSoltarA() {

        kh.leftPressed = true;

        KeyEvent e = new KeyEvent(new Canvas(), KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');

        kh.keyReleased(e);

        assertFalse(kh.leftPressed);
    }

    @Test
    void testSoltarS() {

        kh.downPressed = true;

        KeyEvent e = new KeyEvent(new Canvas(), KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');

        kh.keyReleased(e);

        assertFalse(kh.downPressed);
    }

    @Test
    void testSoltarD() {

        kh.rightPressed = true;

        KeyEvent e = new KeyEvent(new Canvas(), KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');

        kh.keyReleased(e);

        assertFalse(kh.rightPressed);
    }

    // ----------------------------------------------------------
    // 3. Validación teclas para el quiz (flechas y enter/space)
    // ----------------------------------------------------------

    @Test
    void testQuizUpDownEnterSpace() {

        gp.gameState = gp.quizState;

        KeyEvent up = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');

        KeyEvent down = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');

        KeyEvent enter = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, '\n');

        KeyEvent space = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_SPACE, ' ');

        assertDoesNotThrow(() -> kh.keyPressed(up));
        assertDoesNotThrow(() -> kh.keyPressed(down));
        assertDoesNotThrow(() -> kh.keyPressed(enter));
        assertDoesNotThrow(() -> kh.keyPressed(space));
    }

    // -------------------------------------------------------------------
    // 4. Validación victoria / gameover (Presionar Enter para reiniciar)
    // -------------------------------------------------------------------

    @Test
    void testResetWinState() {

        gp.gameState = gp.winState;

        KeyEvent enter = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, '\n');

        kh.keyPressed(enter);

        assertDoesNotThrow(() -> gp.resetGame());
    }

    @Test
    void testResetLoseState() {

        gp.gameState = gp.loseState;

        KeyEvent enter = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, '\n');

        kh.keyPressed(enter);

        assertDoesNotThrow(() -> gp.resetGame());
    }

    // -----------------------------------------------------------
    // 5. Validación presionar teclas que no tienen funcionalidad
    // -----------------------------------------------------------

    @Test
    void testTeclaInvalidaNoAfecta() {

        gp.gameState = gp.playState;

        KeyEvent x = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_X, 'X');

        kh.keyPressed(x);

        assertFalse(kh.upPressed);
        assertFalse(kh.downPressed);
        assertFalse(kh.leftPressed);
        assertFalse(kh.rightPressed);
    }
}