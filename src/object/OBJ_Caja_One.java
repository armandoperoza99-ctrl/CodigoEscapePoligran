package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Caja_One extends SuperObject{
	
	public OBJ_Caja_One() {
		
		name = "OBJ_Caja_One";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/caja_1.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
