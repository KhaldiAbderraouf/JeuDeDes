package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

public class MenuPlateau extends Pane {
	private Label score;
	private Label joueur;
	private Button exit;
	private Button save;
	private Button jouer;
	private Label empl;
	
	public MenuPlateau(String j){
		score = new Label("0");
		empl= new Label("0");
		joueur = new Label(j);
		exit=new Button("EXIT");
		save=new Button("SAVE");
		jouer= new Button("LANCER");
		VBox h= new VBox(10);
		h.setMinWidth(200);
		h.getChildren().addAll(joueur,empl,score,jouer,save,exit);
		this.getChildren().add(h);
	}
	public void changeJ(String j){
		joueur.setText(j);
	}
	public int getScore() {
		return Integer.parseInt(score.getText());
	}
	public void setScore(int score) {
		this.score.setText(String.valueOf(score));
	}
	public void setEmpl(int empl) {
		this.empl.setText(String.valueOf(empl));
	}
	
	public Button getJouer(){
		return this.jouer;
	}
	public Button getSave(){
		return this.save;
	}
	public Button getExit(){
		return this.exit;
	}
	
}
