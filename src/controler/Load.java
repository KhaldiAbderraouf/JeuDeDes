package controler;

import java.util.ArrayList;

public interface Load {
	public ArrayList<Integer> getScore(String name);
	public void saveScore(String name,int scores);
	
}
