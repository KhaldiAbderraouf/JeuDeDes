package controler;

import java.util.ArrayList;
import java.util.List;

import model.*;
import java.util.Random;

public class TerrainBuilder implements Builder {
	
	private int n;
	private int[] nbcase = {0,0,0,0,0};
	private Case[] typeCase={new CaseBonus(),new CaseMalus(),new CaseImage(),new CaseDefinition(),new CaseSaut(),new CaseParcours()};
	private ArrayList<ArrayList<Case>> ensemble=new ArrayList<ArrayList<Case>>();
	public TerrainBuilder(int n){
		this.n=n;
	}
	
	public void addligne(int n){
		Random rn = new Random();
		ArrayList<Case> ligne = new ArrayList<Case>();
		for (int i=0;i<n;i++){
			switch (rn.nextInt(20)+1){
				case 1:
					ligne.add(getCase(0));
					break;
				case 2:
					ligne.add(getCase(1));
					break;
				case 3:
					ligne.add(getCase(2));
					break;
				case 4:
					ligne.add(getCase(3));
					break;
				case 5:
					ligne.add(getCase(4));
					break;
				default :
					ligne.add(getCase(5));
					break;
			}
		}
		ensemble.add(ligne);
		
	}
	
	private Case getCase(int i){
		if(i<5){
			if(nbcase[i]<5){
				nbcase[i]+=1;
				return typeCase[i];
			}
			else{
				for(int j=0;j<5;j++){
					if(nbcase[j]<5){
						nbcase[j]+=1;
						return typeCase[j];
					}
				}
				return typeCase[5];
			}
		}
		return typeCase[5];
	}
	
	public ArrayList<ArrayList<Case>> getResult(){
		CaseDepart d= new CaseDepart();
		CaseFin f = new CaseFin();
		ensemble.get(0).add(0,d);
		int i=ensemble.get(0).size()-1;
		ensemble.get(0).remove(i);
		i=ensemble.size()-1;
		int j=ensemble.get(i).size()-1;
		ensemble.get(i).add(j,f);
		ensemble.get(i).remove(j+1);
		
		return ensemble;
	}

}
