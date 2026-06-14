package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pc_Letra_y extends SuperObject{
	
public OBJ_Pc_Letra_y() {
		
		name = "OBJ_Pc_Letra_y";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pc_letra_y.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
