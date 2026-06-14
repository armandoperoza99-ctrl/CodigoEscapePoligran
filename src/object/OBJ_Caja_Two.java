package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Caja_Two extends SuperObject {
	
public OBJ_Caja_Two() {
		
		name = "OBJ_Caja_Two";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/caja_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
