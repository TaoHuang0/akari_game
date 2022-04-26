package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;

public class ControlTopView implements FXComponent {
  private AlternateMvcController controller;

  public ControlTopView(AlternateMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    HBox layout = new HBox();

    Label switchPuzzleLabel = new Label("Switch Puzzle");
    Label randomPuzzleLabel = new Label("Get a Random Puzzle");
    Button switchPuzzleNextBut = new Button("NEXT");
    Button switchPuzzlePreviousBut = new Button("PREVIOUS");
    Button randomPuzzleBut = new Button("RANDOM");

    switchPuzzleNextBut.setOnAction(
        (ActionEvent event) -> {
          controller.clickNextPuzzle();
        });
    switchPuzzlePreviousBut.setOnAction(
        (ActionEvent event) -> {
          controller.clickPrevPuzzle();
        });
    randomPuzzleBut.setOnAction(
        (ActionEvent event) -> {
          controller.clickRandPuzzle();
        });

    layout.getChildren().add(switchPuzzleLabel);
    layout.getChildren().add(switchPuzzlePreviousBut);
    layout.getChildren().add(switchPuzzleNextBut);
    layout.getChildren().add(randomPuzzleLabel);
    layout.getChildren().add(randomPuzzleBut);

    return layout;
  }
    @Override
    public void update(Model model) {
        this.controller.setModel(model);
    }
}
