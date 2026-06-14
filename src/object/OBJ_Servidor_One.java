package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Servidor_One extends SuperObject{
	
public OBJ_Servidor_One() {
		
		name = "OBJ_Servidor_One";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/servidor_1.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
