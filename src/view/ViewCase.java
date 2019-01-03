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
		this.setStyle("-fx-color:black; -fx-background-color:"+getColor()+";-fx-padding-left: 20px;");
		this.setMinSize(50, 50);
		
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
	private String getColor(){
		switch(couleur){
		case "rouge" :
			return "red";
		case "vert":
			return "green";
		case "bleu":
			return "blue";
		case "jaune":
			return "yelow";
		case "rose":
			return "pink";
		case "orange":
			return "orange";
		default:
			return "brown";
		}
	}
	
	public void black(){
		this.setStyle("-fx-color:white; -fx-background-color:black");
	}
}
