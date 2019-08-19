import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



public class FlowPanel
  extends JPanel
{
  private final int sideOfSquare = 125;
  private final int initialGap = 2;
  private final int middleGaps = 127;
  private final int numRows = 5;
  private final int numCols = 5;
  private Color[][] gameBoard = new Color[5][5];
  private int[] finalSquareRowNumbers = new int[10];
  private int[] finalSquareColNumbers = new int[10];
  
  public FlowPanel() {}
  
  public void paintComponent(Graphics g) { for (int r = 0; r < 5; r++) {
      for (int c = 0; c < 5; c++) {
        g.setColor(gameBoard[r][c]);
        g.fillRect(2 + c * 127, 2 + r * 127, 125, 
          125);
        for (int i = 0; i < finalSquareRowNumbers.length; i++) {
          if ((r == finalSquareRowNumbers[i]) && (c == finalSquareColNumbers[i])) {
            g.setColor(Color.black);
            g.drawRect(2 + c * 127 + 5, 
              2 + r * 127 + 5, 115, 
              115);
          }
        }
      }
    }
  }
  
  public void updateGameSquare(int rowNum, int colNum, Color color)
  {
    gameBoard[rowNum][colNum] = color;
  }
  
  public int getCol(int x) {
    return (x - 2) / 125;
  }
  
  public int getRow(int y) {
    return (y - 2) / 125;
  }
  
  public void setFinalSquareRow(int[] finalSquaresRow) {
    for (int r = 0; r < finalSquaresRow.length; r++) {
      finalSquareRowNumbers[r] = finalSquaresRow[r];
    }
  }
  
  public void setFinalSquareCol(int[] finalSquaresCol) {
    for (int c = 0; c < finalSquaresCol.length; c++) {
      finalSquareColNumbers[c] = finalSquaresCol[c];
    }
  }
  
  public void setGameBoard(Color[][] board) {
    for (int r = 0; r < 5; r++) {
      for (int c = 0; c < 5; c++) {
        gameBoard[r][c] = board[r][c];
      }
    }
  }
}
