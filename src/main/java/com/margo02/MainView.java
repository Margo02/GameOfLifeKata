package com.margo02;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

public class MainView extends VBox {
    private Canvas canvas;
    private Affine affine;
    private GameOfLife board;
    private int drawMode=1;

    public MainView() {
        this.canvas = new Canvas(400,400);
        this.canvas.setOnMousePressed(this::handleDraw);
        this.canvas.setOnMouseDragged(this::handleDraw);

        this.setOnKeyPressed(this::onKeyPressed);

        Toolbar toolbar = new Toolbar(this);

        this.getChildren().addAll(toolbar, this.canvas);
        this.affine = new Affine();
        this.affine.appendScale(400 / 8f, 400 / 6f);

        this.board = new GameOfLife(8,6);

    }

    private void onKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.D){
            this.drawMode=1;
        }else if(keyEvent.getCode()==KeyCode.E){
            this.drawMode=0;
        }
    }

    private void handleDraw(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        try {

            Point2D boardCord = this.affine.inverseTransform(mouseX, mouseY);

            int boardX = (int) boardCord.getX();
            int boardY = (int) boardCord.getY();

            this.board.setState(boardX,boardY,drawMode);
            draw();

        }catch(NonInvertibleTransformException e){
            System.out.println("Could not invert transform");
        }
    }

    public void draw(){
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        g.setTransform(this.affine);

        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0, 0, 400, 400);

        g.setFill(Color.BLACK);
        for (int x = 0; x < this.board.getWidth(); x++) {
            for (int y = 0; y < this.board.getHeight(); y++) {
                if (this.board.getState(x, y) == 1) {
                    g.fillRect(x, y, 1, 1);
                }
            }
        }

        g.setStroke(Color.GRAY);
        g.setLineWidth(0.05);
        for (int x = 0; x <= this.board.getWidth(); x++) {
            g.strokeLine(x, 0, x, 8);
        }

        for (int y = 0; y <= this.board.getHeight(); y++) {
            g.strokeLine(0, y, 8, y);
        }


    }

    public GameOfLife getBoard() {
        return this.board;
    }

    public void setDrawMode(int newDrawMode) {
        this.drawMode = newDrawMode;
    }

}
