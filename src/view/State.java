package view;

import javafx.scene.control.Label;

public abstract class State {
	public abstract State animate(int x1,int y1,int x,int y,Label label1,double d);
}
