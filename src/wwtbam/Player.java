package wwtbam;

/**
 * Player class representing a new player to the game 
 * @author Devin Grant-Miles
 */
public class Player 
{
    /**
     * Attributes of a player  
     */
    private String name;
    private int score;
    private final LifeLine lifeLine;

    /**
     * Constructor for a new player
     * sets score to 0
     */
    public Player() 
    {
        this.score = 0;
        this.lifeLine = new LifeLine(); 
    } 
    
    /**
     * Get method for player name
     * @return player name
     */
    public String getName() 
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     *  Get method for player score 
     * @return players current score
     */
    public int getScore() 
    {
        return this.score;
    }
    
    /**
     * Get method for player LifeLines
     * @return players lifelines
     */
    public LifeLine getLifeLine() 
    {
        return this.lifeLine;
    }
    
    /**
     * Method to increase the player score when they get an answer correct
     * Scores are programmed to increase as per the TV show's rules
     */
    public void increaseScore()
    {
        switch (this.score) 
        {
            case 0:
                this.score = 500;
                break;
            case 2000:
                this.score = 5000;
                break;
            case 20000:
                this.score = 50000;
                break;
            case 50000:
                this.score = 75000;
                break;
            case 150000:
                this.score = 250000;
                break;
            default:
                this.score = this.score * 2;
                break;
        }
    }
}
