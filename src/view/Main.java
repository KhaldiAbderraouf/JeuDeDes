package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	private Button New;
	private Button Load;
	private Button Scores;
	private Button Exit;
	private HBox Playout;
	private VBox Menu;
	private Plateau plateau;
	private Scene scene;
	
	public static void main(String[] args) throws Exception { launch(args); }
	  
	public void start(final Stage stage) throws Exception {
	    stage.setTitle("Slide out demo");
	    Playout=new HBox(10);
	    addPlateau("guest");
	    scene = new Scene(Playout);
	    stage.setScene(scene);
	    stage.show();
	  }
	  /*
	  private void initMenu(){
		  
		  New= new Button("NEW");
		  Load= new Button("LOAD");
		  Scores= new Button("SCORES");
		  Exit= new Button("EXIT");
		  
		  New.setOnAction(new EventHandler<ActionEvent>() {
			  @Override public void handle(ActionEvent actionEvent) {
				  addPlateau("guest");
			  }
		  });
		  
		  
		  Menu=new VBox(10);
		  Menu.getChildren().addAll(New,Load,Scores,Exit);
		  Playout=new HBox(10);
		  Playout.getChildren().add(Menu);
	  }
	  */
	  public void addPlateau(String j){
		  plateau = new Plateau(j);
		  Playout.getChildren().clear();
		  Playout.getChildren().add(plateau);
	  }
	  public void addMenu(String j){
		  
		  Playout.getChildren().clear();
		  Playout.getChildren().add(Menu);
	  }
	  
	  
}