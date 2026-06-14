package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pizarra extends SuperObject {
	
	public OBJ_Pizarra () {
		
		name = "OBJ_Pizarra";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/OBJ_Pizarra.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
