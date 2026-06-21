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

import java.awt.Rectangle;

import main.CollisionChecker;
import main.GamePanel;
import entity.Entity;
import object.SuperObject;

public class CollisionCheckerTest {

    GamePanel gp;
    CollisionChecker cc;

    Entity entity;

    @BeforeEach
    void setUp() {

        gp = new GamePanel();
        gp.obj = new SuperObject[20];
        gp.tileM.mapTileNum = new int[10][10];
        cc = new CollisionChecker(gp);
        entity = new Entity();

        entity.worldX = 48;
        entity.worldY = 48;
        entity.speed = 4;
        entity.direction = "up";
        entity.collisionOn = false;

        entity.solidArea = new Rectangle(0, 0, 32, 32);

        // Inicializar tiles sin colisión
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                gp.tileM.mapTileNum[x][y] = 0;
            }
        }

        gp.tileM.tile[0].collision = false;
        gp.tileM.tile[1].collision = true;
    }

    // ---------------------------------------------------
    // 1. Validación no colisión en tile libre
    // ---------------------------------------------------
    @Test
    void testNoCollisionTileLibre() {

        entity.direction = "up";

        cc.checkTile(entity);

        assertFalse(entity.collisionOn);
    }

    // ---------------------------------------------------
    // 2. Valida colisión en tile bloqueante
    // ---------------------------------------------------
    @Test
    void testCollisionTileBloqueante() {

        gp.tileM.mapTileNum[1][0] = 1; // tile con collision = true

        entity.worldX = gp.tileSize;
        entity.worldY = gp.tileSize;

        entity.direction = "up";

        cc.checkTile(entity);

        assertTrue(entity.collisionOn);
    }

    // ---------------------------------------------------
    // 3. Valida detección de objeto con colisión
    // ---------------------------------------------------
    @Test
    void testCollisionConObjeto() {

        SuperObject obj = new SuperObject();

        obj.worldX = 48;
        obj.worldY = 48;
        obj.collision = true;
        obj.solidArea = new Rectangle(0, 0, 32, 32);

        gp.obj[0] = obj;

        entity.worldX = 48;
        entity.worldY = 80; // posición justa para asegurar la colisión

        entity.speed = 32;   // asegura entrada al área
        entity.direction = "up";

        entity.solidArea = new Rectangle(0, 0, 32, 32);

        int index = cc.checkObject(entity, true);

        assertTrue(entity.collisionOn);
        assertEquals(0, index);
    }

    // ---------------------------------------------------
    // 4. Valida objeto sin colisión (solo interacción)
    // ---------------------------------------------------
    @Test
    void testObjetoSinBloqueo() {

        SuperObject obj = new SuperObject();

        obj.worldX = 48;
        obj.worldY = 48;
        obj.collision = false;
        obj.solidArea = new Rectangle(0, 0, 32, 32);

        gp.obj[0] = obj;

        entity.worldX = 48;
        entity.worldY = 48;

        entity.speed = 4;
        entity.direction = "up";
        entity.solidArea = new Rectangle(0, 0, 32, 32);

        int index = cc.checkObject(entity, true);

        assertEquals(0, index);
        assertFalse(entity.collisionOn);
    }

    // ---------------------------------------------------
    // 5. Validación sin objetos en el mapa
    // ---------------------------------------------------
    @Test
    void testSinObjetos() {

        gp.obj = new SuperObject[10];

        int index = cc.checkObject(entity, true);

        assertEquals(-1, index);
        assertFalse(entity.collisionOn);
    }

    // ---------------------------------------------------
    // 6. Valida colisión en diferentes direcciones
    // ---------------------------------------------------
    @Test
    void testColisionDirecciones() {

        SuperObject obj = new SuperObject();

        obj.solidArea = new Rectangle(0, 0, 32, 32);
        obj.collision = true;

        // posicion para asegurar intersección
        obj.worldX = 48;
        obj.worldY = 48;

        gp.obj[0] = obj;

        entity.worldX = 48;
        entity.worldY = 80; // justo debajo
        entity.speed = 32;   // suficiente para entrar en colisión

        entity.solidArea = new Rectangle(0, 0, 32, 32);

        entity.direction = "up";

        cc.checkObject(entity, true);

        assertTrue(entity.collisionOn);
    }
}