package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MessageView implements FXComponent {
  private AlternateMvcController controller;

  public MessageView(AlternateMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    VBox solvdeMes = new VBox();
    solvdeMes.getChildren().add(new Label("Congratulation, You Solved the Puzzle!"));
    solvdeMes.getStyleClass().add("solvdeMes");
    return solvdeMes;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
