package controler;

import model.De;

public class DeplacementManager {
	private De de;
	private int nbDe=2;
	
	public DeplacementManager(){
		this.de= new De();
	}

	public int getNbDe() {
		return nbDe;
	}

	public void setNbDe(int nbDe) {
		this.nbDe = nbDe;
	}
	
	public int deplacer(int empl){
		int dep=0;
		for(int i=0;i<nbDe;i++){
			dep+=de.lancer();
		}
		return empl+dep;
	}
	public int deplacer (int empl, int dep){
		return empl+dep;
	}
	
}
