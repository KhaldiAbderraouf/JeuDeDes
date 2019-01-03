package view;

import controler.MenuManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/** Example of a sidebar that slides in and out of view */
public class Menu extends Application {
	private MenuManager menuman;
	private Button controlButton;
  
  public static void main(String[] args) throws Exception { launch(args); }
  public void start(final Stage stage) throws Exception {
    stage.setTitle("Slide out demo");

    // place the content in the sidebar.
    SideBar sidebar = new SideBar();
    sidebar.setMinWidth(500);
    sidebar.setMinHeight(500);
    
    SideBar sidebar1 = new SideBar();
    sidebar1.setMinWidth(500);
    sidebar1.setMinHeight(500);
    

    // create a WebView to show to the right of the SideBar;
   
    // layout the scene.
    final StackPane layout = new StackPane();
    layout.setStyle("-fx-background-color: cornsilk; -fx-font-size: 20; -fx-padding: 10;");
    @SuppressWarnings("deprecation")
	boolean addAll = layout.getChildren().addAll(
      HBoxBuilder.create().spacing(10)
        .children(
          VBoxBuilder.create().spacing(10)
            .children(
              sidebar.getControlButton(),
              sidebar
            ).build(),
            VBoxBuilder.create().spacing(10)
            .children(
              sidebar1.getControlButton(),
              sidebar1
            ).build()
        ).build()
    );
    Scene scene = new Scene(layout);
    stage.setScene(scene);
    stage.show();
  }

  
  
}
