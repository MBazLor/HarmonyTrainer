package com.mbl.harmonytrainer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.random;

public class Notes {

    Map<String, Boolean> notes = new HashMap<>();

    public Notes() {
        String[] noteNames = {
                "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
        };
        for (String note : noteNames) {
            notes.put(note, true);
        }
    }

    public Map<String, Boolean> getNotes() {
        return notes;
    }

    public void ativateNote(String note) {
        if (notes.containsKey(note)) {
            notes.put(note, true);
        }
    }

    public void deactivateNote(String note) {
        if (notes.containsKey(note)) {
            notes.put(note, false);
        }
    }

    /**
     * Generates a random active note from the notes map.
     * @return
     */
    public String getRandomNote() {
        Random random = new Random();
        ArrayList activeNotes = new ArrayList<String>();

        for (String note : notes.keySet()) {
            if (notes.get(note)) {
                activeNotes.add(note);
            }
        }
        if (activeNotes.size() == 0) {
            return null; // No active notes
        }

        String randomNote = (String) activeNotes.get(random.nextInt(activeNotes.size()));
        return randomNote;
    }


}
