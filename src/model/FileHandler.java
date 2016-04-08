/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class FileHandler {
 
    public static ArrayList<String> readFile(String url) throws FileNotFoundException, IOException {
        ArrayList<String> strings = new ArrayList<>();
        File f = new File(url);
        try {
            FileInputStream fInput = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fInput));
            String s = reader.readLine();
            do {
                strings.add(s);
                s = reader.readLine();
            }
            while (s != null);
        } catch (Exception e) {
            System.out.println("Cannot find specified file in location: " + f.getAbsolutePath());
        }
        
        return strings;
    }
    
    public static void cleanWrite(String filePath, String... data) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            for (String s : data) {
                fw.write(s);
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void appendToFile(String filePath, String... data) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : data) {
                bw.append(s + System.lineSeparator());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void saveFile(String filePath, ArrayList<WordPair> pairs) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (WordPair s : pairs) {
                bw.append(s.toString() + System.lineSeparator());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}