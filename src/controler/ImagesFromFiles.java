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
		
		File file = new File("src/Images/img"); 
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
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		File file = new File("src/Images/img");
		File[] files = file.listFiles();
		int r;
		cpt= files.length;
		for(int i =0;i<4;i++){
			r=rn.nextInt(cpt);
			while(res.contains(r)){
				r=rn.nextInt(cpt);
			}
			res.add(r);
			images.add(new Image("file:\\"+files[r].getAbsolutePath(),200,200,false,false));
			
		}	
		return images;
	}

}
