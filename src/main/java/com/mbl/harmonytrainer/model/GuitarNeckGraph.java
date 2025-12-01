package com.mbl.harmonytrainer.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * Class to draw a guitar neck graphically using JavaFX
 * Draws frets, strings, and position markers.
 */
public class GuitarNeckGraph {

    int fretQty;
    int strings;
    private final Pane node;

    public GuitarNeckGraph(){
        this(12);
    }
    public GuitarNeckGraph(int frets) {
        this.fretQty = frets;
        this.node = new Pane();
        this.strings = 6;
        //draw horizontal guitar neck
        drawNeck(500, 100);
    }

    /**
     * Entry method to draw the guitar neck
     * @param neckWidth Width of the guitar neck
     * @param neckHeight Height of the guitar neck
     */
    public void drawNeck(int neckWidth, int neckHeight) {

         double spacing = (double) neckWidth / fretQty; //Computed fret spacing
         // Start coordinates for drawing inside the Pane
         int x = 50;
         int y = 20;
        drawFretboard(neckWidth, neckHeight, x, y);
        drawFrets(neckHeight, spacing, x, y);
        drawMarks(neckHeight, spacing, x, y);
        drawStrings(neckWidth, neckHeight, x, y);
    }

    /**
     * Draw the guitar neck background
     * @param neckWidth
     * @param neckHeight
     * @param x
     * @param y
     */
    private void drawFretboard(int neckWidth, int neckHeight, int x, int y) {
        // Neck Background
        Rectangle neck = new Rectangle(x, y, neckWidth, neckHeight);
        neck.setFill(Color.web("#2b1a0e")); // marrón oscuro de "rock añejo"
        neck.setArcWidth(15);
        neck.setArcHeight(15);
        node.getChildren().add(neck);
        neck.toBack();
        Line bottomNeck = new Line(x +6, y + neckHeight -8, x + neckWidth -6, y + neckHeight -8);
        bottomNeck.setStroke(Color.web("#F5A627")); // Clear line, representing the bottom edge of the neck
        bottomNeck.setStrokeWidth(12);
        node.getChildren().add(bottomNeck);
        bottomNeck.toFront();
        Line bottomNeck2 = new Line(x +3, y + neckHeight, x + neckWidth -3, y + neckHeight);
        bottomNeck2.setStroke(Color.web("#F5A627")); // Clear line, representing the bottom edge of the neck
        bottomNeck2.setStrokeWidth(6);
        bottomNeck2.setStrokeLineCap( javafx.scene.shape.StrokeLineCap.ROUND);
        node.getChildren().add(bottomNeck2);
        bottomNeck2.toFront();
    }

    /**
     * Draw the frets on the guitar neck
     * @param neckHeight
     * @param spacing
     * @param x
     * @param y
     */
    private void drawFrets(int neckHeight, double spacing, int x, int y) {
        // Frets
        for (int i = 0; i < fretQty + 1; i++) {
            Line traste = new Line(
                    x + i * spacing, y,
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
    }

    /**
     * Draw the position markers on the guitar neck
     * @param neckHeight for calculating the vertical position
     * @param spacing between frets
     * @param x starting x position
     * @param y starting y position
     */
    private void drawMarks(int neckHeight, double spacing, int x, int y) {
        // Marks on the neck
        int[] markers = {3, 5, 7, 9, 12};
        for (int fretN : markers) {
            if(fretN == 12){
                // Marcador doble en el traste 12
                Circle marcador1 = new Circle( fretN * spacing - spacing /2 + x, neckHeight /3 + y /2, 6);
                marcador1.setFill(Color.WHITE);
                node.getChildren().add(marcador1);
                marcador1.toFront();

                Circle marcador2 = new Circle( fretN * spacing - spacing /2 + x, 2* neckHeight /3 + y /2, 6);
                marcador2.setFill(Color.WHITE);
                node.getChildren().add(marcador2);
                marcador2.toFront();
            }else{
                Circle marcador = new Circle(  fretN * spacing - spacing /2 + x, neckHeight /2+ y /2, 6);
                marcador.setFill(Color.WHITE);
                node.getChildren().add(marcador);
                marcador.toFront();
            }
        }
    }

    /**
     * Draw the strings on the guitar neck.
     * Drawn from bottom to top to simulate thickness differences.
     * @param neckWidth
     * @param neckHeight
     * @param x
     * @param y
     */
    public void drawStrings(int neckWidth, int neckHeight, int x, int y) {
        for (int i = 0; i < strings; i++) {
            double stringY = neckHeight + y - (y + (i + 1) * (neckHeight / (strings + 1)) - (y+1)/2);
            Line stringLine = new Line(
                    x, stringY,
                    x + neckWidth, stringY
            );
            // Set different stroke widths for strings to simulate thickness
            switch (i) {
                case 0 -> stringLine.setStrokeWidth(4); // 6th string (E)
                case 1 -> stringLine.setStrokeWidth(3.5); // 5th string (A)
                case 2 -> stringLine.setStrokeWidth(3); // 4th string (D)
                case 3 -> stringLine.setStrokeWidth(2.5); // 3rd string (G)
                case 4 -> stringLine.setStrokeWidth(2); // 2nd string (B)
                case 5 -> stringLine.setStrokeWidth(1.5); // 1st string (E)
            }
            stringLine.setStroke(Color.SILVER);
            node.getChildren().add(stringLine);
            stringLine.toFront();
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
