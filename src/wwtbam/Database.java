/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class representing the database of a new game of Who Wants To Be A Millionaire
 * @author Devin Grant-Miles
 */
public class Database 
{
    //attributes for accessing database
    private final String url = "jdbc:derby:WWTBAMDB; create=true";  //url of the DB host
    private final String username = "Devin";  // DB username
    private final String password = "de362880";   // DB password

    private Connection conn = null;
    private Statement statement = null;
    private ResultSet rs = null;
    
    /**
     * Method for loading the questions from the embedded database into the Question ArrayList (qList)
     * @param qList list of questions to be populated
     */
    public final void loadQuestions(ArrayList<Question> qList)  
    {       
        try
        {
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();

            rs = statement.executeQuery("SELECT * FROM Questions");

            int index = 0;

            while (rs.next())
            {
                qList.add(new Question());
                qList.get(index).setQuestionToAsk(rs.getString("QUESTION"));
                qList.get(index).getAnswers().add(rs.getString("ANSWERA"));
                qList.get(index).getAnswers().add(rs.getString("ANSWERB"));
                qList.get(index).getAnswers().add(rs.getString("ANSWERC"));
                qList.get(index).getAnswers().add(rs.getString("ANSWERD"));
                qList.get(index).setCorrectA(rs.getString("CORRECTA"));
                qList.get(index).setPhoneHint(rs.getString("HINT"));     
                index++;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error while loading questions: "+e.getMessage());
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Database error while loading questions: "+e.getMessage());
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
          
     /**
     * Method for reading scores database 
     * @return String containing previous winners
     */
    public String readFile()
    {
        String names = "<html>Behold! The Who Wants to Be a Millionaire hall of fame featuring all of our past millioniare winners!\n<br/><br/>";
    
        try
        {
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();

            rs = statement.executeQuery("SELECT * FROM Scores");
            

            while (rs.next())
            {
                names = names+"**"+rs.getString("Player")+"**\n<br/>";
            }            
        }
        catch (SQLException e)
        {
            System.out.println("Database error while loading previous winners: "+e.getMessage());
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Database error while loading previous winners: "+e.getMessage());
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    
        return names;
    }
    
     /**
     * Method for writing new winners to the scores database
     * @param name String which is the name of the winning player to be saved
     */
    public void writeToFile(String name) 
    {        
        try
        {
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            
            statement.executeUpdate("INSERT INTO SCORES VALUES('"+name+"')");
        }
        catch (SQLException e)
        {
            System.out.println("Database error while saving winning players name: "+e.getMessage());
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Database error while saving winning players name: "+e.getMessage());
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }   
}
