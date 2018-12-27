package controler;

import java.util.ArrayList;
import java.util.List;

import model.Case;

public interface Builder {
	public void addligne(int n);
	public ArrayList<ArrayList<Case>> getResult();
	public Iterator getIterator();
}
