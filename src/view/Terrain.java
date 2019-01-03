package view;

import java.util.ArrayList;
import java.util.List;

import controler.TerrainManager;
import javafx.scene.layout.GridPane;

public abstract class Terrain {
	public abstract TerrainManager createTerrain(int n);
	public abstract ArrayList<ViewCase> getNextLine(int i);
	public abstract GridPane getAll();
	public abstract int[] getXY(int num);
}
