package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Silla extends SuperObject{
	
public OBJ_Silla() {
		
		name = "OBJ_Silla";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/silla.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
