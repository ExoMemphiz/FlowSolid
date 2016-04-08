/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;

/**
 *
 * @author Chris
 */
public class WordPair {
 
    private final String danish, english;
    private double difficulty;
    
    //Example line: "Hest,Horse"
    public WordPair(String line) {
        String[] splits = line.split(",");
        danish = splits[0];
        english = splits[1];
        difficulty = (splits.length > 2 ? Double.parseDouble(splits[2]) : calculateDifficulty());
    }
    
    public WordPair(String danish, String english) {
        this.danish = danish;
        this.english = english;
    }

    /**
     * @param value 
     * -1 is the minimum amount of characters in a word, 25 is the maximum numbers of characters.
     * @return Normalized range from 0.0 to 1.0
     */
    private double normalize(double value) {
	return (value - 1) / (25 - 1);
    }
    
    private double calculateDifficulty() {
        DecimalFormat format = new DecimalFormat("#.##");
        double normalized = normalize(danish.length() + english.length());
        String formatted = format.format(normalized).replaceAll(",", ".");
        return Double.parseDouble(formatted);
    }
    
    public String getDanish() {
        return danish;
    }

    public String getEnglish() {
        return english;
    }

    public double getDifficulty() {
        return difficulty;
    }
    
    @Override
    public String toString() {
        return danish + "," + english + "," + difficulty;
    }
 
    public boolean isEqual(String danish, String english) {
        return this.danish.equalsIgnoreCase(danish) && this.english.equalsIgnoreCase(english);
    }
    
    public boolean isPartOf(String word) {
        return english.equalsIgnoreCase(word) || danish.equalsIgnoreCase(word);
    }
    
    public String getEquivalent(String word) {
        if (isPartOf(word)) {
            if (word.equalsIgnoreCase(english)) {
                return danish;
            }
            return english;
        }
        return null;
    }
    
}