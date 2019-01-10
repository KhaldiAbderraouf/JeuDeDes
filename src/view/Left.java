package view;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Left extends State {
	
	public Left(Label label1){
		label1.setRotate(0);
	}
	public State animate(int x1,int y1,int x,int y,Label label1,double d){
		
    	if(x<x1){
	    	TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.5),label1);
	    	t1.setToX(x);
	    	t1.setCycleCount(1);
	    	t1.setDelay(Duration.seconds(d));
	    	t1.play();
	    	if(y>y1){
	    		State dw =new Down(label1);
	    		dw.animate(x1,y1,x1,y, label1,d+0.5);
	    		return dw;
	    	}else{
	    		return this;
	    	}
    	}
    	else{
    		State dw =new Down(label1);
    		dw.animate(x1,y1,x,y, label1,d);
    		return dw;
    	}
	}
	
}
