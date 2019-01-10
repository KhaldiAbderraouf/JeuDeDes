package view;

import controler.Partie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class Plateau extends BorderPane {
	private Pion pion=new Pion();
	private Terrain terrain;
	private MenuPlateau menu;
	private Partie partie;
	private int n=100;
	private String joueur;
	
	public Plateau(String j){
		joueur=j;
		terrain = new VTerrainSpiral();
		partie = new Partie(joueur,n,terrain.createTerrain(n));
		menu=new MenuPlateau(joueur);
		this.setLeft(menu);
		setActions();
		Pane stack = new Pane();
		stack.getChildren().addAll(terrain.getAll(),pion.getLabel());
		pion.getLabel().toFront();
		this.setCenter(stack);
		
	}
	
	public void deplacer(){
		partie.deplacer();
		int empl=partie.getEmplacement();
		int[] xy=terrain.getXY(empl);
		
		menu.setScore(score());
		menu.setEmpl(empl);
		if(empl<n){
			pion.deplacer(pion.getX(),pion.getY(),xy[1],xy[0]);
		}else{
			xy=terrain.getXY(n-1);
			pion.deplacer(pion.getX(),pion.getY(),xy[1],xy[0]);
			if(empl==n){
				fin();
			}
		}
	}
	public void fin(){
		//afficher page de fin
	}
	
	public int score(){
		return partie.getScoreJ();
	}
	private void setActions(){
		menu.getJouer().setOnAction(new EventHandler<ActionEvent>() {
			  @Override public void handle(ActionEvent actionEvent) {
				  deplacer();
			  }
		  });
	}
	public Button getExit(){
		return menu.getExit();
	}
}
