package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pc_Letra_k extends SuperObject {
	
public OBJ_Pc_Letra_k() {
		
		name = "OBJ_Pc_Letra_k";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pc_letra_k.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
