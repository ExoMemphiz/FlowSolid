/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryCrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class NewClass {
    
    static String URL = "https://gist.githubusercontent.com/deekayen/4148741/raw/01c6252ccc5b5fb307c1bb899c95989a8a284616/1-1000.txt";
    static String TranslateURL = "https://script.google.com/macros/s/AKfycbyhqPOvVK4Nh5KRArRc_OpgsytScx-lCErUCmvzMTVmM2hZwNMk/exec";
    
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = readURL(URL, 86, 4);
        for (int i = 0; i < strings.size(); i++) {
            String englishWord = strings.get(i);
            if (englishWord != null && englishWord.length() < 13) {
                System.out.println(englishWord);
            }
        }
    }
    
    public static ArrayList<String> readURL(String url, int jumps, int startLine) throws MalformedURLException, IOException {
        ArrayList<String> strings = new ArrayList<>();
        int totalLineReads = 0;
        URL conURL = new URL(url);
        URLConnection conn = conURL.openConnection();
        InputStreamReader reader = new InputStreamReader(conn.getInputStream());
        BufferedReader buffered = new BufferedReader(reader);
        String line = buffered.readLine();
        int currentLine = 1;
        totalLineReads++;
        while (currentLine < startLine && line != null) {
            line = buffered.readLine();
            currentLine++;
            totalLineReads++;
        }
        //System.out.println("Got to startLine: " + line);
        while (line != null) {
            int currentJumps = 0;
            while (currentJumps < jumps) {
                line = buffered.readLine();
                totalLineReads++;
                currentJumps++;
            }
            strings.add(line);
            //System.out.println("Added new word: " + line + "   (TotalReads: " + totalLineReads);
        }
        return strings;
    }
    
    public static ArrayList<String> readURL(String url, int jumps, int startLine, int endLine) throws MalformedURLException, IOException {
        ArrayList<String> strings = new ArrayList<>();
        int totalLineReads = 0;
        URL conURL = new URL(url);
        URLConnection conn = conURL.openConnection();
        InputStreamReader reader = new InputStreamReader(conn.getInputStream());
        BufferedReader buffered = new BufferedReader(reader);
        String line = buffered.readLine();
        int currentLine = 1;
        totalLineReads++;
        while (currentLine < startLine && line != null) {
            line = buffered.readLine();
            currentLine++;
            totalLineReads++;
        }
        while (line != null && totalLineReads < endLine) {
            strings.add(line);
            //System.out.println("Added new word: " + line + "   (TotalReads: " + totalLineReads);
            line = buffered.readLine();
            totalLineReads++;
        }
        return strings;
    }
    
}
