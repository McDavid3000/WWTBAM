package wwtbam;

import java.util.Random;

/**
 * Class representing player's LifeLines 
 * @author Devin Grant-Miles
 */
public class LifeLine 
{   
    /**
     * Method for using the phone a friend lifeline
     * Provides feedback to user, gives the user a hint and sets phoneFriend attribute to false once complete
     * Uses Thread.sleep for a user friendly experience
     * @param question (current) from the qList 
     * @return String containing the text shown back to the user including the phone hint
     */
    public String usePhoneFriend(Question question) 
    {
        String hint = "<html>You have chosen to phone a friend!<br/>" 
                + "<br/>Dialing..."
                + "<br/>Dialing..."
                + "<br/>Dialing..."
                + "<br/><br/>[Your friend answers]<br/>"
                + "<br/>Hey mate! I'm not sure but I think " + question.getPhoneHint()+"<br/><br/>Your question again is...<br/>"; 
                
        return hint;
    }

    /**
     * Method for using the 50/50 lifeline
     * Provides feedback to the user, removes two answers from the inputted Question object's Answer ArrayList according to the correct answer and sets fiftyFifty attribute to false once complete
     * Uses Thread.sleep for a user friendly experience
     * @param question current) from the qList 
     * @return String returning the remaining possible answers after two are removed 
     */    
    public String useFiftyFifty(Question question) 
    {
        String hint = "<html>You have chosen 50/50!<br/>";

        if (question.getCorrectA().equalsIgnoreCase("a"))
        {
            question.getAnswers().remove(2);
            question.getAnswers().remove(1);
        }
        else if (question.getCorrectA().equalsIgnoreCase("b"))
        {
            question.getAnswers().remove(3);
            question.getAnswers().remove(2);
        }
        else if (question.getCorrectA().equalsIgnoreCase("c"))
        {
            question.getAnswers().remove(3);           
            question.getAnswers().remove(0);
        }
        else 
        {
            question.getAnswers().remove(1);
            question.getAnswers().remove(0);            
        }

        return hint;
    }
    
    /**
     * Method for using the Ask the Audience lifeline
     * Provides feedback to the user, generates and prints percentages back to the user based on the input Question objects correct answer and sets askAud attribute to false once complete
     * Uses Thread.sleep for a user friendly experience
     * @param question current) from the qList 
     * @return String returning the audience's vote in percentages
     */      
    public String useAskAud(Question question) 
    {
        Random ranGen = new Random();
        
        int correctA = ranGen.nextInt(30)+40;
        int aud1 = ranGen.nextInt(5) + 10;
        int aud2 = ranGen.nextInt(5) + 10;
        int aud3 = 100 - (correctA + aud1 + aud2);
        
        String hint;
        
        hint = "<html>You have chosen to ask the audience!<br/><br/>The audience has voted...<br/>";
        
        if(question.getCorrectA().equalsIgnoreCase("a"))
        {
            hint = hint+"<br/>A: " + correctA + "% <br/>B: " + aud1 + "% <br/>C: " + aud2 + "% <br/>D: " + aud3 + "%<br/><br/>Your question again is...<br/>";
        }
        else if(question.getCorrectA().equalsIgnoreCase("b"))
        {
            hint = hint+"<br/>A: " + aud1 + "% <br/>B: " + correctA + "% <br/>C: " + aud2 + "% <br/>D: " + aud3 + "%<br/><br/>Your question again is...<br/>";
        }
        else if(question.getCorrectA().equalsIgnoreCase("c"))
        {
            hint = hint+"<br/>A: " + aud2 + "% <br/>B: " + aud1 + "% <br/>C: " + correctA + "% <br/>D: " + aud3 + "%<br/><br/>Your question again is...<br/>";
        }
        else if(question.getCorrectA().equalsIgnoreCase("d"))
        {
            hint = hint+"<br/>A: " + aud3 + "% <br/>B: " + aud1 + "% <br/>C: " + aud2 + "% <br/>D: " + correctA + "%<br/><br/>Your question again is...<br/>";
        }
        
        return hint;
    }
}
