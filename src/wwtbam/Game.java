package wwtbam;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class representing a new game of Who Wants To Be A Millionaire
 * @author Devin Grant-Miles
 */
public final class Game 
{
    /**
     * Attributes of a game object. 
     * Count keeps track of the question number.
     * boolean correct keeps track of whether a player answers a question right
     * boolean won tracks whether a player has won or not
     */
    private Player player;
    private final ArrayList<Question> qList;
    private int count;
    private boolean correct = true;
    private boolean won = false;
    private final Database database;

    /**
     * Constructor for new game object
     * Also loads a nd shuffles the set of questions upon the start of a new game
     */
    public Game() 
    {
        this.player = new Player();
        this.qList = new ArrayList();
        this.count = 0;
        this.database = new Database();
        this.database.loadQuestions(this.qList);
        Collections.shuffle(getQlist());// Question list is shuffled so order is different every time the game is played
    }
    
    public Database getDatabase() 
    {
        return database;
    }

    public ArrayList<Question> getQlist() 
    {
        return this.qList;
    }
    
    public Player getPlayer() 
    {
        return this.player;
    }
    
    public boolean isCorrect() 
    {
        return correct;
    }
    
    public boolean isWon() 
    {
        return won;
    }
    
    //method for checking if the player has won yet
    public void checkWon()
    {
        if(this.player.getScore() == 1000000)
        {
            this.won = true;
        }
    }
    
    // response for player using Ask the Audience
    public String askAud()
    {
        return this.player.getLifeLine().useAskAud(this.qList.get(count));                    
    }
    
    // response for player using 50/50
    public String fifty50()
    {
        return this.player.getLifeLine().useFiftyFifty(this.qList.get(this.count));            
    }

    // response for player using Phone a Friend
    public String phoneFriend()
    {
        return this.player.getLifeLine().usePhoneFriend(this.qList.get(this.count));            
    }
    
    /**
     * Method for checking user's answer (A,B,C or D) and responds appropriately 
     * @param input is the letter corresponding to the button pressed which is compared with the letter of the correct answer  
     * @return String response to the player depending on whether they get the question right or wrong
     */
    public String checkInput(String input) 
    {
        String response = "";
        
        if (input.equalsIgnoreCase(this.qList.get(count).getCorrectA())) // response to a correct answer
        {
            this.player.increaseScore();
            checkWon();
            
            if (this.player.getScore() != 1000000) //response for if the player is right but has not won yet
            {
                this.count++;
                response = "<html>Correct! Your winnings so far are $" + this.player.getScore();
            } 
            else
            {
                getDatabase().writeToFile(getPlayer().getName()); // saves player name to winners database
                response = "<html>Congrats! You've won and are our newest millionaire!<br/><br/>"+getDatabase().readFile();// congratulates player and display previous winners

            }
        }
        else // response to user getting a wrong answer
        {
            correct = false;
            response = "<html>I'm sorry, that answer is incorrect. Better luck next time!";
        }
      
        return response;
    }
    
    /**
     * Method which displays game rules and controls to the user 
     * @return String describing the rules of the game
     */
    public String showHelp()
    {
        String help = "<html>";
        
        help = help+"Who Wants to be a Millionaire is a simple quiz game.<br/> The game will ask you a set of 12 questions and if you get them all right you win the million dollars!<br/>"
        +"Each player has 3 'Lifelines' which act as a type of hint for the user - try them to see what they do."        
        +"<br/>But beware, you only have one of each, so use them wisely!";              
                
        return help;
    }
    
    /**
     * Method which displays the question and possible answers to the user 
     * @return String containing the current question and possible answers
     */
    public String askQuestion()
    {
        String question = "<html>Question "+(this.count+1)+": "+this.qList.get((this.count)).getQuestionToAsk();
        question = question+"<br/><br/>"+this.qList.get((this.count)).returnAnswers();
            
        return question;
    }
}


    
