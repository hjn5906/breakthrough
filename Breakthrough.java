import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Breakthrough extends JFrame implements ActionListener
{
   private JButton[][] gridUnits; // array holding grid square buttons
   private int x = 0;
   private int y = 0;
   private int y2 = 7;
   private boolean found = false;

   
   public Breakthrough()
   {
         
      //JMenu
      JMenuBar jmb = new JMenuBar();
      setJMenuBar(jmb);
      
      //File
      JMenu jmFile = new JMenu("File");
      jmFile.setMnemonic(KeyEvent.VK_F);
      
      //Help
      JMenu jmHelp = new JMenu("Help");
      jmHelp.setMnemonic(KeyEvent.VK_H);
      
      //File Items
      JMenuItem jmiOpen = new JMenuItem("Open");
      JMenuItem jmiSave = new JMenuItem("Save");
      JMenuItem jmiExit = new JMenuItem("Exit");
      
      //File Objects
      jmb.add(jmFile);
      jmFile.add(jmiOpen);
      jmiOpen.setMnemonic(KeyEvent.VK_O);
      jmFile.add(jmiSave);
      jmiSave.setMnemonic(KeyEvent.VK_S);
      jmFile.add(jmiExit);
      jmiOpen.setMnemonic(KeyEvent.VK_E);
      
      //Help Item
      JMenuItem jmAbout = new JMenuItem("About");
      
      jmHelp.add(jmAbout);
      jmb.add(jmHelp);
   
   
      
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
    
   
         /*
         //loop to locate pieces  
         for (int i = 0; i < 8; i++) 
         {
            gridUnits[1][i].add(new JLabel(new ImageIcon("bpawn.gif")));
            gridUnits[6][i].add(new JLabel(new ImageIcon("wpawn.gif")));
         }
         */
   
      
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
      
      
      try
      { 
         for (int rows = 0; rows < gridUnits.length; rows++)
         {
         
            for(int cols = 0; cols < gridUnits.length; cols++)
            {
               
               
               if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getText().equals("X")) &&(x == 0 && y == 0))
               {
                  x = rows;
                  y = cols;
 
               }

            
               if(choice == gridUnits[x][y+1] && (gridUnits[x][y].getText().equals("X")) && (gridUnits[x][y+1].getText().equals("")))
               {
                  gridUnits[x][y].setText("");
                  gridUnits[x][y+1].setText("X");
               
               }

                
               if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getText().equals("X")))
               {
                  x = rows;
                  y = cols;
               
               }

               
               if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getText().equals("O")) &&(x == 0 && y2 == 7))
               {
                  x = rows;
                  y2 = cols;
 
               }

            
               if(choice == gridUnits[x][y2-1] && (gridUnits[x][y2].getText().equals("O")) && (gridUnits[x][y2-1].getText().equals("")))
               {
                  gridUnits[x][y2].setText("");
                  gridUnits[x][y2-1].setText("O");
               
               }

                
               if(choice == gridUnits[rows][cols] && (gridUnits[rows][cols].getText().equals("O")))
               {
                  x = rows;
                  y2 = cols;
               
               }
            
            }
         
         }//end of outer for loop
      }
      
      catch(NullPointerException npe)
      {
      
      }
      catch(ArrayIndexOutOfBoundsException aio)
      {
      
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
