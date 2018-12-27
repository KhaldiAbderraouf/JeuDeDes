package controler;

import java.util.ArrayList;
import java.util.List;

import model.*;
import java.util.Random;

public class TerrainBuilder implements Builder {
	private int x;
	private int n;
	private Case[] typeCase={new CaseBonus(),new CaseMalus(),new CaseImage(),new CaseDefinition(),new CaseSaut(),new CaseParcours()};
	private ArrayList<ArrayList<Case>> ensemble=new ArrayList<ArrayList<Case>>();
	public TerrainBuilder(int ext,int n){
		this.x=ext;
		this.n=n;
	}
	
	public void addligne(int n){
		Random rn = new Random();
		ArrayList<Case> ligne = new ArrayList<Case>();
		for (int i=0;i<n;i++){
			switch (rn.nextInt(20)+1){
				case 1:
					ligne.add(typeCase[0]);
					break;
				case 2:
					ligne.add(typeCase[1]);
					break;
				case 3:
					ligne.add(typeCase[2]);
					break;
				case 4:
					ligne.add(typeCase[3]);
					break;
				case 5:
					ligne.add(typeCase[4]);
					break;
				default :
					ligne.add(typeCase[5]);
					break;
			}
		}
		ensemble.add(ligne);
		
	}
	public ArrayList<ArrayList<Case>> getResult(){
		CaseDepart d= new CaseDepart();
		CaseFin f = new CaseFin();
		ensemble.get(0).add(0,d);
		ensemble.get(0).remove(ensemble.get(0).size()-1);

		ensemble.get(ensemble.size()-1).add(ensemble.get(ensemble.size()-1).size()-1,f);
		ensemble.get(ensemble.size()-1).remove(ensemble.get(ensemble.size()-1).size()-1);
		
		return ensemble;
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new LLIterator();
	}
}
