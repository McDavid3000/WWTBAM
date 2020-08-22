/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Player class
 * @author Devin Grant-Miles
 */
public class PlayerTest 
{
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of increaseScore method, of class Player.
     * tests each increment of the score until the winning score is achieved 
     */
    @Test
    public void testIncreaseScore() 
    {
        System.out.println("increaseScore");
        Player instance = new Player();
        
        instance.increaseScore();
        int result = instance.getScore();
        int expected = 500;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 1000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 2000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 5000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 10000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 20000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 50000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 75000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 150000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 250000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 500000;
        assertEquals(result, expected);
        
        instance.increaseScore();
        result = instance.getScore();
        expected = 1000000;
        assertEquals(result, expected);
    } 
}
