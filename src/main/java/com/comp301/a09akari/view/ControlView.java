package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ControlView implements FXComponent {
  private AlternateMvcController controller;

  public ControlView(AlternateMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    VBox layout = new VBox();
    HBox firstRow = new HBox();
    HBox secondRow = new HBox();
    HBox thirdRow = new HBox();
    Button resetPuzzleBut = new Button("Reset Current Puzzle");
    Button switchPuzzleNextBut = new Button(">>");
    Button switchPuzzlePreviousBut = new Button("<<");
    Button randomPuzzleBut = new Button("Random Puzzle");
    Label switchLabel = new Label("Switch Puzzle:");
    Label instructions =
        new Label("Place light bulbs on the grid to make every white square is lit!");
    Label totalPuzzlesIndex = new Label("Total Puzzles:");
    Label totalPuzzles = new Label(String.valueOf(controller.getTotalPuzzles()));
    Label puzzleIndex = new Label("You are in puzzle:");
    Label puzzlenow = new Label(String.valueOf(controller.puzzleIndex() + 1));

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
    resetPuzzleBut.setOnAction(
        (ActionEvent event) -> {
          controller.clickResetPuzzle();
        });
    firstRow.getChildren().add(switchLabel);
    firstRow.getChildren().add(switchPuzzlePreviousBut);
    firstRow.getChildren().add(switchPuzzleNextBut);
    secondRow.getChildren().add(randomPuzzleBut);
    secondRow.getChildren().add(resetPuzzleBut);
    thirdRow.getChildren().add(totalPuzzlesIndex);
    thirdRow.getChildren().add(totalPuzzles);
    thirdRow.getChildren().add(puzzleIndex);
    thirdRow.getChildren().add(puzzlenow);
    HBox.setHgrow(firstRow, Priority.ALWAYS);
    HBox.setHgrow(secondRow, Priority.ALWAYS);
    HBox.setHgrow(thirdRow, Priority.ALWAYS);
    layout.getChildren().add(firstRow);
    layout.getChildren().add(secondRow);
    layout.getChildren().add(thirdRow);
    layout.getChildren().add(instructions);

    puzzleIndex.getStyleClass().add("puzzleIndex");
    layout.getStyleClass().add("controllerLayout");
    switchLabel.getStyleClass().add("switchLabel");
    switchPuzzlePreviousBut.getStyleClass().add("switchPuzzlePreviousBut");
    switchPuzzleNextBut.getStyleClass().add("switchPuzzleNextBut");
    randomPuzzleBut.getStyleClass().add("randomPuzzleBut");
    resetPuzzleBut.getStyleClass().add("randomPuzzleBut");
    instructions.getStyleClass().add("instructions");
    totalPuzzlesIndex.getStyleClass().add("totalPuzzles");
    puzzleIndex.getStyleClass().add("totalPuzzles");
    totalPuzzles.getStyleClass().add("PuzzleNum");
    puzzlenow.getStyleClass().add("PuzzleNum");
    thirdRow.getStyleClass().add("PuzzleNumRow");
    return layout;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
