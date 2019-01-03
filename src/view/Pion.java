package view;

import java.util.ArrayList;

import controler.Iimages;
import controler.ImagesFromFiles;
import javafx.scene.image.Image;

public class Pion {
	private int posX,posY;
	private ArrayList<Image> imgs= new ArrayList<Image>();
	private Iimages Iimgs=new ImagesFromFiles();
	private State state= new Left();
	public Pion(){
		posX=0;posY=0;
		imgs=Iimgs.getImages("pied");
	}
	
	public void deplacer(int x, int y){
		state.animate(x,y);
	}
	
}
