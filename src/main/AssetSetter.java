package main;

import object.OBJ_Flores;
import object.OBJ_PC_Obj;
import object.OBJ_Pc_Letra_i;
import object.OBJ_Pc_Letra_k;
import object.OBJ_Pc_Letra_l;
import object.OBJ_Pc_Letra_o;
import object.OBJ_Pc_Letra_u;
import object.OBJ_Pc_Letra_w;
import object.OBJ_Pc_Letra_y;
import object.OBJ_Pc_Principal;
import object.OBJ_Pizarra;
import object.OBJ_Salida_Quiz;
import object.OBJ_Servidor_One;
import object.OBJ_Servidor_Two;
import object.OBJ_Silla;
import object.OBJ_entrada;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp =  gp;
	}
	
	public void setObject() {
		
		//Objetos de piso 5------------------------------
		
		gp.obj[0] = new OBJ_Pc_Principal();
		gp.obj[0].worldX = 1 * gp.tileSize;
		gp.obj[0].worldY = 1 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Pc_Principal();
		gp.obj[1].worldX = 2 * gp.tileSize;
		gp.obj[1].worldY = 1 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Servidor_One();
		gp.obj[2].worldX = 3 * gp.tileSize;
		gp.obj[2].worldY = 1 * gp.tileSize;
		
		gp.obj[3] = new OBJ_PC_Obj();
		gp.obj[3].worldX = 8 * gp.tileSize;
		gp.obj[3].worldY = 1 * gp.tileSize;
		
		gp.obj[4] = new OBJ_PC_Obj();
		gp.obj[4].worldX = 9 * gp.tileSize;
		gp.obj[4].worldY = 1 * gp.tileSize;
		
		gp.obj[5] = new OBJ_PC_Obj();
		gp.obj[5].worldX = 10 * gp.tileSize;
		gp.obj[5].worldY = 1 * gp.tileSize;
		
		gp.obj[6] = new OBJ_PC_Obj();
		gp.obj[6].worldX = 11 * gp.tileSize;
		gp.obj[6].worldY = 1 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Pizarra();
		gp.obj[7].worldX = 13 * gp.tileSize;
		gp.obj[7].worldY = 1 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Silla();
		gp.obj[8].worldX = 1 * gp.tileSize;
		gp.obj[8].worldY = 2 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Silla();
		gp.obj[9].worldX = 2 * gp.tileSize;
		gp.obj[9].worldY = 2 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Silla();
		gp.obj[10].worldX = 9 * gp.tileSize;
		gp.obj[10].worldY = 2 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Silla();
		gp.obj[11].worldX = 11 * gp.tileSize;
		gp.obj[11].worldY = 2 * gp.tileSize;
		
		//Puerta Quiz piso 5
		
		gp.obj[12] = new OBJ_Salida_Quiz(new Quiz(
				"¿Qué hace un void en Java?",
				new String[]{"Devuelve un valor", "No devuelve ningún valor", "Crea una clase", "Borra una variable"},
				1
		));
		gp.obj[12].worldX = 12 * gp.tileSize;
		gp.obj[12].worldY = 2 * gp.tileSize;
		
		
		//Objetos de piso 4-----------------------------
		
		gp.obj[14] = new OBJ_Servidor_Two();
		gp.obj[14].worldX = 1 * gp.tileSize;
		gp.obj[14].worldY = 4 * gp.tileSize;
		
		gp.obj[15] = new OBJ_Servidor_One();
		gp.obj[15].worldX = 2 * gp.tileSize;
		gp.obj[15].worldY = 4 * gp.tileSize;
		
		gp.obj[16] = new OBJ_Pc_Letra_i();
		gp.obj[16].worldX = 4 * gp.tileSize;
		gp.obj[16].worldY = 3 * gp.tileSize;
		
		gp.obj[17] = new OBJ_Pc_Letra_w();
		gp.obj[17].worldX = 8 * gp.tileSize;
		gp.obj[17].worldY = 3 * gp.tileSize;
		
		gp.obj[18] = new OBJ_Pc_Letra_i();
		gp.obj[18].worldX = 9 * gp.tileSize;
		gp.obj[18].worldY = 3 * gp.tileSize;
		
		gp.obj[19] = new OBJ_Pc_Letra_l();
		gp.obj[19].worldX = 10 * gp.tileSize;
		gp.obj[19].worldY = 3 * gp.tileSize;
		
		gp.obj[20] = new OBJ_Pc_Letra_l();
		gp.obj[20].worldX = 11 * gp.tileSize;
		gp.obj[20].worldY = 3 * gp.tileSize;
			
		gp.obj[22] = new OBJ_Silla();
		gp.obj[22].worldX = 4 * gp.tileSize;
		gp.obj[22].worldY = 4 * gp.tileSize;
		
		gp.obj[23] = new OBJ_Silla();
		gp.obj[23].worldX = 9 * gp.tileSize;
		gp.obj[23].worldY = 4 * gp.tileSize;
		
		gp.obj[25] = new OBJ_Silla();
		gp.obj[25].worldX = 11 * gp.tileSize;
		gp.obj[25].worldY = 4 * gp.tileSize;
		
		//Puerta Quiz piso 4
		
		gp.obj[26] = new OBJ_Salida_Quiz(new Quiz(
				"¿Qué palabra clave se usa para heredar de una clase en Java?",
				new String[]{"implements", "extends", "inherits", "super"},
				1
		));
		gp.obj[26].worldX = 3 * gp.tileSize;
		gp.obj[26].worldY = 4 * gp.tileSize;
			
		
		//Objetos de piso 3-----------------------------
		
		gp.obj[27] = new OBJ_Pc_Letra_k();
		gp.obj[27].worldX = 9 * gp.tileSize;
		gp.obj[27].worldY = 5 * gp.tileSize;
		
		gp.obj[28] = new OBJ_Pc_Letra_i();
		gp.obj[28].worldX = 10 * gp.tileSize;
		gp.obj[28].worldY = 5 * gp.tileSize;
		
		gp.obj[29] = new OBJ_Pc_Letra_l();
		gp.obj[29].worldX = 11 * gp.tileSize;
		gp.obj[29].worldY = 5 * gp.tileSize;
		
		gp.obj[30] = new OBJ_Pc_Letra_l();
		gp.obj[30].worldX = 12 * gp.tileSize;
		gp.obj[30].worldY = 5 * gp.tileSize;
		
		gp.obj[31] = new OBJ_PC_Obj();
		gp.obj[31].worldX = 1 * gp.tileSize;
		gp.obj[31].worldY = 5 * gp.tileSize;
		
		gp.obj[32] = new OBJ_Servidor_Two();
		gp.obj[32].worldX = 13 * gp.tileSize;
		gp.obj[32].worldY = 5 * gp.tileSize;
		
		gp.obj[34] = new OBJ_Silla();
		gp.obj[34].worldX = 10 * gp.tileSize;
		gp.obj[34].worldY = 6 * gp.tileSize;
		
		gp.obj[36] = new OBJ_Silla();
		gp.obj[36].worldX = 12 * gp.tileSize;
		gp.obj[36].worldY = 6 * gp.tileSize;
		
		//Puerta Quiz piso 3
		
		gp.obj[37] = new OBJ_Salida_Quiz(new Quiz(
				"¿Cuál de estos es un tipo de dato primitivo en Java?",
				new String[]{"String", "int", "ArrayList", "Object"},
				1
		));
		gp.obj[37].worldX = 12 * gp.tileSize;
		gp.obj[37].worldY = 6 * gp.tileSize;
		
		
		//Objetos piso 2------------------------------
		
		gp.obj[38] = new OBJ_Pc_Letra_y();
		gp.obj[38].worldX = 8 * gp.tileSize;
		gp.obj[38].worldY = 7 * gp.tileSize;
		
		gp.obj[39] = new OBJ_Pc_Letra_o();
		gp.obj[39].worldX = 9 * gp.tileSize;
		gp.obj[39].worldY = 7 * gp.tileSize;
		
		gp.obj[40] = new OBJ_Pc_Letra_u();
		gp.obj[40].worldX = 10 * gp.tileSize;
		gp.obj[40].worldY = 7 * gp.tileSize;
		
		gp.obj[41] = new OBJ_Silla();
		gp.obj[41].worldX = 9 * gp.tileSize;
		gp.obj[41].worldY = 8 * gp.tileSize;
		
		//Puerta Quiz piso 2d
		
		gp.obj[42] = new OBJ_Salida_Quiz(new Quiz(
				"¿Qué significa POO?",
				new String[]{"Programación Orientada a Objetos", "Proceso de Optimización Online", "Patrón de Objetos", "Programa de Orden Ordenado"},
				0
		));
		gp.obj[42].worldX = 3 * gp.tileSize;
		gp.obj[42].worldY = 8 * gp.tileSize;
		
		//Objetos piso 1---------------------------------
		
		gp.obj[43] = new OBJ_Flores();
		gp.obj[43].worldX = 7 * gp.tileSize;
		gp.obj[43].worldY = 10 * gp.tileSize;
		
		gp.obj[44] = new OBJ_entrada();
		gp.obj[44].worldX = 8 * gp.tileSize;
		gp.obj[44].worldY = 9 * gp.tileSize;
		
		
	}

}
