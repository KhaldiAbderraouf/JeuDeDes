package view;

import controler.Partie;
import javafx.embed.swing.JFXPanel;


public class Plateau extends JFXPanel {
	private Pion pion=new Pion();
	private Terrain terrain;
	private MenuPlateau menu;
	private Partie partie;
	private int n=100;
	private String joueur;
	
	public Plateau(){
		terrain = new VTerrainSpiral();
		partie = new Partie(joueur,n,terrain.createTerrain(n));
	}
	
	public void deplacer(){
		partie.deplacer();
		int empl=partie.getEmplacement();
		int[] xy=terrain.getXY(empl);
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
}
