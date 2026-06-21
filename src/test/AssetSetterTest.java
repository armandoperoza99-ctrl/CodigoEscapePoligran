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

import main.AssetSetter;
import main.GamePanel;
import main.Quiz;

import object.*;

public class AssetSetterTest {

    GamePanel gp;
    AssetSetter assetSetter;
    
    @BeforeEach
    void setUp() {

        gp = new GamePanel(); // ya trae obj inicializado como SuperObject[50]

        assetSetter = new AssetSetter(gp);
        assetSetter.setObject();
    }


    // ---------------------------------------------------
    // 1. Validar que los objetos clave no sean null
    // ---------------------------------------------------
    @Test
    void testObjetosNoNull() {

        int[] indices = {
            0,1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,20,22,23,
            25,26,27,28,29,30,31,32,34,36,37,38,39,40,41,42,43,44
        };

        for (int i : indices) {
            assertNotNull(gp.obj[i], "Objeto null en índice: " + i);
        }
    }

    // ---------------------------------------------------
    // 2. Validar tipos de objetos principales
    // ---------------------------------------------------
    @Test
    void testTiposDeObjetos() {

        assertTrue(gp.obj[0] instanceof OBJ_Pc_Principal);
        assertTrue(gp.obj[2] instanceof OBJ_Servidor_One);
        assertTrue(gp.obj[3] instanceof OBJ_PC_Obj);
        assertTrue(gp.obj[7] instanceof OBJ_Pizarra);
        assertTrue(gp.obj[8] instanceof OBJ_Silla);
        assertTrue(gp.obj[12] instanceof OBJ_Salida_Quiz);

        assertTrue(gp.obj[14] instanceof OBJ_Servidor_Two);
        assertTrue(gp.obj[15] instanceof OBJ_Servidor_One);

        assertTrue(gp.obj[27] instanceof OBJ_Pc_Letra_k);
        assertTrue(gp.obj[38] instanceof OBJ_Pc_Letra_y);

        assertTrue(gp.obj[43] instanceof OBJ_Flores);
        assertTrue(gp.obj[44] instanceof OBJ_entrada);
    }

    // ---------------------------------------------------
    // 3. Validar posiciones con tileSize
    // ---------------------------------------------------
    @Test
    void testPosicionesCorrectas() {

        assertEquals(1 * gp.tileSize, ((SuperObject) gp.obj[0]).worldX);
        assertEquals(1 * gp.tileSize, ((SuperObject) gp.obj[0]).worldY);

        assertEquals(2 * gp.tileSize, ((SuperObject) gp.obj[1]).worldX);
        assertEquals(1 * gp.tileSize, ((SuperObject) gp.obj[1]).worldY);

        assertEquals(12 * gp.tileSize, ((SuperObject) gp.obj[12]).worldX);
        assertEquals(2 * gp.tileSize, ((SuperObject) gp.obj[12]).worldY);

        assertEquals(3 * gp.tileSize, ((SuperObject) gp.obj[26]).worldX);
        assertEquals(4 * gp.tileSize, ((SuperObject) gp.obj[26]).worldY);

        assertEquals(3 * gp.tileSize, ((SuperObject) gp.obj[42]).worldX);
        assertEquals(8 * gp.tileSize, ((SuperObject) gp.obj[42]).worldY);

        assertEquals(8 * gp.tileSize, ((SuperObject) gp.obj[44]).worldX);
        assertEquals(9 * gp.tileSize, ((SuperObject) gp.obj[44]).worldY);
    }

    // ---------------------------------------------------
    // 4. Validación general de coordenadas
    // ---------------------------------------------------
    @Test
    void testCoordenadasValidas() {

        for (Object o : gp.obj) {
            if (o != null) {

                SuperObject so = (SuperObject) o;

                assertTrue(so.worldX >= 0, "worldX negativo");
                assertTrue(so.worldY >= 0, "worldY negativo");

                assertEquals(0, so.worldX % gp.tileSize,
                        "worldX no alineado a tileSize");

                assertEquals(0, so.worldY % gp.tileSize,
                        "worldY no alineado a tileSize");
            }
        }
    }

    // ---------------------------------------------------
    // 5. Validación del quiz
    // ---------------------------------------------------
    @Test
    void testQuizPisoCinco() {

    	OBJ_Salida_Quiz q1 = (OBJ_Salida_Quiz) gp.obj[12];

        assertNotNull(q1.quiz);
        assertEquals("¿Qué hace un void en Java?", q1.quiz.question);
        assertEquals(4, q1.quiz.options.length);
        assertEquals(1, q1.quiz.correctIndex);
    }
    
    @Test
    public void testQuizPisoCuadro() {
    	OBJ_Salida_Quiz q2 = (OBJ_Salida_Quiz) gp.obj[26];

        assertNotNull(q2.quiz);
        assertEquals("¿Qué palabra clave se usa para heredar de una clase en Java?", q2.quiz.question);
        assertEquals(4, q2.quiz.options.length);
        assertEquals("implements", q2.quiz.options[0]);
        assertEquals("extends", q2.quiz.options[1]);
        assertEquals("inherits", q2.quiz.options[2]);
        assertEquals("super", q2.quiz.options[3]);
        assertEquals(1, q2.quiz.correctIndex);
    }
    
    @Test
    public void testQuizPisoTres() {
    	OBJ_Salida_Quiz q1 = (OBJ_Salida_Quiz) gp.obj[12];

        assertNotNull(q1.quiz);
        assertEquals("¿Qué hace un void en Java?", q1.quiz.question);
        assertEquals(4, q1.quiz.options.length);
        assertEquals(1, q1.quiz.correctIndex);
    }
    
    @Test
    public void testQuizPisoDos() {
        OBJ_Salida_Quiz q2 = (OBJ_Salida_Quiz) gp.obj[26];

        assertNotNull(q2.quiz);
        assertEquals("¿Qué palabra clave se usa para heredar de una clase en Java?", q2.quiz.question);
        assertEquals(4, q2.quiz.options.length);
        assertEquals("implements", q2.quiz.options[0]);
        assertEquals("extends", q2.quiz.options[1]);
        assertEquals("inherits", q2.quiz.options[2]);
        assertEquals("super", q2.quiz.options[3]);
        assertEquals(1, q2.quiz.correctIndex);
    }
    
    @Test
    public void testQuizPisoUno() {
    	OBJ_Salida_Quiz q3 = (OBJ_Salida_Quiz) gp.obj[37];

        assertNotNull(q3.quiz);
        assertEquals("¿Cuál de estos es un tipo de dato primitivo en Java?", q3.quiz.question);
        assertEquals(4, q3.quiz.options.length);
        assertEquals("String", q3.quiz.options[0]);
        assertEquals("int", q3.quiz.options[1]);
        assertEquals("ArrayList", q3.quiz.options[2]);
        assertEquals("Object", q3.quiz.options[3]);
        assertEquals(1, q3.quiz.correctIndex);
    }
    // ---------------------------------------------------
    // 6. Validar cantidad mínima de objetos cargados
    // ---------------------------------------------------
    @Test
    void testCantidadMinimaObjetos() {

        int count = 0;

        for (Object o : gp.obj) {
            if (o != null) count++;
        }

        assertTrue(count >= 30, "No se cargaron suficientes objetos");
    }
}