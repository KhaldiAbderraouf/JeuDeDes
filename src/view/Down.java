package view;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Down extends State{
	
	public Down(Label label1){
		label1.setRotate(-90);
	}
	
	public State animate(int x1,int y1,int x,int y,Label label1,double d){
    	if(y>y1){
	    	TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.5),label1);
	    	t1.setToY(y);
	    	t1.setCycleCount(1);
	    	t1.setDelay(Duration.seconds(d));
	    	t1.play();
	    	if(x>x1){
	    		State r=new Right(label1);
	    		r.animate(x1,y,x, y, label1,d+0.5);
	    		return r;
	    	}else{
	    		return this;
	    	}
    	}
    	else{
    		State r=new Right(label1);
    		r.animate(x1,y1,x, y, label1,d);
    		return r;
    	}
	}
}
