package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class view implements FXComponent{
    private AlternateMvcController controller;
    private FXComponent ControlView;
    private FXComponent PuzzleView;

    public view(AlternateMvcController controller) {
        this.controller = controller;
        this.ControlView = new ControlView(controller);
        this.PuzzleView = new PuzzleView(controller);
    }

    public Parent render() {
        BorderPane layout = new BorderPane();
        layout.getStyleClass().add("layout");
        layout.getChildren().add(ControlView.render());
        layout.setCenter(PuzzleView.render());

        return layout;
    }

    @Override
    public void update(Model model) {
        this.controller.setModel(model);
    }
}
