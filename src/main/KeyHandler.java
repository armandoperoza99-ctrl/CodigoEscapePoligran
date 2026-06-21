package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();

		if (gp.gameState == gp.playState) {

			if (code == KeyEvent.VK_W) upPressed = true;
			if (code == KeyEvent.VK_S) downPressed = true;
			if (code == KeyEvent.VK_A) leftPressed = true;
			if (code == KeyEvent.VK_D) rightPressed = true;

		} else if (gp.gameState == gp.quizState) {

			if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) gp.ui.moveSelectionUp();
			if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) gp.ui.moveSelectionDown();
			if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) gp.ui.confirmSelection();
		} else if (gp.gameState == gp.winState || gp.gameState == gp.loseState) {
			if (code == KeyEvent.VK_ENTER) {
				gp.resetGame();
			}
		}
		
		if ((gp.gameState == gp.winState || gp.gameState == gp.loseState)
		        && code == KeyEvent.VK_ENTER) {

		    gp.resetGame();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) upPressed = false;
		if (code == KeyEvent.VK_S) downPressed = false;
		if (code == KeyEvent.VK_A) leftPressed = false;
		if (code == KeyEvent.VK_D) rightPressed = false;
	}
}