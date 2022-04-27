package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        System.out.println("P1");
        if (controller.getActivePuzzle().getCellType(i, j) == CellType.CORRIDOR) {
          if (controller.isLamp(i, j)) {
            System.out.println("P2");
            Button lamp = new Button("U+1F4A1");
            lamp.getStyleClass().add("lamp");
            board.add(lamp, i, j);
            int a = i;
            int b = j;
            lamp.setOnAction(
                (ActionEvent event) -> {
                  controller.clickCell(a, b);
                });
            System.out.println("P3");
          } else if (controller.isLit(i, j)) {
            System.out.println("P4");
            Button litButton = new Button();
            litButton.getStyleClass().add("litButton");
            board.add(litButton, i, j);
            int c = i;
            int d = j;
            litButton.setOnAction(
                (ActionEvent event) -> {
                  controller.clickCell(c, d);
                });
            System.out.println("P5");
          } else {
            System.out.println("P6");
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
          System.out.println("P7");
        }
        if (controller.getActivePuzzle().getCellType(i, j) == CellType.CLUE) {
          System.out.println("P8");
          if (controller.isClueSatisfied(i, j)) {
            System.out.println("P9");
            board.add(makeTile(controller.getActivePuzzle().getClue(i, j) + 7), i, j);
            System.out.println("P10");
          } else {
            System.out.println("P11");
            board.add(makeTile(controller.getActivePuzzle().getClue(i, j)), i, j);
            System.out.println("P12");
          }
        }
        if (controller.getActivePuzzle().getCellType(i, j) == CellType.WALL) {
          System.out.println("P13");
          board.add(makeTile(5), i, j);
          System.out.println("P14");
        }
      }
    }
    System.out.println("-------------------------------------------------------------------------");
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
