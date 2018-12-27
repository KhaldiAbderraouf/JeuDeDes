package model;

import java.util.ArrayList;
import java.util.Collections;

public class Joueur {
	private String nom;
	private ArrayList<Integer> score=new ArrayList<Integer>();
	public Joueur(String nom){
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}

	public ArrayList<Integer> score() {
		Collections.sort(score);
		return score;
	}

	public void setScore(ArrayList<Integer> score) {
		this.score = score;
		Collections.sort(score);
	}
	public int getHighScore(){
		return score.get(score.size());
	}
	public void addScore(int s){
		score.add(s);
		Collections.sort(score);
	}
}
