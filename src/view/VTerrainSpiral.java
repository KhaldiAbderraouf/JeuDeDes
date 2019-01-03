package view;

import java.util.ArrayList;

import controler.TerrainSpiral;
import javafx.scene.layout.GridPane;

public class VTerrainSpiral extends Terrain {
	
	// 0 gauche, 1 haut, 2 droite, 3 bas.
	private int direction=0;
	
	private TerrainSpiral ts;
	private ArrayList<ViewCase> parcours=new ArrayList<ViewCase>();
	private ArrayList<Integer> edges = new ArrayList<Integer>();
	private int n=100;
	
	public VTerrainSpiral(){
		ts = new TerrainSpiral();
	}

	public TerrainSpiral createTerrain(int n) {
		this.n=n;
		ts.createTerrain(n);
		createTerrainS(n);
		return ts;
	}
	
	private void createTerrainS(int n){

		int num=0,x =getX(n);
		
		int cpt1=0,cpt2=2;
		int i;
		for(i=1;i<=10;i++){
			if(i%2==0){
				if(i%4==0){
					num+=(x-cpt1-cpt2);
					edges.add(num-1);
					cpt1+=2;
				}
				else{
					num+=(x-cpt1-cpt2);
					edges.add(num);
				}
			}
			else{
				num+=(x-cpt1);
				edges.add(num);
			}
		}
		int[] pos={0,0};
		parcours.add(new ViewCase(pos[0],pos[1],0,ts.getColor(0)));
		for(i=1;i<n;i++){
			pos=next(pos[0],pos[1],i);
			parcours.add(new ViewCase(pos[0],pos[1],i,ts.getColor(i)));
		}
	}
	private int getX(int n){
		return (int)((n+30)/11)+1;
	}
	private int[] next(int x, int y,int num){
		int[]res={x,y};
		switch(direction){
			case 0:
				res[0]=x+1;
				break;
			case 1:
				res[1]=y+1;
				break;
			case 2:
				res[0]=x-1;
				break;
			case 3:
				res[1]=y-1;
				break;
		}
		if(edges.contains(num)){changeDir();}
		return res;
	}
	private void changeDir(){
		direction=(direction+1)%4;
	}
	
	public int[] getXY(int num){
		int[] res= {parcours.get(n-1).getX(),parcours.get(n-1).getY()};
		if(num<n){
			res[0]=parcours.get(num).getX();
			res[1]=parcours.get(num).getY();
		}
		blacken(num);
		return res;
	}
	
	public ArrayList<ViewCase> getNextLine(int i){
		ArrayList<ViewCase> ligne = new ArrayList<ViewCase>();
		int min=n;
		if(edges.get(i+1)!=null){min=edges.get(i+1);}
		for(int j=edges.get(i);j<=min;j++){
			ligne.add(parcours.get(j));
		}
		return ligne;
	}
	public GridPane getAll(){
		GridPane g = new GridPane();
		
		ViewCase c;
		int min=n;
		for(int j=0;j<min;j++){
			c=parcours.get(j);
			g.add(c,c.getY(),c.getX());
		}
		return g;
	}
	
	private void blacken(int num){
		parcours.get(num).black();
	}
}
