package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class PuzzleView implements FXComponent {
  private AlternateMvcController controller;
  private FXComponent PuzzleTopView;
  private FXComponent PuzzleGridView;
  private FXComponent PuzzleButtomView;
  private FXComponent instructionsView;

  public PuzzleView(AlternateMvcController controller) {
    this.controller = controller;
    this.PuzzleGridView = new PuzzleGridView(controller);
    this.instructionsView = new instructionsView(controller);
  }

  public Parent render() {
    VBox layout = new VBox();
    layout.getStyleClass().add("layout");
    layout.getChildren().add(instructionsView.render());
    layout.getChildren().add(PuzzleGridView.render());
    return layout;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
