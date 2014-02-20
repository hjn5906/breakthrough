import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Breakthrough extends JFrame implements ActionListener, MouseListener
{
   private JButton[][] gridUnits; // array holding grid square buttons
   
   public Breakthrough()
   {
         
      //JMenu
      JMenuBar jmb = new JMenuBar();
      setJMenuBar(jmb);
      JMenu jmFile = new JMenu("File");
      jmFile.setMnemonic(KeyEvent.VK_F);

      JMenuItem jmiOpen = new JMenuItem("Open");;
      JMenuItem jmiSave = new JMenuItem("Save");
      JMenuItem jmiExit = new JMenuItem("Exit");
      
      jmb.add(jmFile);
      jmFile.add(jmiOpen);
      jmiOpen.setMnemonic(KeyEvent.VK_O);
      jmFile.add(jmiSave);
      jmiSave.setMnemonic(KeyEvent.VK_S);
      jmFile.add(jmiExit);
      jmiOpen.setMnemonic(KeyEvent.VK_E);
      
      //JButton
      JButton jbNew = new JButton("New");
      JButton jbUndo = new JButton("Undo");
      
      //creates grid
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(8,8));
      grid.setSize(700,700);

      //creates grid squares
<<<<<<< HEAD
      gridUnits = new JButton[8][8];
      
      //creates 64 grid square buttons
      for(int rows = 0; rows< gridUnits.length; rows++)
=======
      gridUnits = new JButton[64];
      
      //creates 64 grid square buttons
      for(int i = 0; i< gridUnits.length; i++)
>>>>>>> 9b5a88919683718b4549e33efc1f4d8fad4eb3fc
      {
         for(int cols = 0; cols< gridUnits.length; cols++)
         { 
            gridUnits[rows][cols] = new JButton();
         }
         
      }
      
      //adds 64 buttons to the grid
      //iterator formula start : i = 0, j = 0, gridUnits[4 * 0 + 0] = gridUnits[0]
      //iterator formula end : i = 15, j = 3, gridUnits[4 * 15 + 3] = gridUnits[63]
<<<<<<< HEAD
      for (int rows = 0; rows < gridUnits.length; rows++)
=======
      for (int i = 0; i < 16; i++)
>>>>>>> 9b5a88919683718b4549e33efc1f4d8fad4eb3fc
      {
       
            for(int cols = 0; cols < gridUnits.length; cols++)
            {
               grid.add(gridUnits[rows][cols]);
  
            }
<<<<<<< HEAD
      }
            
            
            //sets text for 16 buttons to the letter "X"
            for( int rows = 0; rows< gridUnits.length; rows++)
            {
         
               for(int cols = 0;cols <2; cols++)
               {
                   gridUnits[rows][cols].setText("X");
=======
            
            
            //sets text for 16 buttons to the letter "X"
            for(int k = 0; k< 8; k++)
            {
         
               for(int j = 0;j <2; j++)
               {
                   gridUnits[8*k + j].setText("X");
>>>>>>> 9b5a88919683718b4549e33efc1f4d8fad4eb3fc
               }
         
            }
            
          //sets text for 16 buttons to the letter "O"
<<<<<<< HEAD
          for( int rows = 0; rows< gridUnits.length; rows++)
            {
         
               for(int cols = 6;cols <8; cols++)
               {
                   gridUnits[rows][cols].setText("O");
               }
         
            }         
=======
          for(int m = 0; m< 8; m++)
          {
         
            for(int n = 0;n <2; n++)
            {
               gridUnits[8*m + 6 + n].setText("O");
            }
         
         }
         
>>>>>>> 9b5a88919683718b4549e33efc1f4d8fad4eb3fc
         /*
         //loop to locate pieces  
         for (int i = 0; i < 8; i++) 
         {
            gridUnits[1][i].add(new JLabel(new ImageIcon("bpawn.gif")));
            gridUnits[6][i].add(new JLabel(new ImageIcon("wpawn.gif")));
         }
         */
        
<<<<<<< HEAD
     
=======
     }
>>>>>>> 9b5a88919683718b4549e33efc1f4d8fad4eb3fc
      
      add(grid);
      
   
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      String selection = ae.getActionCommand();
          
      if(selection.equals("Exit"))
      {
         System.exit(0);
      }
   }
   
<<<<<<< HEAD
=======
   public void actionPerformed(ActionEvent ae)
   {
      String selection = ae.getActionCommand();
          
      if(selection.equals("Exit"))
      {
         System.exit(0);
      }
   }
   
>>>>>>> 9b5a88919683718b4549e33efc1f4d8fad4eb3fc

    public void mouseClicked(MouseEvent me) 
    {


    }

    public void mouseEntered(MouseEvent me) 
    {
    }

   public void mouseExited(MouseEvent me) 
   {

    }

    public void mousePressed(MouseEvent me) 
    {

    }

    public void mouseReleased(MouseEvent me) 
    {

    }  
   
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

<<<<<<< HEAD
=======

>>>>>>> 9b5a88919683718b4549e33efc1f4d8fad4eb3fc
