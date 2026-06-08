package entity;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{ //configuraciones del jugador
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
		
	}
	
	public void setDefaultValues() {
		
		x = 100;
		y = 100;
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
	            y -= speed;
	        }
	         else if(keyH.downPressed == true) {
	        	 direction = "down";
	            y += speed;
	        }
	         else if(keyH.leftPressed == true) {
	        	 direction = "left";
	            x -= speed;
	        }
	         else if(keyH.rightPressed == true) {
	        	 direction = "right";
	            x += speed;
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
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}
}
	
	
