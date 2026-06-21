package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.Quiz;

public class OBJ_Salida_Quiz extends SuperObject {
	
	public Quiz quiz;
	public boolean answered = false;
	
	public OBJ_Salida_Quiz(Quiz quiz) {
		this.quiz = quiz;
		name = "OBJ_Salida_Quiz";
		collision = true;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/salida_quiz.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}