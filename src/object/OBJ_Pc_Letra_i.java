package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pc_Letra_i extends SuperObject {
	
public OBJ_Pc_Letra_i() {
		
		name = "OBJ_Pc_Letra_i";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pc_letra_i.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}


}
