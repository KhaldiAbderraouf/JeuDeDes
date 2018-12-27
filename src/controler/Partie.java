package controler;

import model.De;
import model.Joueur;

public class Partie {

	private TerrainManager control;
	private DeplacementManager dep;
	private LoadScore score;
	private Joueur joueur;
	private int scoreJ ;
	private int emplacement;
	
	
	public Partie(String joueur,int n){
		this.joueur=new Joueur(joueur);
		this.score=new ScoreFromFiles();
		this.dep=new DeplacementManager();
		this.control=new TerrainSpiral();
		
		control.createTerrain(n);
		this.joueur.setScore(score.getScore());
		emplacement=0;
		scoreJ=0;
	}
	public void deplacer(){
		int empl=dep.deplacer(emplacement);
		int[] act =control.actionCase(empl);
		emplacement=dep.deplacer(empl, act[0]);
		scoreJ+=act[1];
	}
	public int getEmplacement() {
		return emplacement;
	}
	public int getScoreJ() {
		return scoreJ;
	}
	
}
