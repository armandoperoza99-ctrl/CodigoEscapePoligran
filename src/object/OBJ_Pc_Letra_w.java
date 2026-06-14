package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pc_Letra_w extends SuperObject{
	
public OBJ_Pc_Letra_w() {
		
		name = "OBJ_Pc_Letra_w";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pc_letra_w.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
