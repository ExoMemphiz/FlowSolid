/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CHRIS
 */
public class ControlPairsTest {
    private WordPairControlInterface wpc;
    
    public ControlPairsTest() {
    }    
    
    @Before
    public void setUp() {
        wpc = new ControlPairs(false);
        wpc.clear();
        wpc.add("bingo", "bango");
        wpc.add("hest", "horse");
        wpc.add("datamat", "computer");
        assertTrue("" + wpc.size(), wpc.size() != 0);
        System.out.println("" + wpc.size());
        
    }
    
    @After
    public void tearDown() {
        wpc.clear();
    }

    /**
     * Test of add method, of class ControlPairs.
     */
    @Test
    public void testAdd() {
        System.out.println("testAdd");
        assertTrue(wpc.size() == 3);
        String danish = "ko";
        String english = "hund";
        wpc.add(danish, english);
        assertTrue(wpc.size() == 4);
        wpc.clear();
    }

    /**
     * Test of size method, of class ControlPairs.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int expResult = 3;
        int result = wpc.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRandomQuestion method, of class ControlPairs.
     */
    @Test
    public void testGetRandomQuestion() {
        System.out.println("getRandomQuestion");
        String result = wpc.getRandomQuestion();
        assertNotNull(result);
    }

  
    @Test
    public void testCheckGuess() {
        System.out.println("checkGuess");
        String question = "bingo";
        String guess = "bango";
        boolean result = wpc.checkGuess(question, guess);
        assertTrue(result);
    }

    /**
     * Test of lookup method, of class ControlPairs.
     */
    @Test
    public void testLookup() {
        System.out.println("lookup");
        String question = "bingo";
        String expResult = "bango";
        String result = wpc.lookup(question);
        assertEquals(expResult, result);
    }
    
}
