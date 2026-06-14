package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Servidor_Two extends SuperObject{
	
public OBJ_Servidor_Two() {
		
		name = "OBJ_Servidor_Two";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/servidor_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
