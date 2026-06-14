package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pc_Letra_u extends SuperObject{
	
public OBJ_Pc_Letra_u() {
		
		name = "OBJ_Pc_Letra_u";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pc_letra_u.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
