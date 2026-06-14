package main;

import object.OBJ_Pc_Principal;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp =  gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Pc_Principal();
		gp.obj[0].worldX = 1 * gp.tileSize;
		gp.obj[0].worldY = 1 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Pc_Principal();
		gp.obj[1].worldX = 2 * gp.tileSize;
		gp.obj[1].worldY = 1 * gp.tileSize;
		
	}

}
