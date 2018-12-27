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
	private int n; 
	
	
	public Partie(String joueur,int n,TerrainManager ts){
		this.joueur=new Joueur(joueur);
		this.score=new ScoreFromFiles();
		this.dep=new DeplacementManager();
		this.control=ts;
		this.n=n;
		
		control.createTerrain(n);
		this.joueur.setScore(score.getScore(this.joueur.getNom()));
		emplacement=0;
		scoreJ=0;
	}
	public void deplacer(){
		int empl=dep.deplacer(emplacement);
		int[] act =control.actionCase(empl);
		emplacement=dep.deplacer(empl, act[0]);
		scoreJ+=act[1];
		if(emplacement>n){
			fin();
		}
	}
	
	private void fin(){
		score.saveScore(joueur.getNom(),scoreJ);
	}
	
	public int getEmplacement() {
		return emplacement;
	}
	public int getScoreJ() {
		return scoreJ;
	}
	
}
