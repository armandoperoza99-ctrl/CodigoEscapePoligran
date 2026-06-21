package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_entrada extends SuperObject{
	
public OBJ_entrada() {
		
		// anterior
//		name = "OBJ_Caja_One";
//		try {
//			image = ImageIO.read(getClass().getResourceAsStream("/objects/entrada.png"));
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	
		name = "OBJ_Caja_One";
	
	    collision = false;
	
	    solidArea.x = -24;
	    solidArea.y = -24;
	    solidArea.width = 96;
	    solidArea.height = 96;
	
	    try {
	        image = ImageIO.read(
	            getClass().getResourceAsStream("/objects/entrada.png"));
	    }
	    catch(IOException e) {
	        e.printStackTrace();
	    }
		
	}

}
