/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 * Controller class of Who Wants To Be A Millionaire
 * @author Devin Grant-Miles
 */
public final class WWTBAMController 
{
    private Game game;
    private WWTBAMView view;
    
    /**
     * Event handler for when the help button is pressed
     * Displays help dialogue
     */      
    private void helpEventHandler()
    {       
        JOptionPane.showMessageDialog(null, game.showHelp());
    }
    
     /**
     * Event handler for start button
     * sets players name from text field input
     * enables and disables components as appropriate
     * Greets player and asks question 1
     */      
    private void startButtonEventHandler() 
    {
        game.getPlayer().setName(view.getNameTextField().getText()); 
        view.getNameTextField().setEnabled(false); 
        view.getTextDisplayLabel().setText("<html>Welcome to Who Wants to Be a Millionaire!<br/><br/>Good to have you here, "+ game.getPlayer().getName()+". Let's get started shall we? <br/><br/>" + game.askQuestion());
        view.getStartButton().setEnabled(false);   
        this.view.enableButtons(true);
    }
    
     /**
     * Event handler for letter answer buttons
     * @param String representing the letter of the button that was pressed
     */     
    private void letterButtonEventHandler(String buttonLetter) 
    {
        view.getTextDisplayLabel().setText(game.checkInput(buttonLetter));//checks if the answer is correct and sets text display depending on outcome
        if(game.isWon()) //checks if the game is won
        {
            this.view.enableButtons(false);
            play(view.showPlayAgain()); // asks player if they want to play again and if sends response to play method
        }
        else if(!game.isCorrect())
        {
            this.view.enableButtons(false);
            play(view.showPlayAgain());
        }
        else
        {
            view.getTextDisplayLabel().setText(view.getTextDisplayLabel().getText()+"<br/><br/>"+game.askQuestion()); // if the player is right but has not won yet next question is asked
        }
    }
    
    /**
     * Event handler for ask the audience button
     */  
    private void askAudEventHandler() 
    {
        view.getTextDisplayLabel().setText(game.askAud());//sets text display as ask the audience hint
        view.getTextDisplayLabel().setText(view.getTextDisplayLabel().getText()+"<br/>"+game.askQuestion()); // re asks the question to remind player
        view.getAskAudButton().setEnabled(false); // set to disabled since only one per game
    }
    
    /**
     * Event handler for 50/50 button
     */ 
    private void fifty50EventHandler()
    {
        view.getTextDisplayLabel().setText(game.fifty50()); // sets text display to 50/50 hint
        view.getTextDisplayLabel().setText(view.getTextDisplayLabel().getText()+"<br/>"+game.askQuestion()); // re asks the question to remind player
        view.getFifty50Button().setEnabled(false); // set to disabled since only one per game
    }
    
    /**
     * Event handler for phone a friend button
     */   
    private void phoneEventHandler()
    {
        view.getTextDisplayLabel().setText(game.phoneFriend()); // sets text display to phone a friend hint
        view.getTextDisplayLabel().setText(view.getTextDisplayLabel().getText()+"<br/>"+game.askQuestion()); // re asks the question to remind player
        view.getPhoneButton().setEnabled(false); // set to disabled since only one per game
    }
    
    /**
     * play method to allow play again option
     * instantiates new game object, new view object, sets view to visible 
     * disables buttons until player name is entered and game officially starts 
     * contains action listeners for all of the buttons
     * @param playAgain is the response from the play again dialogue box
     */
    private void play(int playAgain) 
    {
        if(playAgain == YES_OPTION)
        {
            this.game = new Game();      

            this.view = new WWTBAMView();
            view.setVisible(true);

            this.view.enableButtons(false);

            view.getTextDisplayLabel().setText(game.getDatabase().readFile()+"<br/>Input your name and press start to begin the game...");  

            view.getStartButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                startButtonEventHandler();
            }               
            }
            );

            /**
             * Action listener and action performed for 'A' button.
             * passes in the String 'a' which represents the letter the player chose
             */
            view.getAButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                letterButtonEventHandler("a");
            }               
            }
            );
            
            /**
             * Action listener and action performed for 'B' button.
             * passes in the String 'b' which represents the letter the player chose
             */
            view.getBButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                letterButtonEventHandler("b");
            }               
            }
            );

            /**
             * Action listener and action performed for 'C' button.
             * passes in the String 'c' which represents the letter the player chose
             */
            view.getCButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                letterButtonEventHandler("c");
            }               
            }
            );

            /**
             * Action listener and action performed for 'D' button.
             * passes in the String 'd' which represents the letter the player chose
             */
            view.getDButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                letterButtonEventHandler("d");
            }               
            }
            );

            view.getQuitButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }               
            }
            );

            view.getAskAudButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                askAudEventHandler();
            }               
            }
            );

            view.getFifty50Button().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                fifty50EventHandler();
            }               
            }
            );

            view.getPhoneButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                phoneEventHandler();
            }               
            }
            );


            view.getHelpButton().addActionListener(new ActionListener(){@Override
            public void actionPerformed(ActionEvent e)
            {
                helpEventHandler();
            }               
            }
            );
        }
        else 
        {
            System.exit(0); //exits the game
        }
    }

    /**
     * Controller class constructor
     * play method takes in YES_OPTION to start so game works on initialization
     */
    public WWTBAMController() 
    {   
        play(YES_OPTION);       
    } 
}

