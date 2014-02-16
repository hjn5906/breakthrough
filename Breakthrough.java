import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Breakthrough extends JFrame
{
   private JButton[] gridUnits; // array holding grid square buttons
   
   public Breakthrough()
   {
      setTitle("Group 4 Chess Game");
      
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
        
      }
      
      add(grid);
   
   }
   
   public void actionPerformed(ActionEvent ae)
   {
   }
   
   public static void main (String[] args)
   {
      Breakthrough bt = new Breakthrough();
      bt.setTitle("Breakthrough");
      bt.setSize(700,700);
      bt.setLocationRelativeTo(null);
      bt.setVisible(true);
      bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
