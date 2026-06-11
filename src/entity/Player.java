/*
*AUTORES:
*Diego Rosales Peroza 
*Laura Ruiz Mora 
*Ángel Sanabria Suarez 
*Martha Liliana Salazar Betancur 
*Laura Vanessa Romero Jiménez 
*/

package entity;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{ //configuraciones del jugador
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.tileSize * 4;
		screenY = gp.tileSize * 1;
		
		//Acá establecemos el area de colison del jugados
		solidArea = new Rectangle(16, 16, 40 , 40);
		
		setDefaultValues();
		getPlayerImage();
		
	}
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 4;
		worldY = gp.tileSize * 1;
		speed = 4;
		direction = "down";


	} 
	
	
	//imagene del jugador moviendose
	public void getPlayerImage() {
		
		try { //imagenes que usara el programa cuando el jugador camine hacia arriba
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/scientist_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/scientist_up_2.png"));
			  //imagenes cuando camine hacia abajo
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/scientist_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/scientist_down_2.png"));
			  //imagenes cuando camine hacia la derecha
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/scientist_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/scientist_right_2.png"));
			//imagenes que usara el programa cuando el jugador camine a la izquierda
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/scientist_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/scientist_left_2.png"));
	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//movimientos al presionar la tecla
	
	public void update () {
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true) {
			
	        if(keyH.upPressed == true) {
	        	direction = "up";        	
	        }
	         else if(keyH.downPressed == true) {
	        	 direction = "down";	        	 
	        }
	         else if(keyH.leftPressed == true) {
	        	 direction = "left";	        	 
	        }
	         else if(keyH.rightPressed == true) {
	        	 direction = "right";	        	 
	        }
	        //check tile collision
	        collisionOn = false;
	        gp.cChecker.checkTile(this);
	        
	        // si la colision es falsa, el jugador se puede mover
	        
	        if(collisionOn == false) {
	        	
	        	switch(direction) {
	    		case "up":
	    			worldY -= speed;
	    			break;
	    		case "down":
	    			worldY += speed;
	    			break;
	    		case "left":
	    			worldX -= speed;
	    			break;
	    		case "right":
	    			worldX += speed;
	    			break;
	        }
	        }
	        spriteCounter++;
	        if (spriteCounter > 18) { //mientras mas alto el numero mas lento es
	        	if (spriteNum == 1) {
	        		spriteNum = 2;
	        		
	        	}
	        	else if (spriteNum == 2) {
	        		spriteNum = 1;
	        	}
	        	spriteCounter = 0;
	        }				
		}
}
	public void draw(Graphics2D g2) {
		
	//	g2.setColor(Color.white); YA SE USÓ

	 //   g2.fillRect(x, y, gp.tileSize, gp.tileSize); YA SE USÓ
		
		
		
		// en caso de que vaya a cierta dirección se carga la imagen especifica 1 y 2
		
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
				}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
				}
			if (spriteNum == 2) {
				image = left2;
				}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
				}
			if (spriteNum == 2) {
				image = right2;
				}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}
}
	
	
