package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ControlView implements FXComponent {
  private AlternateMvcController controller;
  private FXComponent ControlTopView;
  private FXComponent ControlButtomView;

  public ControlView(AlternateMvcController controller) {
    this.controller = controller;
    this.ControlTopView = new ControlTopView(controller);
    this.ControlButtomView = new ControlButtomView(controller);
  }

  public Parent render() {
    BorderPane layout = new BorderPane();
    layout.getChildren().add(ControlTopView.render());
    layout.setBottom(ControlButtomView.render());
    return layout;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
