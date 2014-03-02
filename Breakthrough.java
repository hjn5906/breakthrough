import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Breakthrough extends JFrame implements ActionListener
{
   private JButton[][] gridUnits; // array holding grid square buttons
   private JMenuBar jmb;
   private JMenu jmFile, jmHelp;
   private JMenuItem jmiExit, jmiAbout;
   private int x = 0;
   private int x2 = 0;
   private int x3 = 7;
   private int x4 = 7;

   private int y = 0;
   private int y2 = 7;
   private boolean found = false;

   
   public Breakthrough()
   {
         
      //JMenuBar objects
      jmb = new JMenuBar(); 
      jmFile = new JMenu("File");
      jmHelp = new JMenu("Help");
      jmiExit = new JMenuItem("Exit");
      jmiAbout = new JMenuItem("About");
      
      //adding JMenuBar objects to the JFrame, gui
      jmFile.add(jmiExit); 
      jmHelp.add(jmiAbout); 
      jmb.add(jmFile); 
      jmb.add(jmHelp); 
      setJMenuBar(jmb);
      
      //Mnemonic objects
      jmFile.setMnemonic(KeyEvent.VK_F);
      jmHelp.setMnemonic(KeyEvent.VK_H);
      jmiExit.setMnemonic(KeyEvent.VK_X);
      jmiAbout.setMnemonic(KeyEvent.VK_A);
      
      //Adding ActionListener
      jmiExit.addActionListener(this); 
      jmiAbout.addActionListener(this);

   
      //creates grid
      JPanel grid = new JPanel();
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
         
         }
      
      }
            
            
      //sets text for 16 buttons to the letter "X"
      for( int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 0;cols <2; cols++)
         {
            gridUnits[rows][cols].setText("X");
         }
      }
   
     
      //sets text for 16 buttons to the letter "O"
   
      for(int rows = 0; rows< gridUnits.length; rows++)
      {
         
         for(int cols = 6;cols <8; cols++)
         {
            gridUnits[rows][cols].setText("O");
         }
         
      }      
      
      add(grid);
      
      for (int rows = 0; rows < gridUnits.length; rows++)
      {
       
         for(int cols = 0; cols < gridUnits.length; cols++)
         {
            gridUnits[rows][cols].addActionListener(this);
         
         }
      
      }
   
      
   
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      Object choice = ae.getSource();
      
      if(choice.equals(jmiExit))
      {
         System.exit(0);
      }
      else if(choice.equals(jmiAbout))
      {
         JOptionPane.showMessageDialog(null,"121 MiniPrject: Chess" +
				"\nFebruary 19, 2014" + "\nDeveloped By Hassan Ndow & Kevin Whetstone", "Chess", JOptionPane.INFORMATION_MESSAGE);
      }
      
      try
      { 
         //Piece Moves
         outerLoop:
         for (int rows = 0; rows < gridUnits.length; rows++)
         {
         
            for(int cols = 0; cols < gridUnits.length; cols++)
            {
               
               
               
               //saves location of X piece clicked on
               if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getText().equals("X")))
               {
                  x = rows;
                  x3 = rows;
                  y = cols;
                  
               
               }

               //moves x piece horizontally
               if(choice == gridUnits[x][y+1] && (gridUnits[x][y].getText().equals("X")) && (gridUnits[x][y+1].getText().equals("")))
               {
                  gridUnits[x][y].setText("");
                  gridUnits[x][y+1].setText("X");
                 
                  break outerLoop;                 
               }
               
               //moves x piece diagonally(right + up)
               if(x3 > 0)
               {
                  if(choice == gridUnits[x3-1][y+1] && (gridUnits[x][y].getText().equals("X")) && ((gridUnits[x3-1][y+1].getText().equals("")) || (gridUnits[x3-1][y+1].getText().equals("O"))))
                  {
                     gridUnits[x][y].setText("");
                     gridUnits[x3-1][y+1].setText("X");
                    
                     break outerLoop;                 
                  }
               }
               
               //moves x piece diagonally(right + down)
               if(x<7)
               {
                  if(choice == gridUnits[x+1][y+1] && (gridUnits[x][y].getText().equals("X")) && ((gridUnits[x+1][y+1].getText().equals("")) || (gridUnits[x+1][y+1].getText().equals("O"))))
                  {
                     gridUnits[x][y].setText("");
                     gridUnits[x+1][y+1].setText("X");
                    
                     break outerLoop;                 
                  }
               }


               
               
               //save location of O piece clicked on
               if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getText().equals("O")))
               {
                  x2 = rows;
                  x4 = rows;
                  y2 = cols;
 
               }

               //moves o piece horizontally
               if(choice == gridUnits[x2][y2-1] && (gridUnits[x2][y2].getText().equals("O")) && (gridUnits[x2][y2-1].getText().equals("")))
               {
                  gridUnits[x2][y2].setText("");
                  gridUnits[x2][y2-1].setText("O");
                  break outerLoop;
               
               }
               
               //moves O piece diagonally(right + up)
               if(x4 > 0)
               {
                  if(choice == gridUnits[x4-1][y2-1]  && (gridUnits[x2][y2].getText().equals("O")) && ((gridUnits[x4-1][y2-1].getText().equals("")) || (gridUnits[x4-1][y2-1].getText().equals("X"))))
                  {
                     gridUnits[x2][y2].setText("");
                     gridUnits[x4 - 1][y2-1].setText("O");
                     break outerLoop;
                  
                  }
               }
               
               //moves O piece diagonally(right + down)
               if(x2 < 7)
               {
                  if(choice == gridUnits[x2+1][y2-1]  && (gridUnits[x2][y2].getText().equals("O")) && ((gridUnits[x2+1][y2-1].getText().equals("")) || (gridUnits[x2+1][y2-1].getText().equals("X"))))
                  {
                     gridUnits[x2][y2].setText("");
                     gridUnits[x2+1][y2-1].setText("O");
                     break outerLoop;
                  
                  }
               }




            }
         
         }//end of outer for loop 
         
        
         
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
