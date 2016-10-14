import javax.swing.*;
import java.awt.*;
import java.util.*;

public class HubInterface{
   private String result;
   private JFrame frame;
   private JTextArea text;
   private JPanel panel;

   public HubInterface() {
      result = "";
      
      panel = new JPanel();

      text = new JTextArea (100, 100);
      text.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
      text.setBackground(Color.ORANGE);
      text.setEditable(false);
      text.append("\tID\tOrganizer\tEvent\tTime\tPlace\tMax\tDescription\t\tPeople in group\n");
      JScrollPane scroll = new JScrollPane(text);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
      scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

      panel.add ( scroll );
   
      frame = new JFrame("HUB DashBoard");
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   public String in(String txt) {
      result = JOptionPane.showInputDialog(txt);
      return result;
   }

   public void println(String txt) {
      JOptionPane.showMessageDialog(null, txt);
   }

   public void print(String txt) {
      JOptionPane.showMessageDialog(null, txt);
   }

   public void Dashboard(String txt) {
      text.append(txt);
   }
   
   public void off() {
      frame.setVisible(false);
   }
}
