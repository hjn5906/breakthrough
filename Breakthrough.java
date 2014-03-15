import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Breakthrough extends JFrame implements ActionListener
{
   private JButton[][] gridUnits; // array holding grid square buttons
   private JMenuBar jmb;
   private JMenu jmFile, jmHelp;
   private JMenuItem jmiExit, jmiStart, jmiAbout, jmiRule;
   private int x = 0;
   private int x2 = 0;
   private int x3 = 7;
   private int x4 = 7;
   private boolean turn;
   private boolean gameSet = false;
   private int y = 0;
   private int y2 = 7;
   private boolean found = false;
   private ImageIcon black;
   private ImageIcon white;
   private ImageIcon blank;
   private JLabel player;
   private JPanel grid;
   private int whiteCount = 0;
   private int blackCount = 0;

   
   public Breakthrough()
   {
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
      jmiExit = new JMenuItem("Exit");
      jmiAbout = new JMenuItem("About");
      jmiRule = new JMenuItem("Rules");
      
      //adding JMenuBar objects to the JFrame, gui
      jmFile.add(jmiStart); 
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
      
      //Adding ActionListener
      jmiStart.addActionListener(this);
      jmiExit.addActionListener(this); 
      jmiAbout.addActionListener(this);
      jmiRule.addActionListener(this);

      //adds text identifying who's turn it is
      add(player = new JLabel("", JLabel.CENTER),BorderLayout.NORTH);
          
           
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
      
      //adds 64 buttons to the grid
   
      for (int rows = 0; rows < gridUnits.length; rows++)
      {
       
         for(int cols = 0; cols < gridUnits.length; cols++)
         {
            grid.add(gridUnits[rows][cols]);
            gridUnits[rows][cols].setIcon(blank);
         
         }
      
      }
      
      add(grid);
   
      
      
      
      
   } //end of constructor
   
   
   public void load()
   {
      //adds text identifying who's turn it is
      add(player = new JLabel("", JLabel.CENTER),BorderLayout.NORTH);
          
      if(turn == false)
      {
         player.setText("<html><strong><font color='red'>Player 1 starts first!</font></strong></html>");
      }
      
      if(turn == true)
      {
         player.setText("<html><strong><font color='blue'>Player 2 starts first!</font></strong></html>");
      }
      
                  
            
      //sets text for 16 buttons to the letter "X"
      for( int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 0;cols <2; cols++)
         {
            //gridUnits[rows][cols].setText("X");
            gridUnits[rows][cols].setIcon(black);
         }
      }
   
     
      //sets text for 16 buttons to the letter "O"
   
      for(int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 6;cols <8; cols++)
         {
            //gridUnits[rows][cols].setText("O");
            gridUnits[rows][cols].setIcon(white);
         
         }
         
      } 
      
            
      
      
      
      
      for (int rows = 0; rows < gridUnits.length; rows++)
      {
       
         for(int cols = 0; cols < gridUnits.length; cols++)
         {
            gridUnits[rows][cols].addActionListener(this);
         
         }
      
      }
   
   }
   
   

   
   //If Player 1 wins
   public void player1Wins(int y)
   {
      if(y+1 == 7)
      {
         player.setText("<html><font size='16' color='purple'>Player 1 wins!</font></html>");
         gameSet = true;
         
      }
   }
   
   //If Player 2 wins
   public void player2Wins(int y2)
   {
      if(y2-1 == 0)
      {
         player.setText("<html><font size='16' color='purple'>Player 2 wins!</font></html>");
         gameSet = true;
         
      }
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      Object choice = ae.getSource();
      
      if(choice.equals(jmiExit))
      {
         System.exit(0);
      }
      
      if(choice.equals(jmiStart))
      {
         load();
         jmiStart.setEnabled(false);
      }
      
      if(choice.equals(jmiAbout))
      {
         JOptionPane.showMessageDialog(null,"121 MiniPrject: Chess" +
            "\nFebruary 19, 2014" + "\nDeveloped By Hassan Ndow & Kevin Whetstone", "Chess", JOptionPane.INFORMATION_MESSAGE);
      }
      if(choice.equals(jmiRule))
      {
         JOptionPane.showMessageDialog(null,"1. White moves first.\n" +
		    "2. A piece may move one space forward, directly or \ndiagonally, into an empty space. Pieces may not \nmove backward.\n"+
		    "3. A piece may capture an opposing piece, removing it \nfrom the board, by moving diagonally forward into \nthe space it occupies. You may not move a piece \ndirectly forward into a space occupied by an \nopposing piece.\n"+
		    "4. The game ends when a player moves a piece to the \nrow on the opposite edge of the board. The player to \naccomplish that first wins. If at any point in the \ngame, neither player can make a legal move, the \ngame ends in a draw."
						,"Rules",JOptionPane.INFORMATION_MESSAGE);
     }
      
       
      
      try
      {
         if(gameSet == false)
         {
            //Piece Moves -- loops through each [row][column]
            outerLoop:
            for (int rows = 0; rows < gridUnits.length; rows++)
            {
            
               for(int cols = 0; cols < gridUnits.length; cols++)
               {
                  
                
                  if(turn == false)
                  {
                     
                     //saves location of X piece clicked on
                     if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getIcon().equals(black)))
                     {
                        x = rows;
                        x3 = rows;
                        y = cols;
                     
                     }
                  
                     //moves x piece horizontally
                     if(choice == gridUnits[x][y+1] && (gridUnits[x][y].getIcon().equals(black)) && 
                        (gridUnits[x][y+1].getIcon().equals(blank)))
                     {
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
                     
                     //moves x piece diagonally(right + up)
                     if(x3 > 0)
                     {
                        if(choice == gridUnits[x3-1][y+1] && (gridUnits[x][y].getIcon().equals(black)) && 
                           ((gridUnits[x3-1][y+1].getIcon().equals(blank)) || (gridUnits[x3-1][y+1].getIcon().equals(white))))
                        {
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
                     
                     //moves x piece diagonally(right + down)
                     if(x<7)
                     {
                        if(choice == gridUnits[x+1][y+1] && (gridUnits[x][y].getIcon().equals(black)) && 
                           ((gridUnits[x+1][y+1].getIcon().equals(blank)) || (gridUnits[x+1][y+1].getIcon().equals(white))))
                        {
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
                  
                  }
               
               
                  
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
                     
                     //moves O piece diagonally(right + up)
                     if(x4 > 0)
                     {
                        if(choice == gridUnits[x4-1][y2-1]  && (gridUnits[x2][y2].getIcon().equals(white)) && 
                           ((gridUnits[x4-1][y2-1].getIcon().equals(blank)) || (gridUnits[x4-1][y2-1].getIcon().equals(black))))
                        {
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
                     
                     //moves O piece diagonally(right + down)
                     if(x2 < 7)
                     {
                        if(choice == gridUnits[x2+1][y2-1]  && (gridUnits[x2][y2].getIcon().equals(white)) && 
                           ((gridUnits[x2+1][y2-1].getIcon().equals(blank)) || (gridUnits[x2+1][y2-1].getIcon().equals(black))))
                        {
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
                  }
               
               
               
               
               }
            
            }//end of outer for loop 
            
            
         
         
         }   
      }
      
      catch(NullPointerException npe)
      {
         npe.printStackTrace();
      }
      catch(ArrayIndexOutOfBoundsException aio)
      {
         aio.printStackTrace();
      }
      
      System.out.println(x);
      System.out.println(y);
      System.out.println(black.getIconHeight());
      System.out.println(black.getIconWidth());
      
     
       
   }//end of actionPerformed
   

 
   
   public static void main (String[] args)
   {
      
      //creates a Breakthrough object
      Breakthrough bt = new Breakthrough();
      bt.setTitle("Breakthrough");
      bt.setSize(700,700);
      bt.setLocationRelativeTo(null);
      bt.setVisible(true);
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
