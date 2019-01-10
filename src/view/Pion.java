package view;


import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pion {
	private int posX,posY;
	private State state;
	private Label label1;
	public Pion(){
		posX=0;posY=0;
		String path = "file:\\"+new File("src/Images/pion/pied2.png").getAbsolutePath();
		Image image = new Image(path,50,50,false,false);
	    label1 = new Label("");
	    label1.setGraphic(new ImageView(image));
		state= new Down(label1);
	}
	public Label getLabel(){
		return this.label1;
	}
	
	public int getX(){
		return posX;
	}
	public int getY(){
		return posY;
	}
	
	public void deplacer(int x1, int y1,int x, int y){
		if(x!=x1 || y!=y1)
		state=state.animate(x1*50,y1*50,x*50,y*50,label1,0);
		posX=x;posY=y;
	}
	
}
