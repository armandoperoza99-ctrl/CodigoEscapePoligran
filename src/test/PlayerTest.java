package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import entity.Player;      // Uso de la clase a testear
import main.GamePanel;	   // Importar la clase principal del juego

public class PlayerTest {

    @Test  // Validación de la posición inicial del personaje
    
    public void testValoresIniciales() {

        GamePanel gp = new GamePanel();

        Player player = gp.player;

        assertEquals(100, player.x);
        assertEquals(100, player.y);
        assertEquals(4, player.speed);
        assertEquals("down", player.direction);
    }
    
    
    @Test   //Validación de movimiento hacia arriba
    
    public void testMovimientoArriba() {
    	
    	GamePanel gp = new GamePanel();
    	int posicionInicial = gp.player.y;
    	
    	gp.getKeyH().upPressed = true;
    	
    	gp.player.update();
    	
    	assertEquals(
    			posicionInicial - gp.player.speed,
    			gp.player.y
    			);
    	
    }

    
    @Test   //Validación de movimiento hacia abajo
    
    public void testMovimientoAbajo() {
    	
    	GamePanel gp = new GamePanel();
    	int posicionInicial = gp.player.y;
    	
    	gp.getKeyH().downPressed = true;
    	
    	gp.player.update();
    	
    	assertEquals(
    			posicionInicial + gp.player.speed,
    			gp.player.y
    			);
    	
    }
    
    @Test   //Validación de movimiento hacia la izquierda
    
    public void testMovimientoIzquierda() {
    	
    	GamePanel gp = new GamePanel();
    	int posicionInicial = gp.player.x;
    	
    	gp.getKeyH().leftPressed = true;
    	
    	gp.player.update();
    	
    	assertEquals(
    			posicionInicial - gp.player.speed,
    			gp.player.x
    			);
    	
    }
    
    @Test   //Validación de movimiento hacia la derecha
    
    public void testMovimientoDerecha() {
    	
    	GamePanel gp = new GamePanel();
    	int posicionInicial = gp.player.x;
    	
    	gp.getKeyH().rightPressed = true;
    	
    	gp.player.update();
    	
    	assertEquals(
    			posicionInicial + gp.player.speed,
    			gp.player.x
    			);
    	
    }
    
    @Test    // Validación del cambio de dirección - Arriba
    
    public void testDireccionArriba () {
    	
    	GamePanel gp = new GamePanel();
    	gp.getKeyH().upPressed = true;
    	gp.player.update();
    	assertEquals("up",gp.player.direction);
    }
    
    @Test    // Validación del cambio de dirección - Abajo
    
    public void testDireccionAbajo () {
    	
    	GamePanel gp = new GamePanel();
    	gp.getKeyH().downPressed = true;
    	gp.player.update();
    	assertEquals("down",gp.player.direction);
    }
    
    @Test    // Validación del cambio de dirección - Izquierda
    
    public void testDireccionIzquierda () {
    	
    	GamePanel gp = new GamePanel();
    	gp.getKeyH().leftPressed = true;
    	gp.player.update();
    	assertEquals("left",gp.player.direction);
    }
    
    @Test    // Validación del cambio de dirección - Derecha
    
    public void testDireccionDerecha () {
    	
    	GamePanel gp = new GamePanel();
    	gp.getKeyH().rightPressed = true;
    	gp.player.update();
    	assertEquals("right",gp.player.direction);
    }
}
