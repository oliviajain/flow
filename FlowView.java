import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;














public class FlowView
  extends JFrame
{
  private FlowPanel flowPanel;
  private FlowTopPanel topPanel;
  private JPanel northPanel;
  private JPanel resignPanel;
  private JLabel timerLabel;
  private JLabel scoreLabel;
  private JLabel scoreTextLabel;
  private JLabel secondsRemaining;
  private JLabel resignLabel;
  
  public FlowView()
  {
    JLayeredPane layeredPanel = new JLayeredPane();
    setContentPane(layeredPanel);
    layeredPanel.setBounds(0, 0, 635, 700);
    

    JPanel mainPanel = new JPanel();
    
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBounds(0, 0, layeredPanel.getWidth(), layeredPanel.getHeight());
    

    flowPanel = new FlowPanel();
    flowPanel.setPreferredSize(new Dimension(635, 635));
    mainPanel.add(flowPanel, "Center");
    

    northPanel = new JPanel();
    northPanel.setLayout(new BorderLayout());
    northPanel.setPreferredSize(new Dimension(635, 30));
    

    secondsRemaining = new JLabel("Seconds Left: ");
    timerLabel = new JLabel("60");
    timerLabel.setFont(new Font("SansSerif", 0, 20));
    timerLabel.setForeground(Color.RED);
    

    JPanel eastNorthPanel = new JPanel();
    eastNorthPanel.add(secondsRemaining);
    eastNorthPanel.add(timerLabel);
    

    scoreTextLabel = new JLabel("SCORE: ");
    scoreTextLabel.setFont(new Font("SansSerif", 0, 15));
    scoreLabel = new JLabel("0");
    scoreLabel.setFont(new Font("SansSerif", 0, 20));
    scoreLabel.setForeground(Color.MAGENTA);
    

    JPanel westNorthPanel = new JPanel();
    westNorthPanel.add(scoreTextLabel);
    westNorthPanel.add(scoreLabel);
    

    resignLabel = new JLabel("Click here to RESIGN GAME.");
    resignLabel.setFont(new Font("SansSerif", 0, 20));
    resignLabel.setForeground(Color.black);
    

    resignPanel = new JPanel();
    resignPanel.add(resignLabel, "Center");
    

    northPanel.add(eastNorthPanel, "East");
    northPanel.add(westNorthPanel, "West");
    northPanel.add(resignPanel);
    
    mainPanel.add(northPanel, "North");
    

    topPanel = new FlowTopPanel();
    

    layeredPanel.add(mainPanel, new Integer(0), 0);
    layeredPanel.add(topPanel, new Integer(1), 0);
    
    topPanel.requestFocus();
  }
  
  public void hideLabels() {
    scoreTextLabel.setVisible(false);
    secondsRemaining.setVisible(false);
    scoreLabel.setVisible(false);
    timerLabel.setVisible(false);
    resignPanel.setVisible(false);
  }
  
  public void showLabels() {
    scoreTextLabel.setVisible(true);
    secondsRemaining.setVisible(true);
    scoreLabel.setVisible(true);
    timerLabel.setVisible(true);
    resignPanel.setVisible(true);
  }
  
  public void setTimerLabel(String str) {
    timerLabel.setText(str);
  }
  
  public void setScoreLabel(int score) {
    scoreLabel.setText(score);
  }
  
  public void repaintTimerLabel() {
    timerLabel.repaint();
  }
  
  public void repaintScoreLabel() {
    scoreLabel.repaint();
  }
  
  public FlowPanel getFlowPanel() {
    return flowPanel;
  }
  
  public FlowTopPanel getTopPanel() {
    return topPanel;
  }
  
  public JPanel getResignPanel() {
    return resignPanel;
  }
}
