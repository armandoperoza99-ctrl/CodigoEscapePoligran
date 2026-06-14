package main;

import object.OBJ_PC_Obj;
import object.OBJ_Pc_Letra_i;
import object.OBJ_Pc_Letra_k;
import object.OBJ_Pc_Letra_l;
import object.OBJ_Pc_Letra_w;
import object.OBJ_Pc_Principal;
import object.OBJ_Pizarra;
import object.OBJ_Servidor_One;
import object.OBJ_Servidor_Two;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp =  gp;
	}
	
	public void setObject() {
		
		//Objetos de piso 5
		
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
		
		//Objetos de piso 4
		
		gp.obj[8] = new OBJ_Servidor_Two();
		gp.obj[8].worldX = 1 * gp.tileSize;
		gp.obj[8].worldY = 4 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Servidor_One();
		gp.obj[9].worldX = 2 * gp.tileSize;
		gp.obj[9].worldY = 4 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Pc_Letra_i();
		gp.obj[10].worldX = 4 * gp.tileSize;
		gp.obj[10].worldY = 3 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Pc_Letra_w();
		gp.obj[11].worldX = 8 * gp.tileSize;
		gp.obj[11].worldY = 3 * gp.tileSize;
		
		gp.obj[12] = new OBJ_Pc_Letra_i();
		gp.obj[12].worldX = 9 * gp.tileSize;
		gp.obj[12].worldY = 3 * gp.tileSize;
		
		gp.obj[14] = new OBJ_Pc_Letra_l();
		gp.obj[14].worldX = 10 * gp.tileSize;
		gp.obj[14].worldY = 3 * gp.tileSize;
		
		gp.obj[15] = new OBJ_Pc_Letra_l();
		gp.obj[15].worldX = 11 * gp.tileSize;
		gp.obj[15].worldY = 3 * gp.tileSize;
		
		gp.obj[16] = new OBJ_Servidor_One();
		gp.obj[16].worldX = 14 * gp.tileSize;
		gp.obj[16].worldY = 4 * gp.tileSize;
		
		//Objetos de piso 3
		
		gp.obj[17] = new OBJ_Pc_Letra_k();
		gp.obj[17].worldX = 9 * gp.tileSize;
		gp.obj[17].worldY = 5 * gp.tileSize;
		
		gp.obj[18] = new OBJ_Pc_Letra_i();
		gp.obj[18].worldX = 10 * gp.tileSize;
		gp.obj[18].worldY = 5 * gp.tileSize;
		
		gp.obj[19] = new OBJ_Pc_Letra_l();
		gp.obj[19].worldX = 11 * gp.tileSize;
		gp.obj[19].worldY = 5 * gp.tileSize;
		
		gp.obj[20] = new OBJ_Pc_Letra_l();
		gp.obj[20].worldX = 12 * gp.tileSize;
		gp.obj[20].worldY = 5 * gp.tileSize;
		
		gp.obj[21] = new OBJ_PC_Obj();
		gp.obj[21].worldX = 1 * gp.tileSize;
		gp.obj[21].worldY = 5 * gp.tileSize;
		
		gp.obj[22] = new OBJ_Servidor_Two();
		gp.obj[22].worldX = 13 * gp.tileSize;
		gp.obj[22].worldY = 5 * gp.tileSize;
		
	}

}
