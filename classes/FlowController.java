import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlowController implements java.awt.event.MouseListener, MouseMotionListener, ActionListener
{
  private FlowModel model;
  private FlowView view;
  private Color color;
  private Timer timer;
  private boolean gameInProgress;
  private int timerCount;
  private int score;
  
  public FlowController(FlowModel model, FlowView view)
  {
    this.model = model;
    this.view = view;
    color = Color.black;
    timer = new Timer(1000, this);
    prepareForNewGame();
  }
  
  public void newBoard() {
    model.chooseAndSetBoard();
    view.getFlowPanel().setGameBoard(model.getBoard());
    view.getFlowPanel().setFinalSquareRow(model.getFinalSquaresRow());
    view.getFlowPanel().setFinalSquareCol(model.getFinalSquaresCol());
    view.getFlowPanel().repaint();
  }
  
  private void prepareForNewGame() {
    timerCount = 60;
    gameInProgress = false;
    view.getTopPanel().getStartGamePanel().addMouseListener(this);
    view.getResignPanel().removeMouseListener(this);
    view.getFlowPanel().removeMouseListener(this);
    view.getFlowPanel().removeMouseMotionListener(this);
    view.getTopPanel().setVisible(true);
    view.hideLabels();
  }
  
  public void startGame() {
    newBoard();
    gameInProgress = true;
    score = 0;
    timer.restart();
    
    view.getTopPanel().setVisible(false);
    view.showLabels();
    view.setScoreLabel(score);
    
    view.getResignPanel().addMouseListener(this);
    view.getFlowPanel().addMouseListener(this);
    view.getFlowPanel().addMouseMotionListener(this);
  }
  
  public void resignGame() {
    timerCount = 0;
    view.getTopPanel().gameOver(score);
    timer.stop();
    prepareForNewGame();
    view.setTimerLabel(timerCount);
    view.repaintTimerLabel();
  }
  
  private void processClick(MouseEvent evt) {
    if (!gameInProgress) {
      startGame();
    }
    else if (evt.getSource() == view.getResignPanel()) {
      resignGame();
    }
    else {
      int rowNum = view.getFlowPanel().getRow(evt.getY());
      int colNum = view.getFlowPanel().getCol(evt.getX());
      color = model.getColor(rowNum, colNum);
    }
  }
  
  public void mouseDragged(MouseEvent evt)
  {
    int r = view.getFlowPanel().getRow(evt.getY());
    int c = view.getFlowPanel().getCol(evt.getX());
    if (model.setColor(r, c, color).booleanValue()) {
      view.getFlowPanel().updateGameSquare(r, c, color);
      view.getFlowPanel().repaint();
    }
  }
  
  public void mouseReleased(MouseEvent evt) {
    if ((gameInProgress) && (model.allPathsCompleted())) {
      score += 1;
      view.setScoreLabel(score);
      view.repaintScoreLabel();
      newBoard();
    }
  }
  
  public void mouseClicked(MouseEvent evt)
  {
    processClick(evt);
  }
  
  public void mousePressed(MouseEvent evt)
  {
    processClick(evt);
  }

  public void mouseEntered(MouseEvent arg0) {}
  
  public void mouseExited(MouseEvent arg0) {}

  public void mouseMoved(MouseEvent arg0) {}

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == timer) {
      timerCount -= 1;
      if (timerCount == 0) {
        view.getTopPanel().gameOver(score);
        timer.stop();
        prepareForNewGame();
      }
      view.setTimerLabel(timerCount);
      view.repaintTimerLabel();
    }
  }
}
