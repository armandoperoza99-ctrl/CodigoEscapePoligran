/*
*AUTORES:
*Diego Rosales Peroza 
*Laura Ruiz Mora 
*Ángel Sanabria Suarez 
*Martha Liliana Salazar Betancur 
*Laura Vanessa Romero Jiménez 
*/

package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	//ajustes de la pantalla y creacion de la misma

	final int originalTileSize = 16; //16x16bloques
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48 bloques
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768 pixeles
    public final int screenHeight = tileSize* maxScreenRow; //576 pixeles
    
  //FPS
    int FPS = 60;
    
    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this,keyH);
    
    public GamePanel(){

        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true); // con esto, este panel de juego se va a enfocar en recibir las respuesta
    }
    
	public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run() {

    double drawInterval = 1000000000/FPS; // 0.01666 sgundos
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    int drawCount = 0; 

    while (gameThread != null) {

        currentTime = System.nanoTime();

        delta += (currentTime - lastTime) / drawInterval;
        timer += (currentTime - lastTime);
        lastTime = currentTime;

        if (delta >= 1){
        	update();
            repaint();
            delta--;
            drawCount++;
    }

        if (timer >= 1000000000) {
            System.out.println("FPS: " + drawCount);
            drawCount = 0;
            timer = 0;
        }

    }
  }
    


	public void update() {
		
		player.update();


    }
    
    public void paintComponent(Graphics g){

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D)g;
    
    tileM.draw(g2);

    player.draw(g2);

    g2.dispose();

}
    public KeyHandler getKeyH() {
        return keyH;
    }
}
