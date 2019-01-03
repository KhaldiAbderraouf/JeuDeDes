package view;

import controler.Partie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


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
		this.setCenter(terrain.getAll());
	}
	
	public void deplacer(){
		partie.deplacer();
		int empl=partie.getEmplacement();
		int[] xy=terrain.getXY(empl);
		menu.setScore(score());
		menu.setEmpl(empl);
		pion.deplacer(xy[0],xy[1]);
		
		if(empl==n){
			fin();
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
}
