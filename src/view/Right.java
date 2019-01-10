package view;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Right extends State {
	
	public Right(Label label1){
		label1.setRotate(-180);
	}
	
	public State animate(int x1,int y1,int x,int y,Label label1,double d){
		if(x>x1){
	    	TranslateTransition t1 = new TranslateTransition(Duration.seconds(0.5),label1);
	    	t1.setToX(x);
	    	t1.setCycleCount(1);
	    	t1.setDelay(Duration.seconds(d));
	    	t1.play();
	    	if(y<y1){
	    		State p=new Up(label1);
	    		p.animate(x1,y1,x1, y, label1,d+0.5);
	    		return p;
	    	}else{
	    		return this;
	    	}
		}else{
			State p=new Up(label1);
    		p.animate(x1,y1,x, y, label1,d);
    		return p;
    	}
	}
	
}
