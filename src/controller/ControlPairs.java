/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.FileHandler;
import model.WordPair;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris
 */
public class ControlPairs implements WordPairControlInterface {

    public static String FILE_PATH = "pairs.txt";
    
    private ArrayList<WordPair> pairs = new ArrayList<>();
    private ArrayList<WordPair> newlyAdded = new ArrayList<>();
    private Random r;
    private int successRate, totalGuesses;
    
    public ControlPairs(boolean loadFromFile) {
        if (loadFromFile){
            load(FILE_PATH);
        }
        r = new Random();
    }
    public ControlPairs() {
        r = new Random();
        load(FILE_PATH);
    }
    
    @Override
    public void add(String question, String answer) {
        String data = question + "," + answer;
        String testLookup = lookup(question);
        if (testLookup != null) {
            JOptionPane.showMessageDialog(null, "Already added " + question + ". The added answer is " + testLookup);
            return;
        }
        WordPair pair = new WordPair(data);
        pairs.add(pair);
        newlyAdded.add(pair);
    }

    @Override
    public int size() {
        return pairs.size();
    }
    
    @Override
    public String getRandomQuestion() {
        int random = r.nextInt(pairs.size());
        WordPair pair = pairs.get(random);
        System.out.println("Pair difficulty: " + pair.getDifficulty());
        System.out.println("Difficulty Rating: " + getDifficultyRating());
        if (totalGuesses > 3 && inBetween(getDifficultyRating(), pair.getDifficulty(), 0.2)) {
            return getRandomQuestion();
        }
        return pair.getDanish();
    }
    
    private boolean inBetween(double value, double pairDiff, double margin) {
        //If 
        return value - margin > pairDiff && value + margin < pairDiff;
    }
    
    private double normalize(double value) {
	return (value - 0) / (100 - 0);
    }
    
    public double getDifficultyRating() {
        DecimalFormat format = new DecimalFormat("#.##");
        double temp = totalGuesses > 0 ? (((double) successRate) * 100) / ((double) totalGuesses) : 1.0;
        double normalized = normalize(temp);
        String formatted = format.format(normalized).replaceAll(",", ".");
        return Double.parseDouble(formatted);
    }

    @Override
    public boolean checkGuess(String question, String guess) {
        totalGuesses++;
        for (WordPair pair : pairs) {
            if (pair.getDanish().equals(question)) {
                if (pair.getEnglish().equals(guess)) {
                    successRate++;
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String lookup(String question) {
        for (WordPair pair : pairs) {
            if (pair.isPartOf(question)) {
                return pair.getEquivalent(question);
            }
        }
        return null;
    }

    @Override
    public boolean load(String filename) {
        ArrayList<String> readFile = null;
        try {
            readFile = FileHandler.readFile(FILE_PATH);
            for (String s : readFile) {
                if (s != null && !s.isEmpty() && s.contains(",")) {
                    pairs.add(new WordPair(s));
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControlPairs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean save(String filename) {
        try {
            FileHandler.saveFile(filename, newlyAdded);
            newlyAdded.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        pairs.clear();
    }
    
}