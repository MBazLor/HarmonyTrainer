package com.mbl.harmonytrainer;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GuitarNeckGraph {

    int fretQty;
    double spacing;
    private final Pane node;

    public GuitarNeckGraph(){
        this(21,18);
    }
    public GuitarNeckGraph(int frets) {
        this(frets, 18);
    }
    public GuitarNeckGraph(int frets, double spacing) {
        this.fretQty = frets;
        this.spacing = spacing;
        this.node = new Pane();
        configureNeck();
    }



    public void configureNeck() {

        // Neck Background
        Rectangle neck = new Rectangle(50, 20, 120, 400);
        neck.setFill(Color.web("#2b1a0e")); // marrón oscuro de "rock añejo"
        neck.setArcWidth(15);
        neck.setArcHeight(15);

        // Frets
        for (int i = 0; i < fretQty; i++) {
            Line traste = new Line(
                    50, 20 + i * spacing,
                    170, 20 + i * spacing
            );
            traste.setStroke(Color.SILVER);
            traste.setStrokeWidth(3);
            node.getChildren().add(traste);
        }

        // Marks on the neck
        int[] markers = {3, 5, 7, 9, 12, 15, 17, 19};
        for (int fretN : markers) {
            Circle marcador = new Circle(110, 20 + fretN * spacing - 9, 6);
            marcador.setFill(Color.WHITE);
            node.getChildren().add(marcador);

            // Doble marcador en el traste 12 (el boss)
            if (fretN == 12) {
                Circle marcador2 = new Circle(110, 20 + fretN * spacing - 25, 6);
                marcador2.setFill(Color.WHITE);
                node.getChildren().add(marcador2);
            }
        }
        node.getChildren().add(neck);
    }

    public Pane getNode(){
        return node;
    }

    public void addToStage(Stage stage) {
        // Agarra el root del stage y enchufa el mástil ahí
        ((VBox) stage.getScene().getRoot()).getChildren().add(1,getNode());
    }

}
