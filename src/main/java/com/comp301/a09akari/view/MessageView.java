package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.awt.*;

public class MessageView implements FXComponent {
  private AlternateMvcController controller;

  public MessageView(AlternateMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    StackPane pane = new StackPane();
    // Label winLabel = new Label("YOU WIN!");
    // pane.getChildren().add(winLabel);
    return pane;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
