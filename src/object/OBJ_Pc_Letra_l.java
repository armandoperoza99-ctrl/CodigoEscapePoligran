package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pc_Letra_l extends SuperObject{
	
public OBJ_Pc_Letra_l() {
		
		name = "OBJ_Pc_Letra_l";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pc_letra_l.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
