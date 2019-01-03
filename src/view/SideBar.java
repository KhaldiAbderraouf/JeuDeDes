package view;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

class SideBar extends VBox {
    /** @return a control button to hide and show the sidebar */
    public Button getControlButton() { return controlButton; }
    private final Button controlButton;

    /** creates a sidebar containing a vertical alignment of the given nodes */
    SideBar(Node... nodes) {
      // create a bar to hide and show.
      setAlignment(Pos.CENTER);
      setStyle("-fx-padding: 10; -fx-background-color: linear-gradient(to bottom, lavenderblush, mistyrose); -fx-border-color: derive(mistyrose, -10%); -fx-border-width: 3;");
      getChildren().addAll(nodes);

      // create a button to hide and show the sidebar.
      controlButton = new Button("Hide");
      controlButton.setMaxWidth(Double.MAX_VALUE);
      controlButton.setTooltip(new Tooltip("Play sidebar hide and seek"));
   
      // apply the animations when the button is pressed.
      controlButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent actionEvent) {
          // create an animation to hide sidebar.
          final double startWidth = getWidth();
          final Animation hideSidebar = new Transition() {
            { setCycleDuration(Duration.millis(250)); }
            protected void interpolate(double frac) {
              final double curWidth = startWidth * (1.0 - frac);
              setTranslateX(-startWidth + curWidth);
            }
          };
          hideSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
              setVisible(false);
              controlButton.setText("Show");
            }
          });
  
          // create an animation to show a sidebar.
          final Animation showSidebar = new Transition() {
            { setCycleDuration(Duration.millis(250)); }
            protected void interpolate(double frac) {
              final double curWidth = startWidth * frac;
              setTranslateX(-startWidth + curWidth);
            }
          };
          showSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
              controlButton.setText("Hide");
            }
          });
  
          if (showSidebar.statusProperty().get() == Animation.Status.STOPPED && hideSidebar.statusProperty().get() == Animation.Status.STOPPED) {
            if (isVisible()) {
              hideSidebar.play();
            } else {
              setVisible(true);
              showSidebar.play();
            }
          }
        }
      });
    }
  }
