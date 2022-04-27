package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PuzzleView implements FXComponent {
  private AlternateMvcController controller;

  public PuzzleView(AlternateMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    // set up board
    GridPane board = new GridPane();
    board.setHgap(3);
    board.setVgap(3);
    board.getStyleClass().add("board");

    // set up grids
    for (int i = 0; i < controller.getActivePuzzle().getHeight(); i++) {
      for (int j = 0; j < controller.getActivePuzzle().getWidth(); j++) {
        if (controller.getActivePuzzle().getCellType(i, j) == CellType.CORRIDOR) {
          if (controller.isLamp(i, j)) {
            Button lamp = new Button();
            lamp.getStyleClass().add("lamp");
            board.add(lamp, i, j);
            int a = i;
            int b = j;
            lamp.setOnAction(
                (ActionEvent event) -> {
                  controller.clickCell(a, b);
                });
          } else if (controller.isLit(i, j)) {
            Button litButton = new Button();
            litButton.getStyleClass().add("litButton");
            board.add(litButton, i, j);
            int c = i;
            int d = j;
            litButton.setOnAction(
                (ActionEvent event) -> {
                  controller.clickCell(c, d);
                });
          } else {
            Button normalButton = new Button();
            normalButton.getStyleClass().add("normalButton");
            board.add(normalButton, i, j);
            int e = i;
            int f = j;
            normalButton.setOnAction(
                (ActionEvent event) -> {
                  controller.clickCell(e, f);
                });
          }
        }
        if (controller.getActivePuzzle().getCellType(i, j) == CellType.CLUE) {
          if (controller.isClueSatisfied(i, j)) {
            board.add(makeTile(controller.getActivePuzzle().getClue(i, j) + 7), i, j);
          } else {
            board.add(makeTile(controller.getActivePuzzle().getClue(i, j)), i, j);
          }
        }
        if (controller.getActivePuzzle().getCellType(i, j) == CellType.WALL) {
          board.add(makeTile(5), i, j);
        }
      }
    }
    return board;
  }

  private static Label makeTile(int num) {
    Label tile;
    if (num == 5) {
      tile = new Label();
    } else if (num >= 7) { // satisfy -7
      tile = new Label(String.valueOf(num - 7));
    } else {
      tile = new Label(String.valueOf(num));
    }
    tile.getStyleClass().add("tile");
    tile.getStyleClass().add("tile-" + num);
    return tile;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
