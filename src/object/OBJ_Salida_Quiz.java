package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Salida_Quiz extends SuperObject{
	
public OBJ_Salida_Quiz() {
		
		name = "OBJ_Salida_Quiz";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/salida_quiz.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}


}
