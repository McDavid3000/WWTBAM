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
 * Test class for LifeLine class
 * @author Devin Grant-Miles
 */
public class LifeLineTest 
{   
    public LifeLineTest() {
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
     * Test of useFiftyFifty method, of class LifeLine.
     */
    @Test
    public void testUseFiftyFifty() 
    {
        System.out.println("useFiftyFifty");
        Question question = new Question();
        question.getAnswers().add("1");
        question.getAnswers().add("2");
        question.getAnswers().add("3");
        question.getAnswers().add("4");
        question.setCorrectA("a");
        LifeLine instance = new LifeLine();
        String x = instance.useFiftyFifty(question);

        int expSize = 2;
        int result = question.getAnswers().size();
        assertEquals(expSize, result);
    }    
}
