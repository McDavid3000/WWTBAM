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
 * Test class for game class
 * @author Devin Grant-Miles
 */
public class GameTest 
{    
    public GameTest() {
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
     * Test of checkInput method, of class Game.
     * for if the inputted answer is correct
     */
    @Test
    public void testCheckInputCorrectAns() {
        System.out.println("checkInput");
        String input = "a";
        Game instance = new Game();
        instance.getQlist().add(new Question());
        instance.getQlist().get(0).setCorrectA("a");
        String x = instance.checkInput(input);

        int expResult = 500;
        int result = instance.getPlayer().getScore();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of checkInput method, of class Game.
     * for if the inputted answer is incorrect
     */
    @Test
    public void testCheckInputIncorrectAns() {
        System.out.println("checkInput");
        String input = "b";
        Game instance = new Game();
        instance.getQlist().add(new Question());
        instance.getQlist().get(0).setCorrectA("a");
        String x = instance.checkInput(input);

        int expResult = 0;
        int result = instance.getPlayer().getScore();
        assertEquals(expResult, result);
        assertEquals(false, instance.isWon());
    }
}
