import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GamePanel extends JPanel{
  private ArrayList<Box> boxes = new ArrayList<Box>();
  private javax.swing.Timer timer;
  private int numHit = 0;
  private int numTicks = 250;
  private ControlPanel cp;
  private boolean running = false;
  private int totalBoxes = 10;
  
  public GamePanel(ControlPanel big){
    cp = big;
    setBackground(Color.YELLOW);
    setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    Box.setSpeedLimits(-5,5);
    HandleMouse hm = new HandleMouse();
    addMouseListener(hm);
    timer = new javax.swing.Timer(40, new HandleTimer());
    timer.start();
  }
  
  public void start(){
    boxes.clear();
    numHit = 0;
    numTicks = 250;
    totalBoxes = 10;
    running = true;
    timer.start();
    cp.updateScore(100*numHit/totalBoxes);
    cp.updateTimer(numTicks);
    for (int i = 0; i<totalBoxes; i++){
      Box b = new Box((int)((getWidth()+1)*Math.random()), (int)((getHeight()+1)*Math.random()), 30, 30); 
      boxes.add(b);
    }
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for (int i = 0; i<boxes.size(); i++){
      boxes.get(i).draw(g);
    }
  }
  
  private class HandleTimer implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (running){
        numTicks--;
        
        if (numTicks <= 0){
          timer.stop();
          running = false;
        }
        if (boxes.size() <= 0){
          repaint();
          timer.stop();
          running = false;
        }
        cp.updateTimer(numTicks);
        for(int i = 0; i<boxes.size(); i++){
          boxes.get(i).move(getWidth(), getHeight()); 
        }
        repaint();
      }
    }
  }
  private class HandleMouse extends MouseAdapter{
    public void mousePressed(MouseEvent e){
      if (running){
        for (int i = 0; i<boxes.size(); i++){
          if (boxes.get(i).contains(e.getX(), e.getY())){
            boxes.remove(i);
            numHit++;
            cp.updateScore(100*numHit/totalBoxes);
            return;
          }/*else{ //PROBLEM IN THIS ELSE STATEMENT!!!
           for (int j = i; j<i+2; j++){
           Box w = new Box(e.getX(), e.getY(), 30, 30); 
           boxes.add(w);
           }*/
        }
        for (int j = 0; j<2; j++){
          Box w = new Box(e.getX(), e.getY(), 30, 30);
          boxes.add(w);
        }
        repaint();
      }
    }
  }
}
