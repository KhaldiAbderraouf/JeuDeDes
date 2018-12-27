package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class ViewCase extends Label {
	private int x,y;
	Canvas c;
	private String couleur;
	
	public 	ViewCase(int x, int y,int num,String couleur){
		this.setText( String.valueOf(num));
		this.x=x;
		this.y=y;
		this.couleur=couleur;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public String getCouleur() {
		return couleur;
	}
}
