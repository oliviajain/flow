import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FlowTopPanel
  extends JPanel
{
  private JPanel startGamePanel;
  private JPanel flowLabelPanel;
  private JLabel welcomeLabel;
  private JLabel flowLabel;
  private JLabel startGame;
  private JLabel instructions;
  private JLabel instructions1;
  private JLabel instructions2;
  private int flowGap;
  private int topPanelGap;
  
  public FlowTopPanel()
  {
    setLayout(null);
    setBounds(0, 30, 635, 635);
    setBackground(new Color(0, 0, 0, 60));
    

    welcomeLabel = new JLabel("Welcome To");
    welcomeLabel.setFont(new Font("SansSerif", 1, 70));
    welcomeLabel.setForeground(Color.white);
    
    JPanel northPanel = new JPanel();
    northPanel.setOpaque(false);
    
    int topPanelGap = 30;
    int welcomeGap = topPanelGap + 20;
    int welcomeStartLocation = (int)((getWidth() - welcomeLabel.getPreferredSize()
      .getWidth()) / 2.0D);
    northPanel.setBounds(welcomeStartLocation, welcomeGap, 
      (int)welcomeLabel.getPreferredSize().getWidth(), 
      (int)welcomeLabel.getPreferredSize().getHeight());
    
    northPanel.add(welcomeLabel);
    

    flowLabel = new JLabel("FLOW");
    flowLabel.setFont(new Font("SansSerif", 1, 160));
    flowLabel.setForeground(Color.cyan);
    
    flowLabelPanel = new JPanel();
    flowLabelPanel.setOpaque(false);
    
    flowGap = ((int)(welcomeLabel.getPreferredSize().getHeight() + 20.0D));
    resetFlowLabel();
    flowLabelPanel.add(flowLabel);
    

    instructions = new JLabel("Instructions: Create paths between same-colored tiles.");
    instructions1 = new JLabel("Each board is complete if all paths are completed without overlap.");
    instructions2 = new JLabel("You have one minute. Complete as many boards as you can.");
    instructions.setFont(new Font("SansSerif", 1, 17));
    instructions1.setFont(new Font("SansSerif", 1, 17));
    instructions2.setFont(new Font("SansSerif", 1, 17));
    
    instructions.setForeground(Color.white);
    instructions1.setForeground(Color.white);
    instructions2.setForeground(Color.white);
    

    JPanel instructionsPanel = new JPanel();
    instructionsPanel.setOpaque(false);
    
    int instructionsGap = (int)(topPanelGap + welcomeLabel.getPreferredSize().getHeight() + 
      flowLabel.getPreferredSize().getHeight());
    int instructionsStartLocation = (int)((getWidth() - instructions1.getPreferredSize()
      .getWidth()) / 2.0D);
    instructionsPanel.setBounds(instructionsStartLocation, 20 + instructionsGap, 
      (int)instructions1.getPreferredSize().getWidth(), 
      (int)instructions.getPreferredSize().getHeight() * 4);
    
    instructionsPanel.add(instructions);
    instructionsPanel.add(instructions1);
    instructionsPanel.add(instructions2);
    

    startGame = new JLabel("Start Game");
    startGame.setFont(new Font("SansSerif", 1, 65));
    startGame.setForeground(Color.black);
    
    startGamePanel = new JPanel();
    
    int extraWidth = 100;
    int extraHeight = 20;
    int startGap = (int)(getHeight() - getHeight() / 5 - startGame
      .getPreferredSize().getHeight() / 2.0D * 2.75D + topPanelGap + 20.0D);
    int startGameLocation = (int)((getWidth() - startGame.getPreferredSize().getWidth()) / 2.0D);
    
    startGamePanel.setBounds(startGameLocation - extraWidth, startGap, 
      (int)startGame.getPreferredSize().getWidth() + extraWidth * 2, 
      (int)startGame.getPreferredSize().getHeight() + extraHeight);
    
    startGamePanel.add(startGame);
    

    add(northPanel);
    add(flowLabelPanel);
    add(instructionsPanel);
    add(startGamePanel);
  }
  

  public void resetFlowLabel()
  {
    int flowStartLocation = (int)((getWidth() - flowLabel.getPreferredSize().getWidth()) / 2.0D);
    flowLabelPanel.setBounds(flowStartLocation, flowGap, 
      (int)flowLabel.getPreferredSize().getWidth(), (int)flowLabel.getPreferredSize().getHeight());
  }
  
  public void gameOver(int score)
  {
    welcomeLabel.setText("Game Over");
    
    flowLabel.setText("SCORE: " + score);
    flowLabel.setFont(new Font("SansSerif", 1, 90));
    flowGap = ((int)(welcomeLabel.getPreferredSize().getHeight() + 50.0D + topPanelGap));
    resetFlowLabel();
    
    startGame.setText("New Game");
  }
  
  public JPanel getStartGamePanel() {
    return startGamePanel;
  }
}
