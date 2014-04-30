import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ControlPanel extends JPanel{
  private JLabel lblTimeLeft = new JLabel("Time Left: 250");
  private JLabel lblScore = new JLabel("Score: 0");
  private GamePanel panelGame;
  
  public ControlPanel(){
    JLabel lblInstructions = new JLabel("Click on a box to remove it. Miss and 2 more spawn.");
    JButton btnStart = new JButton("Start");
    JPanel timeScoreAndButton = new JPanel();
    panelGame = new GamePanel(this);
    btnStart.addActionListener(new HandleBtn());
    timeScoreAndButton.setLayout(new GridLayout(1,3));
    timeScoreAndButton.add(lblTimeLeft);
    timeScoreAndButton.add(btnStart);
    timeScoreAndButton.add(lblScore);
    setLayout(new BorderLayout());
    add(lblInstructions, BorderLayout.NORTH);
    add(timeScoreAndButton, BorderLayout.SOUTH);
    add(panelGame, BorderLayout.CENTER);
  }
  
  public void updateScore(int score){
    lblScore.setText("Score: " + score); 
  }
  
  public void updateTimer(int timeLeft){
    lblTimeLeft.setText("Time Left: " + timeLeft);
  }
  
  private class HandleBtn implements ActionListener{
    public void actionPerformed(ActionEvent e){
      panelGame.start();
    }
  }
}