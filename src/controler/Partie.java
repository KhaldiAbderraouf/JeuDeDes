package controler;

import model.De;
import model.Joueur;

public class Partie {

	private TerrainManager control;
	private DeplacementManager dep;
	private Load score;
	private Joueur joueur;
	private int scoreJ ;
	private int emplacement;
	private int n; 
	
	
	public Partie(String joueur,int n,TerrainManager ts){
		this.joueur=new Joueur(joueur);
		this.score=new LoadFromFiles();
		this.dep=new DeplacementManager();
		this.control=ts;
		this.n=n;
		this.joueur.setScore(score.getScore(this.joueur.getNom()));
		emplacement=0;
		scoreJ=0;
	}
	public void deplacer(){
		//int empl=dep.deplacer(emplacement);
		int empl=emplacement+1;
		int[] act={0,0};
		while(empl!=emplacement){
			System.out.println(empl);
			try{ 
				act =control.actionCase(empl);
				System.out.println(control.getColor(empl));
			}catch(IndexOutOfBoundsException e){
				act=control.actionCase(n-1);
			}
			emplacement=dep.deplacer(empl, act[0]);
			scoreJ+=act[1];
			if(emplacement>n){
				fin();
				emplacement=n;
			}
			empl=emplacement;
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
