import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


/**
 * Author:      Hassan Ndow, Kevin Whetstone             <br>
 * Date:        February 19,2014                         <br>
 * Purpose:     This is a turn based strategy board game 
 *              called Breakthrough<br>            
 */

//start of Breakthrough class
public class Breakthrough extends JFrame implements ActionListener
{

   //instance variables
   private JButton[][] gridUnits;                              // array holding grid square buttons
   private JMenuBar jmb;                                       // the menu bar
   private JMenu jmFile, jmHelp;                               // the menus
   private JMenuItem jmiExit, jmiStart, jmiRestart, jmiAbout, jmiRule;     // the menu items
   private int x = 0;                                          // stores current row of black piece when moving right or right + down
   private int x3 = 7;                                         // stores current row of black piece when moving right + down
   private int y = 0;                                          // stores current column of black piece
   private int x2 = 0;                                         // stores current row of white piece when moving left or left + down
   private int x4 = 7;                                         // stores current row of white piece when moving left + down
   private int y2 = 7;                                         // stores current column of black piece
   private boolean turn;                                       // decides which player's turn it is
   private boolean gameSet = false;                            // decides if a player has won the game or not
   private ImageIcon black;                                    // image of a black horse                                
   private ImageIcon white;                                    // image of a white horse
   private ImageIcon blank;                                    // image of a blank white tile
   private JLabel player;                                      // identifies the player
   private JPanel grid;                                        // the breakthrough grid
   private int whiteCount = 0;                                 // counts how many white pieces were taken
   private int blackCount = 0;                                 // counts how many black pieces were taken

   
   //start of constructor
   /**
      Constructor creates the GUI interface with no pieces loaded on it
   */
   
   public Breakthrough()
   {
      //determines which players start first
      turn = Math.random() < 0.5;
      
      //defines icons   
      black = new ImageIcon("black.jpg");
      white = new ImageIcon("white.jpg");
      blank = new ImageIcon("blank.jpg"); 
        
      //JMenuBar objects
      jmb = new JMenuBar(); 
      jmFile = new JMenu("File");
      jmHelp = new JMenu("Help");
      jmiStart = new JMenuItem("Start game");
      jmiRestart = new JMenuItem("Restart game");
      jmiRestart.setEnabled(false);
      jmiExit = new JMenuItem("Exit");
      jmiAbout = new JMenuItem("About");
      jmiRule = new JMenuItem("Rules");
      
      //adding JMenuBar objects to the JFrame
      jmFile.add(jmiStart); 
      jmFile.add(jmiRestart);
      jmFile.add(jmiExit); 
      jmHelp.add(jmiAbout); 
      jmHelp.add(jmiRule); 
      jmb.add(jmFile); 
      jmb.add(jmHelp); 
      setJMenuBar(jmb);
      
      //Mnemonic objects
      jmFile.setMnemonic(KeyEvent.VK_F);
      jmHelp.setMnemonic(KeyEvent.VK_H);
      jmiExit.setMnemonic(KeyEvent.VK_X);
      jmiAbout.setMnemonic(KeyEvent.VK_A);
      jmiRule.setMnemonic(KeyEvent.VK_R);
      jmiStart.setMnemonic(KeyEvent.VK_S);
      jmiRestart.setMnemonic(KeyEvent.VK_T);
      
      //Adding ActionListener
      jmiStart.addActionListener(this);
      jmiRestart.addActionListener(this);
      jmiExit.addActionListener(this); 
      jmiAbout.addActionListener(this);
      jmiRule.addActionListener(this);
           
           
      //creates grid
      grid = new JPanel();
      grid.setLayout(new GridLayout(8,8));
      grid.setSize(700,700);
   
      
      //creates grid squares
      gridUnits = new JButton[8][8];
      
      //creates 64 grid square buttons
      for(int rows = 0; rows< gridUnits.length;rows++)
      {
         for(int cols = 0; cols< gridUnits.length; cols++)
         { 
            gridUnits[rows][cols] = new JButton();
         }
         
      } 
      
      
      //adds 64 buttons to the grid and sets them to the blank.jpg
      for (int rows = 0; rows < gridUnits.length; rows++)
      {
       
         for(int cols = 0; cols < gridUnits.length; cols++)
         {
            grid.add(gridUnits[rows][cols]);
            gridUnits[rows][cols].setIcon(blank);
         
         }
      
      }
      
      //adds the grid to the JFrame
      add(grid);
 
   } //end of constructor
   
   //start of the load method that loads the pieces to the grid
   public void load()
   {
      //adds a placeholder text that will eventually change into the player who gets the first turn
      add(player = new JLabel("", JLabel.CENTER),BorderLayout.NORTH);
          
      //if turn == 0/false    
      if(turn == false)
      {
         player.setText("<html><strong><font color='red'>Player 1 starts first!</font></strong></html>");
      }
      
      //if turn == 1/true
      if(turn == true)
      {
         player.setText("<html><strong><font color='blue'>Player 2 starts first!</font></strong></html>");
      }
      
                  
            
      //sets icons for the left 16 buttons to the icon black
      for( int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 0;cols <2; cols++)
         {
            gridUnits[rows][cols].setIcon(black);
         }
      }
   
     
      //sets icons for the right 16 buttons to the icon white
      for(int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 6;cols <8; cols++)
         {
            gridUnits[rows][cols].setIcon(white);
         
         }
         
      }  

      
      //adds actionListeners to all of the 64 buttons
      for (int rows = 0; rows < gridUnits.length; rows++)
      {
       
         for(int cols = 0; cols < gridUnits.length; cols++)
         {
            gridUnits[rows][cols].addActionListener(this);
         
         }
      
      }
   
   } // end of load method
   
   //start of restart method
   public void restart()
   {
      //resets values     
      x = 0;                                          // stores current row of black piece when moving right or right + down
      x3 = 7;                                         // stores current row of black piece when moving right + down
      y = 0;                                          // stores current column of black piece
      x2 = 0;                                         // stores current row of white piece when moving left or left + down
      x4 = 7;                                         // stores current row of white piece when moving left + down
      y2 = 7;                                         // stores current column of black piece
      gameSet = false;                            // decides if a player has won the game or not
      whiteCount = 0;                                 // counts how many white pieces were taken
      blackCount = 0;                                 // counts how many black pieces were taken
      
      
      //determines which players start first
      turn = Math.random() < 0.5; 
          
      //if turn == 0/false    
      if(turn == false)
      {
         player.setText("<html><strong><font color='red'>Player 1 starts first!</font></strong></html>");
      }
      
      //if turn == 1/true
      if(turn == true)
      {
         player.setText("<html><strong><font color='blue'>Player 2 starts first!</font></strong></html>");
      }
      
                  
            
      //sets icons for the left 16 buttons to the icon black
      for( int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 0;cols <2; cols++)
         {
            gridUnits[rows][cols].setIcon(black);
         }
      }
   
     
      //sets icons for the right 16 buttons to the icon white
      for(int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 6;cols <8; cols++)
         {
            gridUnits[rows][cols].setIcon(white);
         
         }
         
      }
      
      //sets icons for the middle 32 buttons to the icon blank
      for(int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 2;cols <6; cols++)
         {
            gridUnits[rows][cols].setIcon(blank);
         
         }
         
      } 
      
      //adds actionListeners to all of the 64 buttons
      for (int rows = 0; rows < gridUnits.length; rows++)
      {
       
         for(int cols = 0; cols < gridUnits.length; cols++)
         {
            gridUnits[rows][cols].addActionListener(this);
         
         }
      
      }

   } // end of restart method
   
   

   
   //start of player1Wins method - If Player 1 wins
   public void player1Wins(int y)
   {
      //if a black piece is in the last column
      if(y+1 == 7)
      {
         player.setText("<html><font size='16' color='purple'>Player 1 wins!</font></html>");
         gameSet = true;
      }
   }
   
   //start of player2Wins method - If Player 2 wins
   public void player2Wins(int y2)
   {
      //if a white piece is in the last column
      if(y2-1 == 0)
      {
         player.setText("<html><font size='16' color='purple'>Player 2 wins!</font></html>");
         gameSet = true;
         
      }
   }
   
   // start of actionPerformed method
   public void actionPerformed(ActionEvent ae)
   {
      Object choice = ae.getSource(); // gets source of button clicked on
      
      
      //if Exit was clicked, exit the program
      if(choice.equals(jmiExit))
      {
         System.exit(0);
      }
      
      //If start game was clicked, load the pieces
      if(choice.equals(jmiStart))
      {
         load();
         jmiStart.setEnabled(false);
         jmiRestart.setEnabled(true);
      }
      
      //If restart game was clicked, restart the pieces
      if(choice.equals(jmiRestart))
      {
         restart();
         jmiStart.setEnabled(false);
      }

      
      //If about was clicked, display info about the game
      if(choice.equals(jmiAbout))
      {
         JOptionPane.showMessageDialog(null,"121 MiniPrject: Chess" +
            "\nFebruary 19, 2014" + "\nDeveloped By Hassan Ndow & Kevin Whetstone", "Breakthrough", JOptionPane.INFORMATION_MESSAGE);
      }
      
      //If Rules was clicked, display the rules of the game
      if(choice.equals(jmiRule))
      {
         JOptionPane.showMessageDialog(null,"1. Random player gets first turn.\n" +
            "2. A piece may move one space forward, directly or \ndiagonally, into an empty space. Pieces may not \nmove backward.\n"+
            "3. A piece may capture an opposing piece, removing it \nfrom the board, by moving diagonally forward into \nthe space it occupies. You may not move a piece \ndirectly forward into a space occupied by your \nown piece.\n"+
            "4. The game ends when a player moves a piece to the \nrow on the opposite edge of the board. The player to \naccomplish that first wins."
            		,"Rules",JOptionPane.INFORMATION_MESSAGE);
      }
      
       
      
      try
      {
         if(gameSet == false)
         {
            //Pieces Moves -- loops through each [row][column]
            outerLoop:
            for (int rows = 0; rows < gridUnits.length; rows++)
            {
            
               for(int cols = 0; cols < gridUnits.length; cols++)
               {
                  //player 1's move
                  if(turn == false)
                  {
                     
                     //saves location of black piece clicked on
                     if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getIcon().equals(black)))
                     {
                        x = rows;
                        x3 = rows;
                        y = cols;
                     
                     }
                  
                     //moves black piece horizontally
                     if(choice == gridUnits[x][y+1] && (gridUnits[x][y].getIcon().equals(black)) && 
                        (gridUnits[x][y+1].getIcon().equals(blank)))
                     {
                        //sets its previous location to blank, its new location to black, checks if player has won
                        //alternates turn by setting turn to true
                        //if game is won displays message
                        //breaks out of loop
                        
                        gridUnits[x][y].setIcon(blank);
                        gridUnits[x][y+1].setIcon(black);
                        player1Wins(y);
                        turn = true;
                        if(gameSet == false)
                        {
                           player.setText("<html>"+"<strong><font color='blue'>Player 2's turn!</font></strong>  |  " 
                                       + "<font color='green'>" + blackCount + "</font>" + " black pieces taken." + "</html>");
                        }
                        break outerLoop;                 
                     }
                     
                     //moves black piece diagonally(right + up) as long as it doesn't go past its bounds
                     if(x3 > 0)
                     {
                        if(choice == gridUnits[x3-1][y+1] && (gridUnits[x][y].getIcon().equals(black)) && 
                           ((gridUnits[x3-1][y+1].getIcon().equals(blank)) || (gridUnits[x3-1][y+1].getIcon().equals(white))))
                        {
                           //sets its previous location to blank, its new location to black, checks if player has won
                           //counts white pieces that it has taken
                           //alternates turn by setting turn to true
                           //if game is won displays message
                           //breaks out of loop
                           
                           gridUnits[x][y].setIcon(blank);
                           
                           if(gridUnits[x3-1][y+1].getIcon().equals(white))
                           {
                              whiteCount++;
                           }
                           gridUnits[x3-1][y+1].setIcon(black);
                           player1Wins(y);
                           turn = true;
                           if(gameSet == false)
                           {
                              player.setText("<html>"+"<strong><font color='blue'>Player 2's turn!</font></strong>  |  " 
                                          + "<font color='green'>" + blackCount + "</font>" + " black pieces taken." + "</html>");
                           }
                           break outerLoop;                 
                        }
                     }
                     
                     
                     //moves x piece diagonally(right + down) as long as it doesn't go past its bounds
                     if(x<7)
                     {
                        if(choice == gridUnits[x+1][y+1] && (gridUnits[x][y].getIcon().equals(black)) && 
                           ((gridUnits[x+1][y+1].getIcon().equals(blank)) || (gridUnits[x+1][y+1].getIcon().equals(white))))
                        {
                           //sets its previous location to blank, its new location to black, checks if player has won
                           //counts white pieces that it has taken
                           //alternates turn by setting turn to true
                           //if game is won displays message
                           //breaks out of loop
                           
                           gridUnits[x][y].setIcon(blank);
                           
                           if(gridUnits[x+1][y+1].getIcon().equals(white))
                           {
                              whiteCount++;
                           }
                           
                           gridUnits[x+1][y+1].setIcon(black);
                           player1Wins(y);
                           turn = true;
                           if(gameSet == false)
                           {
                              player.setText("<html>"+"<strong><font color='blue'>Player 2's turn!</font></strong>  |  " 
                                          + "<font color='green'>" + blackCount + "</font>" + " black pieces taken." + "</html>");
                           }
                           break outerLoop;                 
                        }
                     }
                  
                  } // end of if(turn == false)
               
               
                  
                  if(turn == true)
                  {
                     
                     //save location of O piece clicked on
                     if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getIcon().equals(white)))
                     {
                        x2 = rows;
                        x4 = rows;
                        y2 = cols;
                     
                     }
                  
                     //moves o piece horizontally
                     if(choice == gridUnits[x2][y2-1] && (gridUnits[x2][y2].getIcon().equals(white)) && 
                        (gridUnits[x2][y2-1].getIcon().equals(blank)))
                     {
                        
                        //sets its previous location to blank, its new location to white, checks if player has won
                        //alternates turn by setting turn to false
                        //if game is won displays message
                        //breaks out of loop
                        
                        gridUnits[x2][y2].setIcon(blank);
                        gridUnits[x2][y2-1].setIcon(white);
                        player2Wins(y2);
                        turn = false;
                        
                        if(gameSet == false)
                        {
                           player.setText("<html>"+"<strong><font color='red'>Player 1's turn!</font></strong>  |  " 
                                        + "<font color='green'>" + whiteCount + "</font>" + " white pieces taken." + "</html>");
                        }
                        break outerLoop;
                     
                     }
                     
                     //moves O piece diagonally(right + up) as long as it hasn't gone past its bounds
                     if(x4 > 0)
                     {
                        if(choice == gridUnits[x4-1][y2-1]  && (gridUnits[x2][y2].getIcon().equals(white)) && 
                           ((gridUnits[x4-1][y2-1].getIcon().equals(blank)) || (gridUnits[x4-1][y2-1].getIcon().equals(black))))
                        {
                        
                           //sets its previous location to blank, its new location to white, checks if player has won
                           //counts black pieces that it has taken
                           //alternates turn by setting turn to false
                           //if game is won displays message
                           //breaks out of loop
                           
                           gridUnits[x2][y2].setIcon(blank);
                           
                           if(gridUnits[x4-1][y2-1].getIcon().equals(black))
                           {
                              blackCount++;
                           }
                           
                           gridUnits[x4 - 1][y2-1].setIcon(white);
                           player2Wins(y2);
                           turn = false;
                           if(gameSet == false)
                           {
                              player.setText("<html>"+"<strong><font color='red'>Player 1's turn!</font></strong>  |  " 
                                           + "<font color='green'>" + whiteCount + "</font>" + " white pieces taken." + "</html>");
                           }
                        
                           break outerLoop;
                        
                        }
                     }
                     
                     //moves O piece diagonally(right + down) as long as it hasn't gone past its bounds
                     if(x2 < 7)
                     {
                        if(choice == gridUnits[x2+1][y2-1]  && (gridUnits[x2][y2].getIcon().equals(white)) && 
                           ((gridUnits[x2+1][y2-1].getIcon().equals(blank)) || (gridUnits[x2+1][y2-1].getIcon().equals(black))))
                        {
                           
                           //sets its previous location to blank, its new location to white, checks if player has won
                           //counts black pieces that it has taken
                           //alternates turn by setting turn to false
                           //if game is won displays message
                           //breaks out of loop
                           
                           gridUnits[x2][y2].setIcon(blank);
                           
                           if(gridUnits[x2+1][y2-1].getIcon().equals(black))
                           {
                              blackCount++;
                           }
                           
                           gridUnits[x2+1][y2-1].setIcon(white);
                           player2Wins(y2);
                           turn = false;
                           if(gameSet == false)
                           {
                              player.setText("<html>"+"<strong><font color='red'>Player 1's turn!</font></strong>  |  " 
                                           + "<font color='green'>" + whiteCount + "</font>" + " white pieces taken." + "</html>");
                           }
                           break outerLoop;
                        
                        }
                     }
                     
                  } // end of if(turn == false)

               } // end of inner loop
            
            }//end of outer for loop 

         }  // end of gameSet if statement 
         
      } // end of try block
      
      //catch any exceptions
      catch(NullPointerException npe)
      {
         npe.printStackTrace();
      }
      catch(ArrayIndexOutOfBoundsException aio)
      {
         aio.printStackTrace();
      }
    
   }//end of actionPerformed
   

 
   //start of main
   public static void main (String[] args)
   {
      
      //creates a Breakthrough object
      Breakthrough bt = new Breakthrough();
      
      //Sets the JFrame
      bt.setTitle("Breakthrough");
      bt.setSize(700,700);
      bt.setLocationRelativeTo(null);
      bt.setVisible(true);
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
