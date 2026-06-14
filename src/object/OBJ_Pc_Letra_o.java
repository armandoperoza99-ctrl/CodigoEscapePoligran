package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pc_Letra_o extends SuperObject{
	
public OBJ_Pc_Letra_o() {
		
		name = "OBJ_Pc_Letra_o";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pc_letra_o.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
