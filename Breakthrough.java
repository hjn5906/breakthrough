import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Breakthrough extends JFrame
{
   private JButton[] gridUnits;
   
   public Breakthrough()
   {
      
      //creates grid
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(8,8));
      grid.setSize(700,700);
      
      //creates grid squares
      gridUnits = new JButton[64]; 
      
      //creates 64 buttons
      for(int i = 0; i< gridUnits.length; i++) 
      {
         gridUnits[i] = new JButton();
         
      } 
      
      //adds 64 buttons to the grid
      for (int i = 0; i < 16; i++)
      {
       
            for(int j = 0; j < 4; j++)
            {
               grid.add(gridUnits[4 * i + j]);
  
            }
        
      }
      
      add(grid);
   
   }
   
   public static void main (String[] args)
   {
      Breakthrough bt = new Breakthrough();
      bt.setSize(700,700);
      bt.setLocationRelativeTo(null);
      bt.setVisible(true);
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}