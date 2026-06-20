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



public class TileManagerTest {
	
	// Validación que el TileManager inicia correctamente
	@Test
	public void testTileManagerInicializado() {
		
		GamePanel gp = new GamePanel ();
		
		assertNotNull(gp.tileM);
		assertNotNull(gp.tileM.tile);
		assertNotNull(gp.tileM.mapTileNum);

	}
	
	// Validación que todos los tiles se carguen correctamente.
	
	@Test
	public void testTilesExistentes() {
		
		GamePanel gp = new GamePanel ();
		
		for (int i = 0; i <= 9; i++) {
			assertNotNull(
					gp.tileM.tile[i],
					"El tile " + i + "debería existir."
					);
		}
	}
	
	// Validación que todos los tiles cargados tienen una imagen asociada.
	@Test
	public void testImagenesTiles() {
		
		GamePanel gp = new GamePanel ();
		
		for (int i = 0; i <= 9; i++) {
			assertNotNull(
				gp.tileM.tile[i].image,
				"El tile " + i + "debería tener imágen."
			);
		}
	}

}
