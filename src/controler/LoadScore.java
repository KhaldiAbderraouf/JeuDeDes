package controler;

import java.util.ArrayList;

public interface LoadScore {
	public ArrayList<Integer> getScore(String name);
	public void saveScore(String name,int...scores);
	
}
