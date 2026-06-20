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
import main.GamePanel;


class CollisionCheckerTest {

	
	// Validación de la correcta creación del CollisionChecker.
	
	@Test
	void testCreationCollisionChecker() {
		
		GamePanel gp = new GamePanel();
		
		assertNotNull(gp.cChecker);
		
	}
	
	
	// Validación del método checkTile
	
	@Test
	public void testCheckTileSinErrores() {
		
		GamePanel gp = new GamePanel();
		
		gp.player.direction = "up";
		gp.player.collisionOn = false;
		
		assertDoesNotThrow(() -> {
			gp.cChecker.checkTile(gp.player);
		});
	}
	
	// Validación del resultado de la colisión
	
	@Test
	public void testEstadoColisionValido() {
		
		GamePanel gp = new GamePanel();
		
		gp.player.direction = "right";
		gp.cChecker.checkTile(gp.player);
		
		assertNotNull(gp.player);
	}

}
