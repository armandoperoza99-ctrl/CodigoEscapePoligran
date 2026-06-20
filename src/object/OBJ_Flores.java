package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Flores extends SuperObject{
	
public OBJ_Flores() {
		
		name = "OBJ_Flores";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/flores.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
