package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;

public class ImagesFromFiles implements Iimages {

	@Override
	public ArrayList<Image> getImages(String pion) {
		ArrayList<Image> images = new ArrayList<Image>();
		
		File file = new File("src/Images/pion");  
		String p=file.getAbsolutePath();
		File[] files = file.listFiles();  
		for (File f:files)  
		{  
			if(f.getAbsolutePath().contains(pion)){	 
				String path=f.getAbsolutePath();
				try {
					images.add(new Image(new FileInputStream(path)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(images.isEmpty()){
			images=getImages("pied");
		}
		return images;
	}

	@Override
	public ArrayList<Image> getImages() {
		
		ArrayList<Image> images = new ArrayList<Image>();
		
		Random rn = new Random();
		int cpt=0;
		
		File file = new File("../../Images/questions");  
		File[] files = file.listFiles();  
		for (File f:files)  
		{  
			if(rn.nextInt(100)>50){	 
				images.add(new Image(f.getAbsolutePath()));
				cpt++;
			}
			if(cpt>3) break;
		}
		return images;
	}

}
