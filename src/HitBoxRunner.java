import javax.swing.*;
import java.awt.*;

public class HitBoxRunner{
  public static void main(String[] args){
    JFrame f = new JFrame();
    f.setTitle("Hit 'em!");
    f.setSize(400,450);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = f.getContentPane();
    
    ControlPanel p = new ControlPanel();
    
    pane.add(p);
    f.setVisible(true);
  }
}
