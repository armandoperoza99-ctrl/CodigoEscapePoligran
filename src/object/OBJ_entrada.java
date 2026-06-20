package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_entrada extends SuperObject{
	
public OBJ_entrada() {
		
		name = "OBJ_Caja_One";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/entrada.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
