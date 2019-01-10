package view;

import java.util.ArrayList;
import java.util.Random;

import controler.Iimages;
import controler.ImagesFromFiles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ImageQuestion extends QuestionView {
	int[]res={0,0};
	ArrayList<Button> btn = new ArrayList<Button>();
	Text t;
	@Override
	public int[] showQuestion() {
		Iimages repo = new ImagesFromFiles();
        ArrayList<Image> l= repo.getImages();
        for(int i =0; i<4;i++){
        	btn.add( new Button());
        	btn.get(i).setGraphic(new ImageView(l.get(i)));
        }
    	Random rn = new Random();
    	int i = rn.nextInt(4);
    	String s =l.get(i).impl_getUrl();
    	String r[] = s.split("/");
    	String c = r[r.length-1];
    	c=c.replace(".jpg", "");
    	t= new Text(c);
        imagePopupWindowShow(i);
        System.out.println(res[0]+" "+res[1]);
		return res;
	}
	
	public void imagePopupWindowShow(int i) {
		 
    	Stage stage = new Stage();
    	
    	 EventHandler<ActionEvent> h =new EventHandler<ActionEvent>() {
    			@Override
    				public void handle(ActionEvent actionEvent) {
    					if(btn.indexOf(actionEvent.getSource())==i)
    					{
        					res[0]=4;res[1]=20;
    					}
    					else{
    						res[0]=0;res[1]=-10;
    					}
    					stage.close();
    				}
    			};
    	
    	btn.get(0).setOnAction(h);
    	btn.get(1).setOnAction(h);
    	btn.get(2).setOnAction(h);
    	btn.get(3).setOnAction(h);
    	
    	HBox imgs = new HBox(10);
    	imgs.getChildren().addAll(btn.get(0),btn.get(1),btn.get(2),btn.get(3));
    	
    	
    	
    	VBox diag = new VBox(10);
    	diag.getChildren().add(imgs);
    	diag.getChildren().add(t);
    	Scene scene=new Scene(diag);
        stage.setScene(scene);
        stage.setOnCloseRequest(
            e -> {
            	
                e.consume();
                stage.close();
            }
        );
        
       
		
		stage.showAndWait();
    }

}
