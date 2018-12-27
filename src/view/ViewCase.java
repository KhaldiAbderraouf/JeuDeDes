package view;

import javafx.scene.control.Label;

public class ViewCase extends Label {
	private int num;
	public 	ViewCase(int num){
		this.setText( String.valueOf(num));
		this.num=num;
		setPositions();
	}
	private void setPositions(){
		
	}
}
