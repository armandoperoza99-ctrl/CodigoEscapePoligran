package main;

import entity.Entity;
import java.awt.Rectangle;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker (GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}	
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
	}
	
	public int checkObject(Entity entity, boolean isPlayer) {
		int index = -1;
		for (int i = 0; i < gp.obj.length; i++) {
			if (gp.obj[i] != null) {

				Rectangle objRect = new Rectangle(
						gp.obj[i].worldX + gp.obj[i].solidArea.x,
						gp.obj[i].worldY + gp.obj[i].solidArea.y,
						gp.obj[i].solidArea.width,
						gp.obj[i].solidArea.height);

				int nextWorldX = entity.worldX;
				int nextWorldY = entity.worldY;

				switch (entity.direction) {
				case "up":
				    nextWorldY -= entity.speed;
				    break;

				case "down":
				    nextWorldY += entity.speed;
				    break;

				case "left":
				    nextWorldX -= entity.speed;
				    break;

				case "right":
				    nextWorldX += entity.speed;
				    break;
				}

				Rectangle nextRect = new Rectangle(
						nextWorldX + entity.solidArea.x,
						nextWorldY + entity.solidArea.y,
						entity.solidArea.width,
						entity.solidArea.height);
				
				Rectangle currentRect = new Rectangle(
				        entity.worldX + entity.solidArea.x,
				        entity.worldY + entity.solidArea.y,
				        entity.solidArea.width,
				        entity.solidArea.height);

				if (currentRect.intersects(objRect) || nextRect.intersects(objRect)) {

				    if (gp.obj[i].collision) {
				        entity.collisionOn = true;
				    }

				    if (isPlayer) {
				        index = i;
				    }
				}
			}
		}
		return index;
	}

}
