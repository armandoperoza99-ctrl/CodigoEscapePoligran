package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener{ //configuración de estandras desde el teclado para mover jugador

		
		 public boolean upPressed, downPressed, leftPressed, rightPressed;
		 
		 @Override
		    public void keyTyped(KeyEvent e) {
			 

		    }
		 @Override
		    public void keyPressed(KeyEvent e) { //configuracion de comando del teclado

		        int code = e.getKeyCode();

		        if(code == KeyEvent.VK_W) { //ir arriba cuando presionen W
		            upPressed = true;

		        }
		        if(code == KeyEvent.VK_S) { //ir abajo cuando presionen S
		            downPressed = true;
		            
		        }
		        if(code == KeyEvent.VK_A) { //ir a la izquierda cuando presionen A
		            leftPressed = true;
		            
		        }
		        if(code == KeyEvent.VK_D) { //ir a la derecha cuando presiones D
		            rightPressed = true;
		            
		        }  //sin no se está presionando ninguna tecla el jugador no deberia moverse
		    }
		 @Override
		    public void keyReleased(KeyEvent e) {
		        
		        int code = e.getKeyCode();{

		        if(code == KeyEvent.VK_W) {
		            upPressed = false;

		        }
		        if(code == KeyEvent.VK_S) {
		            downPressed = false;
		            
		        }
		        if(code == KeyEvent.VK_A) {
		            leftPressed = false;
		            
		        }
		        if(code == KeyEvent.VK_D) {
		            rightPressed = false;
		            
		        } 
	  } 
	}

}
