package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ControlButtomView implements FXComponent {
  private AlternateMvcController controller;

  public ControlButtomView(AlternateMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    HBox layout = new HBox();
    Label resetPuzzleLabel = new Label("Reset Current Puzzle");
    Button resetPuzzleBut = new Button();
    layout.getChildren().add(resetPuzzleLabel);
    layout.getChildren().add(resetPuzzleBut);

    resetPuzzleBut.setOnAction(
        (ActionEvent event) -> {
          controller.clickResetPuzzle();
        });

    return layout;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
