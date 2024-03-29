package com.margo02;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class Toolbar extends ToolBar {

    private MainView mainView;

    public Toolbar(MainView mainView) {
        this.mainView = mainView;
        Button draw = new Button("Draw");
        draw.setOnAction(this::handleDraw);
        Button erase = new Button("Erase");
        erase.setOnAction(this::handleErase);
        Button step = new Button("Step");
        step.setOnAction(this::handleStep);

        this.getItems().addAll(draw,erase,step);

    }

    private void handleErase(ActionEvent actionEvent) {
        this.mainView.setDrawMode(GameOfLife.DEAD);
    }

    private void handleStep(ActionEvent actionEvent) {
        this.mainView.getBoard().iterate();
        this.mainView.draw();
    }

    private void handleDraw(ActionEvent actionEvent) {
        this.mainView.setDrawMode(GameOfLife.ALIVE);
    }

}
