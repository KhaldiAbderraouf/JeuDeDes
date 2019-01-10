package view;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Up extends State {
	
	public Up(Label label1){
		label1.setRotate(-270);
	}

	@Override
	public State animate(int x1,int y1,int x,int y,Label label1,double d) {
    	if(y<y1){
	    	TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.5),label1);
	    	t1.setToY(y);
	    	t1.setDelay(Duration.seconds(d));
	    	t1.setCycleCount(1);
	    	t1.play();
	    	if(x<x1){
	    		State l=new Left(label1);
	    		l.animate(x1,y1,x, y1, label1,d+0.5);
	    		return l;
	    	}
	    	else{
	    		return this;
	    	}
    	}
    	State l=new Left(label1);
		l.animate(x1,y1,x, y, label1,d);
		return l;
	    	
	}
	
}
