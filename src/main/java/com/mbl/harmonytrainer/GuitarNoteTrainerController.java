package com.mbl.harmonytrainer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Random;

public class GuitarNoteTrainerController {
    private static final String[] NOTES = {
            "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#"
    };
    private final Random random = new Random();
    private Timeline timeline;
    @FXML
    private Label noteLabel;
    @FXML
    private Slider intervalSlider;
    @FXML
    AnchorPane neckPane;

    @FXML
    private void startTraining() {
        try {
            double interval = intervalSlider.getValue();
            if (timeline != null) {
                timeline.stop(); // Stop the existing timeline if it exists
            }
            timeline = new Timeline(new KeyFrame(Duration.millis(interval*1000), e -> showRandomNote()));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        } catch (NumberFormatException e) {
            noteLabel.setText("Invalid interval!");
        }
    }

    @FXML
    private void stopTraining() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    private void showRandomNote() {
        String randomNote = NOTES[random.nextInt(NOTES.length)];
        noteLabel.setText(randomNote);
    }

    @FXML
    public void showNextNote() {
        if (timeline != null) {
            timeline.stop();
            timeline.play();
        }
        showRandomNote();
    }

    @FXML
    public void initialize() {
        neckPane.getChildren().add(new GuitarNeckGraph().getNode());
    }

}


