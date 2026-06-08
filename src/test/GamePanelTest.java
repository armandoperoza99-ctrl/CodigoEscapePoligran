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
import org.junit.jupiter.api.Test;
import main.GamePanel;     // Uso de la clase a testear


public class GamePanelTest {

	@Test      // Validación de la correcta inicialización del programa
	
	public void testInicializacion() {
		
		GamePanel gp = new GamePanel ();
		
		assertNotNull(gp.player);        // Validación que el jugador existe
		assertNotNull(gp.getKeyH());     // Validación que existe el manejador del teclado
	}
	
	@Test    // Validación Dimensiones de la Pantalla
	
	public void testDimensionesPantalla() {
		
		GamePanel gp = new GamePanel();
		
		assertEquals(768, gp.screenWidth);    // Validación del ancho configurado
		assertEquals(576, gp.screenHeight);   // Validación del alto configurado
	}
	
	
	@Test    // Validación Cargue del mapa
	
	public void testCargueMapa() {
		
		GamePanel gp = new GamePanel();
		
		assertNotNull(gp.tileM);
	}

}
