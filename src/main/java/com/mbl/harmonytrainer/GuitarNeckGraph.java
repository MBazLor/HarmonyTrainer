package com.mbl.harmonytrainer;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class GuitarNeckGraph {

    int fretQty;

    private final Pane node;

    public GuitarNeckGraph(){
        this(12);
    }
    public GuitarNeckGraph(int frets) {
        this.fretQty = frets;
        this.node = new Pane();
        drawNeck();
    }



    public void drawNeck() {

         int neckWidth= 500;
         int neckHeight= 100;

         double spacing = (double) neckWidth / fretQty; //Computed fret spacing
         // Start coordinates for drawing inside the Pane
         int x = 50;
         int y = 20;

        // Neck Background
        Rectangle neck = new Rectangle(x, y, neckWidth, neckHeight);
        neck.setFill(Color.web("#2b1a0e")); // marrón oscuro de "rock añejo"
        neck.setArcWidth(15);
        neck.setArcHeight(15);
        node.getChildren().add(neck);
        neck.toBack();
        Line bottomNeck = new Line(x+6, y + neckHeight-8, x + neckWidth-6, y + neckHeight-8);
        bottomNeck.setStroke(Color.web("#F5A627")); // Clear line, representing the bottom edge of the neck
        bottomNeck.setStrokeWidth(12);
        node.getChildren().add(bottomNeck);
        bottomNeck.toFront();
        Line bottomNeck2 = new Line(x+3, y + neckHeight, x + neckWidth-3, y + neckHeight);
        bottomNeck2.setStroke(Color.web("#F5A627")); // Clear line, representing the bottom edge of the neck
        bottomNeck2.setStrokeWidth(6);
        bottomNeck2.setStrokeLineCap( javafx.scene.shape.StrokeLineCap.ROUND);
        node.getChildren().add(bottomNeck2);
        bottomNeck2.toFront();

        // Frets
        for (int i = 0; i < fretQty + 1; i++) {
            Line traste = new Line(
                    x + i * spacing,y,
                    x + i * spacing, neckHeight
            );
            traste.setStroke(Color.GOLD);
            if(i==0){
                traste.setStroke(Color.WHITE);
                traste.setStrokeWidth(6); // Cejuela más gruesa
            } else{
                traste.setStrokeWidth(2);
            }
            node.getChildren().add(traste);
            traste.toFront();
        }

        // Marks on the neck
        int[] markers = {3, 5, 7, 9, 12};
        for (int fretN : markers) {
            if(fretN == 12){
                // Marcador doble en el traste 12
                Circle marcador1 = new Circle( fretN * spacing - spacing/2 + x, neckHeight/3 + y/2, 6);
                marcador1.setFill(Color.WHITE);
                node.getChildren().add(marcador1);
                marcador1.toFront();

                Circle marcador2 = new Circle( fretN * spacing - spacing/2 + x, 2*neckHeight/3 + y/2, 6);
                marcador2.setFill(Color.WHITE);
                node.getChildren().add(marcador2);
                marcador2.toFront();

            }else{
                Circle marcador = new Circle(  fretN * spacing - spacing/2 + x, neckHeight/2+y/2, 6);
                marcador.setFill(Color.WHITE);
                node.getChildren().add(marcador);
                marcador.toFront();
            }

        }

    }

    /**
     * Get the Pane node with the guitar neck drawn
     * @return Pane node
     */
    public Pane getNode(){
        return node;
    }


}
