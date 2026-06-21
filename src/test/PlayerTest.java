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

import java.awt.Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Player;
import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Salida_Quiz;
import object.OBJ_entrada;
import main.Quiz;

public class PlayerTest {

    GamePanel gp;
    Player player;
    KeyHandler kh;

    @BeforeEach
    void setUp() {
        gp = new GamePanel();
        kh = gp.getKeyH();
        player = gp.player;
    }

    // ---------------------------------------------------
    // 1. Validación de los valores iniciales
    // ---------------------------------------------------
    @Test
    void testValoresIniciales() {

        assertEquals(4 * gp.tileSize, player.worldX);
        assertEquals(1 * gp.tileSize, player.worldY);
        assertEquals(4, player.speed);
        assertEquals("down", player.direction);
    }

    // -----------------------------------------------------------------
    // 2. Validación de los movimientos básicos (up, down, left, right)
    // -----------------------------------------------------------------
    @Test
    void testMovimientoArriba() {

        int y = player.worldY;

        kh.upPressed = true;
        player.update();

        assertEquals(y - player.speed, player.worldY);
    }

    @Test
    void testMovimientoAbajo() {

        int y = player.worldY;

        kh.downPressed = true;
        player.update();

        assertEquals(y + player.speed, player.worldY);
    }

    @Test
    void testMovimientoIzquierda() {

        int x = player.worldX;

        kh.leftPressed = true;
        player.update();

        assertEquals(x - player.speed, player.worldX);
    }

    @Test
    void testMovimientoDerecha() {

        int x = player.worldX;

        kh.rightPressed = true;
        player.update();

        assertEquals(x + player.speed, player.worldX);
    }

    // ---------------------------------------------------
    // 3. Validación dirección
    // ---------------------------------------------------
    @Test
    void testDireccion() {

        // UP
        kh.upPressed = true;
        kh.downPressed = false;
        kh.leftPressed = false;
        kh.rightPressed = false;

        player.update();
        assertEquals("up", player.direction);

        // RESET
        kh.upPressed = false;

        // DOWN
        kh.downPressed = true;
        player.update();
        assertEquals("down", player.direction);

        // RESET
        kh.downPressed = false;

        // LEFT
        kh.leftPressed = true;
        player.update();
        assertEquals("left", player.direction);

        // RESET
        kh.leftPressed = false;

        // RIGHT
        kh.rightPressed = true;
        player.update();
        assertEquals("right", player.direction);
        
        // RESET
        kh.rightPressed = false;
    }

    // ---------------------------------------------------
    // 4. Validación de la colisión
    // ---------------------------------------------------
    @Test
    void testNoMovimientoConColision() {

        gp.gameState = gp.playState;
        int x = player.worldX;
        //Simulación de una colisión
        object.SuperObject bloque = new object.SuperObject();
        bloque.worldX = player.worldX;
        bloque.worldY = player.worldY;
        bloque.collision = true;
        bloque.solidArea = new java.awt.Rectangle(0, 0, gp.tileSize, gp.tileSize);

        gp.obj[0] = bloque;

        kh.rightPressed = true;
        player.update();

        assertEquals(x, player.worldX);
    }

    // ---------------------------------------------------
    // 5. Validación de la interacción con el quiz
    // ---------------------------------------------------
    @Test
    void testInteraccionQuiz() {

        OBJ_Salida_Quiz door = new OBJ_Salida_Quiz(
                new Quiz("Q", new String[]{"a","b","c","d"}, 1)
        );

        door.worldX = player.worldX;
        door.worldY = player.worldY;
        door.collision = true;
        door.answered = false;
        door.solidArea = new Rectangle(0,0,32,32);

        gp.obj[0] = door;

        kh.upPressed = true;
        player.update();

        assertEquals(gp.quizState, gp.gameState);
    }

    // ---------------------------------------------------
    // 6. Validación victoria
    // ---------------------------------------------------
    @Test
    void testInteraccionEntradaWin() {

        OBJ_entrada entrada = new OBJ_entrada();

        entrada.worldX = player.worldX;
        entrada.worldY = player.worldY;
        entrada.collision = true;
        entrada.solidArea = new Rectangle(0,0,32,32);

        gp.obj[0] = entrada;

        kh.upPressed = true;
        player.update();

        assertEquals(gp.winState, gp.gameState);
    }

    // ---------------------------------------------------
    // 7. Validación de la animación del jugador
    // ---------------------------------------------------
    @Test
    void testSpriteCambio() {

        kh.upPressed = true;

        player.spriteCounter = 19;

        player.update();

        assertTrue(player.spriteNum == 1 || player.spriteNum == 2);
    }

    // -------------------------------------------------------------
    // 8. Validación para no abrir nuevamente un quiz ya respondido
    // -------------------------------------------------------------
    @Test
    void testQuizYaRespondido() {

        OBJ_Salida_Quiz door = new OBJ_Salida_Quiz(
                new Quiz("Q", new String[]{"a","b","c","d"}, 1)
        );

        door.worldX = player.worldX;
        door.worldY = player.worldY;
        door.collision = true;
        door.answered = true;
        door.solidArea = new Rectangle(0,0,32,32);

        gp.obj[0] = door;

        kh.upPressed = true;
        player.update();

        assertNotEquals(gp.quizState, gp.gameState);
    }
}