package wwtbam;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Question class representing the questions asked in the game
 * @author Devin Grant-Miles
 */
public class Question 
{
    /**
     * Attributes of the question class
     */
    private String questionToAsk;
    private final ArrayList<String> answers;
    private String correctA;
    private String phoneHint;

    /**
     * Question constructor
     */
    public Question() 
    {
        this.answers = new ArrayList();
    }
    
    /**
     * Set method for questionsToAsk attribute (the actual question)
     * @param questionToAsk 
     */
    public void setQuestionToAsk(String questionToAsk) 
    {
        this.questionToAsk = questionToAsk;
    }

    /**
     * Set method for the correct answer
     * @param correctA 
     */
    public void setCorrectA(String correctA) 
    {
        this.correctA = correctA;
    }

    /**
     * Set method for the phone a friend hint
     * @param phoneHint 
     */
    public void setPhoneHint(String phoneHint) 
    {
        this.phoneHint = phoneHint;
    }

    /**
     * Get method for the question to ask attribute
     * @return questionToAsk attribute
     */
    public String getQuestionToAsk() 
    {
        return this.questionToAsk;
    }

    /**
     * Get method for the answers ArrayList
     * @return Answers ArrayList
     */
    public ArrayList<String> getAnswers()
    {
        return this.answers;
    }
    
     /**
     * Method for returning the possible answers to the current question
     * @return String representing the possible choice of answers in correct format
     */
    public String returnAnswers() 
    {
        Iterator iterator = this.answers.iterator();
        
        String answerOptions = "<html>";
        
        while (iterator.hasNext())
        {
            answerOptions = answerOptions+iterator.next()+"<br/>";
        }

        return answerOptions;
    }

    /**
     * Get method for the correct answer
     * @return Correct answer
     */
    public String getCorrectA() 
    {
        return this.correctA;
    }

    /**
     * Get method for phone hint
     * @return phone hint 
     */
    public String getPhoneHint() 
    {
        return this.phoneHint;
    }
}
