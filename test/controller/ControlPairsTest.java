/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
        ControlPairs instance = new ControlPairs();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomQuestion method, of class ControlPairs.
     */
    @Test
    public void testGetRandomQuestion() {
        System.out.println("getRandomQuestion");
        ControlPairs instance = new ControlPairs();
        String expResult = "";
        String result = instance.getRandomQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDifficultyRating method, of class ControlPairs.
     */
    @Test
    public void testGetDifficultyRating() {
        System.out.println("getDifficultyRating");
        ControlPairs instance = new ControlPairs();
        double expResult = 0.0;
        double result = instance.getDifficultyRating();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkGuess method, of class ControlPairs.
     */
    @Test
    public void testCheckGuess() {
        System.out.println("checkGuess");
        String question = "";
        String guess = "";
        ControlPairs instance = new ControlPairs();
        boolean expResult = false;
        boolean result = instance.checkGuess(question, guess);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookup method, of class ControlPairs.
     */
    @Test
    public void testLookup() {
        System.out.println("lookup");
        String question = "";
        ControlPairs instance = new ControlPairs();
        String expResult = "";
        String result = instance.lookup(question);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class ControlPairs.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        String filename = "";
        ControlPairs instance = new ControlPairs();
        boolean expResult = false;
        boolean result = instance.load(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class ControlPairs.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String filename = "";
        ControlPairs instance = new ControlPairs();
        boolean expResult = false;
        boolean result = instance.save(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class ControlPairs.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ControlPairs instance = new ControlPairs();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
