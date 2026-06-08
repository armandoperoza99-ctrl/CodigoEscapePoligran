package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.Canvas;           // Simulación del componente gráfico para el origen del evento
import java.awt.event.KeyEvent;   // Simulación de los eventos del teclado
import main.KeyHandler;           // Uso de la clase a testear

/*
 * Test para validar las acciones de las teclas. 
 * CP01 : Validar que al presionar cada uno de los comandos, se ejecute la acción esperada.
 * CP02 : Validar que al soltar las teclas, se detenga la acción.
 */

public class KeyHandlerTest {

	@Test   // Validación de la acción de la tecla W al ser presionada
	public void testPresionarW() {

        KeyHandler kh = new KeyHandler();

        KeyEvent evento = new KeyEvent(
                new Canvas(),
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_W,
                'W'
        );
        
        kh.keyPressed(evento);
        
        assertTrue(kh.upPressed);
	}
	
	@Test   // Validación de la tecla W al ser soltadas
	public void testSoltarW() {
		
		KeyHandler kh = new KeyHandler();
		kh.upPressed = true;
		KeyEvent evento = new KeyEvent(
				new Canvas(),
				KeyEvent.KEY_RELEASED,
				System.currentTimeMillis(),
				0,
				KeyEvent.VK_W,
				'W'
				);
		
		kh.keyReleased(evento);
		
		assertFalse(kh.upPressed);
	}
	
	@Test    // Validación de la acción de la tecla A al ser presionada
	public void testPresionarA() {

        KeyHandler kh = new KeyHandler();

        KeyEvent evento = new KeyEvent(
                new Canvas(),
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_A,
                'A'
        );
        
        kh.keyPressed(evento);
        
        assertTrue(kh.leftPressed);
	}
	
	@Test    // Validación de la tecla A al ser soltadas
	public void testSoltarA() {
		
		KeyHandler kh = new KeyHandler();
		kh.upPressed = true;
		KeyEvent evento = new KeyEvent(
				new Canvas(),
				KeyEvent.KEY_RELEASED,
				System.currentTimeMillis(),
				0,
				KeyEvent.VK_A,
				'A'
				);
		
		kh.keyReleased(evento);
		
		assertFalse(kh.leftPressed);
	}
	
	@Test    // Validación de la acción de la tecla S al ser presionada
	public void testPresionarS() {

        KeyHandler kh = new KeyHandler();

        KeyEvent evento = new KeyEvent(
                new Canvas(),
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_S,
                'S'
        );
        
        kh.keyPressed(evento);
        
        assertTrue(kh.downPressed);
	}
	
	@Test    // Validación de la tecla S al ser soltadas
	public void testSoltarS() {
		
		KeyHandler kh = new KeyHandler();
		kh.upPressed = true;
		KeyEvent evento = new KeyEvent(
				new Canvas(),
				KeyEvent.KEY_RELEASED,
				System.currentTimeMillis(),
				0,
				KeyEvent.VK_S,
				'S'
				);
		
		kh.keyReleased(evento);
		
		assertFalse(kh.downPressed);
	}
	
	@Test      // Validación de la acción de la tecla D al ser presionada
	public void testPresionarD() {

        KeyHandler kh = new KeyHandler();

        KeyEvent evento = new KeyEvent(
                new Canvas(),
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_D,
                'D'
        );
        
        kh.keyPressed(evento);
        
        assertTrue(kh.rightPressed);
	}
	
	@Test     // Validación de la tecla D al ser soltadas
	public void testSoltarD() {
		
		KeyHandler kh = new KeyHandler();
		kh.upPressed = true;
		KeyEvent evento = new KeyEvent(
				new Canvas(),
				KeyEvent.KEY_RELEASED,
				System.currentTimeMillis(),
				0,
				KeyEvent.VK_D,
				'D'
				);
		
		kh.keyReleased(evento);
		
		assertFalse(kh.rightPressed);
	}

}
