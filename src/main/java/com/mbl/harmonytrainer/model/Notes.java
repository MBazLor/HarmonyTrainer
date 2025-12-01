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

    /**
     * Calculates the interval in semitones between two notes.
     * @param note1
     * @param note2
     * @return
     */
    public static int calculateInterval(String note1, String note2){
        String[] noteNames = {
                "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
        };
        int index1 = -1;
        int index2 = -1;
        for(int i=0; i<noteNames.length; i++){
            if(noteNames[i].equals(note1)){
                index1 = i;
            }
            if(noteNames[i].equals(note2)){
                index2 = i;
            }
        }
        if(index1 == -1 || index2 == -1){
            return -1; // Invalid note
        }
        int interval = index2 - index1;
        if(interval < 0){
            interval += 12; // Wrap around
        }
        return interval;
    }


}
