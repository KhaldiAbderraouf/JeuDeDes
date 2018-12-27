package view;

import controler.Partie;
import javafx.embed.swing.JFXPanel;


public class Plateau extends JFXPanel {
	private Pion pion=new Pion();
	private Terrain terrain;
	private MenuPlateau menu;
	private Partie partie;
	private int n=100;
	
	public Plateau(){
		terrain = new VTerrainSpiral(n);
	}
	
}
