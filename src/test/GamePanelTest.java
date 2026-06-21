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

public class GamePanelTest {

    private GamePanel gp;

    @BeforeEach
    void setUp() {
        gp = new GamePanel();
    }

    // --------------------------------------------------
    // 1. Inicialización general (sin depender de assets)
    // --------------------------------------------------
    @Test
    void testInicializacionGeneral() {
        assertNotNull(gp);

        assertNotNull(gp.player);
        assertNotNull(gp.keyH);
        assertNotNull(gp.cChecker);
        assertNotNull(gp.aSetter);
        assertNotNull(gp.ui);
        assertNotNull(gp.tileM);
        assertNotNull(gp.obj);
    }

    // --------------------------------------------------
    // 2. Dimensiones del mundo y pantalla
    // --------------------------------------------------
    @Test
    void testDimensionesPantallaYMapa() {
        assertTrue(gp.screenWidth > 0);
        assertTrue(gp.screenHeight > 0);
        assertTrue(gp.worldWidth > 0);
        assertTrue(gp.worlHeight > 0);
    }

    // --------------------------------------------------
    // 3. Estados iniciales del juego
    // --------------------------------------------------
    @Test
    void testEstadoInicial() {
        assertEquals(gp.playState, gp.gameState);
        assertEquals(gp.maxTime, gp.remainingTime);
    }

    // --------------------------------------------------
    // 4. Constantes del juego
    // --------------------------------------------------
    @Test
    void testConstantesJuego() {
        assertEquals(1, gp.playState);
        assertEquals(2, gp.quizState);
        assertEquals(3, gp.winState);
        assertEquals(4, gp.loseState);
        assertEquals(60, gp.FPS);
    }

    // --------------------------------------------------
    // 5. Setup del juego
    // --------------------------------------------------
    @Test
    void testSetupGameNoFalla() {
        assertDoesNotThrow(() -> gp.setupGame());
    }

    // --------------------------------------------------
    // 6. Update disminuye timer
    // --------------------------------------------------
    @Test
    void testUpdateDisminuyeTiempo() {
        double before = gp.remainingTime;

        gp.update();

        assertTrue(gp.remainingTime <= before);
    }

    // --------------------------------------------------
    // 7. Game Over por tiempo
    // --------------------------------------------------
    @Test
    void testGameOverPorTiempo() {
        gp.remainingTime = 0;

        gp.update();

        assertEquals(gp.loseState, gp.gameState);
    }


    // --------------------------------------------------
    // 8. Objetos del mundo
    // --------------------------------------------------
    @Test
    void testArrayObjetos() {
        assertEquals(50, gp.obj.length);
    }


    // --------------------------------------------------
    // 9. FPS válido
    // --------------------------------------------------
    @Test
    void testFPSValido() {
        assertTrue(gp.FPS > 0);
    }

    // --------------------------------------------------
    // 10. KeyHandler accesible
    // --------------------------------------------------
    @Test
    void testKeyHandlerExiste() {
        assertNotNull(gp.getKeyH());
    }
}