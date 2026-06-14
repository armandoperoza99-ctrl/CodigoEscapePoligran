package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pc_Principal extends SuperObject{
	
	public OBJ_Pc_Principal () {
		
		name = "Pc_Principal";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pc_principal.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
