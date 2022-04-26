package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PuzzleGridView implements FXComponent {
  private AlternateMvcController controller;

  public PuzzleGridView(AlternateMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    GridPane layout = new GridPane();

    // set up board
    GridPane board = new GridPane();
    board.setHgap(16);
    board.setVgap(16);
    board.getStyleClass().add("board");
    layout.getChildren().add(board);

    // set up grids
    for (int i = 0; i < controller.getActivePuzzle().getHeight(); i++) {
      for (int j = 0; j < controller.getActivePuzzle().getWidth(); j++) {
        if (controller.getActivePuzzle().getCellType(i, j) == CellType.CLUE) {
          board.add(makeTile(controller.getActivePuzzle().getClue(i, j)), i, j);
        } else if (controller.getActivePuzzle().getCellType(i, j) == CellType.CORRIDOR) {
          Button button = new Button();
          board.add(button, i, j);
        } else if (controller.getActivePuzzle().getCellType(i, j) == CellType.WALL) {
          board.add(makeTile(5), i, j);
        }
      }
    }
    return layout;
  }

  private static Label makeTile(int num) {
    Label tile;
    if (num == 5) {
      tile = new Label();
    } else if (num == 6) {
      tile = new Label();
    } else {
      tile = new Label(String.valueOf(num));
    }
    tile.getStyleClass().add("tile");
    tile.getStyleClass().add("tile-" + num);
    return tile;
  }

  private EventHandler<ActionEvent> setOnAction(int i, int j) {
    controller.clickCell(i, j);
    return null;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
