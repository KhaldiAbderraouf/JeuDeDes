package controler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class ImagesFromFiles implements Iimages {

	@Override
	public ArrayList<Image> getImages(String pion) {
		ArrayList<Image> images = new ArrayList<Image>();
		
		File file = new File("../../Images");  
		File[] files = file.listFiles();  
		for (File f:files)  
		{  
			if(f.getAbsolutePath().contains(pion)){	 
				images.add(new Image(f.getAbsolutePath()));
			}
		}
		if(images.isEmpty()){
			images=getImages("pion");
		}
		return images;
	}

}
