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

public class AssetSetterTest {

    //Validación para que todos los objetos del escenario sean creados y ubicados correctamente
    @Test
    public void testObjetosYPosiciones() {

        GamePanel gp = new GamePanel();

        gp.setupGame();

        // Piso 5

        assertNotNull(gp.obj[0]);
        assertEquals(1 * gp.tileSize, gp.obj[0].worldX);
        assertEquals(1 * gp.tileSize, gp.obj[0].worldY);

        assertNotNull(gp.obj[1]);
        assertEquals(2 * gp.tileSize, gp.obj[1].worldX);
        assertEquals(1 * gp.tileSize, gp.obj[1].worldY);

        assertNotNull(gp.obj[2]);
        assertEquals(3 * gp.tileSize, gp.obj[2].worldX);
        assertEquals(1 * gp.tileSize, gp.obj[2].worldY);

        assertNotNull(gp.obj[3]);
        assertEquals(8 * gp.tileSize, gp.obj[3].worldX);
        assertEquals(1 * gp.tileSize, gp.obj[3].worldY);

        assertNotNull(gp.obj[4]);
        assertEquals(9 * gp.tileSize, gp.obj[4].worldX);
        assertEquals(1 * gp.tileSize, gp.obj[4].worldY);

        assertNotNull(gp.obj[5]);
        assertEquals(10 * gp.tileSize, gp.obj[5].worldX);
        assertEquals(1 * gp.tileSize, gp.obj[5].worldY);

        assertNotNull(gp.obj[6]);
        assertEquals(11 * gp.tileSize, gp.obj[6].worldX);
        assertEquals(1 * gp.tileSize, gp.obj[6].worldY);

        assertNotNull(gp.obj[7]);
        assertEquals(13 * gp.tileSize, gp.obj[7].worldX);
        assertEquals(1 * gp.tileSize, gp.obj[7].worldY);

        // Piso 4

        assertNotNull(gp.obj[8]);
        assertEquals(1 * gp.tileSize, gp.obj[8].worldX);
        assertEquals(4 * gp.tileSize, gp.obj[8].worldY);

        assertNotNull(gp.obj[9]);
        assertEquals(2 * gp.tileSize, gp.obj[9].worldX);
        assertEquals(4 * gp.tileSize, gp.obj[9].worldY);

        assertNotNull(gp.obj[10]);
        assertEquals(4 * gp.tileSize, gp.obj[10].worldX);
        assertEquals(3 * gp.tileSize, gp.obj[10].worldY);

        assertNotNull(gp.obj[11]);
        assertEquals(8 * gp.tileSize, gp.obj[11].worldX);
        assertEquals(3 * gp.tileSize, gp.obj[11].worldY);

        assertNotNull(gp.obj[12]);
        assertEquals(9 * gp.tileSize, gp.obj[12].worldX);
        assertEquals(3 * gp.tileSize, gp.obj[12].worldY);

        // El objeto 13 no existe en el AssetSetter

        assertNull(gp.obj[13]);

        assertNotNull(gp.obj[14]);
        assertEquals(10 * gp.tileSize, gp.obj[14].worldX);
        assertEquals(3 * gp.tileSize, gp.obj[14].worldY);

        assertNotNull(gp.obj[15]);
        assertEquals(11 * gp.tileSize, gp.obj[15].worldX);
        assertEquals(3 * gp.tileSize, gp.obj[15].worldY);

        assertNotNull(gp.obj[16]);
        assertEquals(14 * gp.tileSize, gp.obj[16].worldX);
        assertEquals(4 * gp.tileSize, gp.obj[16].worldY);

        // Piso 3

        assertNotNull(gp.obj[17]);
        assertEquals(9 * gp.tileSize, gp.obj[17].worldX);
        assertEquals(5 * gp.tileSize, gp.obj[17].worldY);

        assertNotNull(gp.obj[18]);
        assertEquals(10 * gp.tileSize, gp.obj[18].worldX);
        assertEquals(5 * gp.tileSize, gp.obj[18].worldY);

        assertNotNull(gp.obj[19]);
        assertEquals(11 * gp.tileSize, gp.obj[19].worldX);
        assertEquals(5 * gp.tileSize, gp.obj[19].worldY);

        assertNotNull(gp.obj[20]);
        assertEquals(12 * gp.tileSize, gp.obj[20].worldX);
        assertEquals(5 * gp.tileSize, gp.obj[20].worldY);

        assertNotNull(gp.obj[21]);
        assertEquals(1 * gp.tileSize, gp.obj[21].worldX);
        assertEquals(5 * gp.tileSize, gp.obj[21].worldY);

        assertNotNull(gp.obj[22]);
        assertEquals(13 * gp.tileSize, gp.obj[22].worldX);
        assertEquals(5 * gp.tileSize, gp.obj[22].worldY);
    }
    
    // Validación que existen el total de los objetos
    @Test
    public void testCantidadObjetosConfigurados() {

        GamePanel gp = new GamePanel();

        gp.setupGame();

        int cantidadObjetos = 0;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                cantidadObjetos++;
            }
        }

        assertEquals(22, cantidadObjetos);
    }
}
