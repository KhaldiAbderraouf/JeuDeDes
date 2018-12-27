package view;

import java.util.List;

import controler.Iimages;
import javafx.scene.image.Image;

public class Pion {
	private int posX,posY;
	private List<Image> imgs;
	private Iimages Iimgs;
	private State state= new Left();
	public Pion(){
		posX=0;posY=0;
		imgs=Iimgs.getImages("pied");
	}
	
}
