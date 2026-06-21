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

    // ---------------------------------------------------
    // 1. Validación de la inicialización base
    // ---------------------------------------------------
    @Test
    void testTileManagerInicializado() {

        GamePanel gp = new GamePanel();

        assertNotNull(gp.tileM);
        assertNotNull(gp.tileM.tile);
        assertNotNull(gp.tileM.mapTileNum);
    }

    // ---------------------------------------------------
    // 2. Validación si los tiles existen
    // ---------------------------------------------------
    @Test
    void testTilesExistentes() {

        GamePanel gp = new GamePanel();

        for (int i = 0; i <= 9; i++) {
            assertNotNull(gp.tileM.tile[i]);
        }
    }

    // ---------------------------------------------------
    // 3. Valdiación del cargue de las imágenes 
    // ---------------------------------------------------
    @Test
    void testImagenesTiles() {

        GamePanel gp = new GamePanel();

        for (int i = 0; i <= 9; i++) {
            assertNotNull(gp.tileM.tile[i].image);
        }
    }

    // ---------------------------------------------------
    // 4. Valdiación collision flags correctos
    // ---------------------------------------------------
    @Test
    void testTilesColision() {

        GamePanel gp = new GamePanel();

        assertFalse(gp.tileM.tile[0].collision);
        assertTrue(gp.tileM.tile[1].collision);
        assertTrue(gp.tileM.tile[3].collision);
        assertTrue(gp.tileM.tile[4].collision);
        assertTrue(gp.tileM.tile[5].collision);
    }

    // ---------------------------------------------------
    // 5. Map loading (validación lógica)
    // ---------------------------------------------------
    @Test
    void testMapaCargaBasica() {

        GamePanel gp = new GamePanel();

        // verificamos que se haya escrito al menos un valor
        boolean tieneDatos = false;

        for (int col = 0; col < gp.maxWorldCol; col++) {
            for (int row = 0; row < gp.maxWorldRow; row++) {

                if (gp.tileM.mapTileNum[col][row] >= 0) {
                    tieneDatos = true;
                    break;
                }
            }
        }

        assertTrue(tieneDatos);
    }

    // ---------------------------------------------------
    // 6. Validación de valores dentro del mapa
    // ---------------------------------------------------
    @Test
    void testValoresMapaValidos() {

        GamePanel gp = new GamePanel();

        for (int col = 0; col < gp.maxWorldCol; col++) {
            for (int row = 0; row < gp.maxWorldRow; row++) {

                int val = gp.tileM.mapTileNum[col][row];

                assertTrue(val >= 0 && val <= 9,
                        "Tile inválido en [" + col + "," + row + "]");
            }
        }
    }
}