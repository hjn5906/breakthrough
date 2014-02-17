import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Breakthrough extends JFrame
{
   private JButton[] gridUnits; // array holding grid square buttons
   
   public Breakthrough()
   {
         
      //JMenu
      JMenuBar jmb = new JMenuBar();
      setJMenuBar(jmb);
      JMenu jmFile = new JMenu("File"); 
      
      JMenuItem jmiSave = new JMenuItem("Save");
      JMenuItem jmiExit = new JMenuItem("Exit");
      
      jmb.add(jmFile);
      jmFile.add(jmiSave);
      jmFile.add(jmiExit);
      
      //creates grid
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(8,8));
      grid.setSize(700,700);

      //creates grid squares
      gridUnits = new JButton[64];
      
      //creates 64 grid square buttons
      for(int i = 0; i< gridUnits.length; i++)
      {
         gridUnits[i] = new JButton();
         
      }
      
      //adds 64 buttons to the grid
      //iterator formula start : i = 0, j = 0, gridUnits[4 * 0 + 0] = gridUnits[0]
      //iterator formula end : i = 15, j = 3, gridUnits[4 * 15 + 3] = gridUnits[63]
      for (int i = 0; i < 16; i++)
      {
       
            for(int j = 0; j < 4; j++)
            {
               grid.add(gridUnits[4 * i + j]);
  
            }
            
            
            //sets text for 16 buttons to the letter "X"
            for(int k = 0; k< 8; k++) 
            {
         
               for(int j = 0;j <2; j++)
               {
                   gridUnits[8*k + j].setText("X");
               }
         
            }
            
          //sets text for 16 buttons to the letter "O"
          for(int m = 0; m< 8; m++) 
          {
         
            for(int n = 0;n <2; n++)
            {
               gridUnits[8*m + 6 + n].setText("O");
            }
         
         }
        
     }
      
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
