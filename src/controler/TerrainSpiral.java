package controler;

import java.util.ArrayList;

import model.Case;

public class TerrainSpiral extends TerrainManager {
	private ArrayList<ArrayList<Case>> terrain;
	private int x=0;
	
	public void createTerrain(int n){
		x =getX(n);
		setMachine(new TerrainBuilder(n));
		int r= reste(n,x);
		int cpt1=0,cpt2=2;
		for(int i=1;i<=10;i++){
			if(i%2==0){
				getMachine().addligne(x-cpt1-cpt2);
				if(i%4==0){
					cpt1+=2;
				}
			}
			else{
				getMachine().addligne(x-cpt1);
			}
		}
		getMachine().addligne(r);
		terrain=getMachine().getResult();
	}
	public int getX(int n){
		return (int)((n+30)/11)+1;
	}
	public int reste(int n, int x){
		return ((n+26)-(x*10));
	}
	public int[] actionCase(int num){

		int index[]=getPos(num);
		int [] res = terrain.get(index[0]).get(index[1]).Action();
		return res;
	}
	
	public String getColor(int num){
		
		int index[]=getPos(num);
		String res = terrain.get(index[0]).get(index[1]).getCouleur().toString();
		return res;
	}
	
	public int[] getPos(int num){
		int res[]={0,0};
		int cpt1=0,cpt2=2;
		for(int i=1;i<=10;i++){
			if(i%2==0){
				if (num>=(x-cpt1-cpt2)){num=num-(x-cpt1-cpt2);}
				else{res[0]=i-1;res[1]=num; return res;}
				if(i%4==0){
					cpt1+=2;
				}
			}
			else{
				if (num>=(x-cpt1)){num=num-(x-cpt1);}
				else{res[0]=i-1;res[1]=num; return res;}
			}
		}
		res[0]=10;res[1]=num;
		return res;
	}
}
