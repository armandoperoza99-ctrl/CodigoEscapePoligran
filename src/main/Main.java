/*
*AUTORES:
*Diego Rosales Peroza 
*Laura Ruiz Mora 
*Ángel Sanabria Suarez 
*Martha Liliana Salazar Betancur 
*Laura Vanessa Romero Jiménez 
*/

package main;

import javax.swing.JFrame;

public class Main {
	
	 public static void main(String[] args){
		 
		 JFrame window = new JFrame();
		    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    window.setResizable(false);
		    window.setTitle("CODIGO ESCAPE");
		    
		    GamePanel gamePanel = new GamePanel();
		    window.add(gamePanel);

		    window.pack();

		    window.setLocationRelativeTo(null);
		    window.setVisible(true);
		    
		    gamePanel.setupGame();
		    gamePanel.startGameThread();
	 }
}
