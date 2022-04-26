package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import javax.accessibility.AccessibleContext;

public class instructionsView implements FXComponent {
  private AlternateMvcController controller;

  public instructionsView(AlternateMvcController controller) {
    this.controller = controller;
  }

  public Parent render() {
    Label instructions = new Label("Place light bulbs on the grid to make every white square is lit!");
    return instructions;
  }

  @Override
  public void update(Model model) {
    this.controller.setModel(model);
  }
}
