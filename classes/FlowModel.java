import java.awt.Color;

public class FlowModel { private Color[][] gameBoard;
  
  public FlowModel() {}
  
  private int numRows = 5;
  private int numCols = 5;
  
  private static final int UP = 0;
  private static final int DOWN = 1;
  private static final int RIGHT = 2;
  private static final int LEFT = 3;
  
  private int[] finalSquaresRow = new int[10];
  private int[] finalSquaresCol = new int[10];
  private Color[] finalSquareColors = { Color.red, Color.red, Color.orange, Color.orange, 
    Color.yellow, Color.yellow, Color.green, Color.green, Color.blue, Color.blue };
  
  public Color[][] getBoard() {
    return gameBoard;
  }
  

  public void setFinalSquares(int[] finalSquares)
  {
    int i = 0; for (int j = 0; j < finalSquares.length; j += 2) {
      finalSquaresRow[i] = finalSquares[j];
      finalSquaresCol[i] = finalSquares[(j + 1)];i++;
    }
  }
  

  public void setBoard()
  {
    gameBoard = new Color[numRows][numCols];
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        gameBoard[r][c] = Color.black;
      }
    }
    for (int i = 0; i < finalSquareColors.length; i++) {
      gameBoard[finalSquaresRow[i]][finalSquaresCol[i]] = finalSquareColors[i];
    }
  }
  
  public boolean isFinalSquare(int row, int col)
  {
    for (int i = 0; i < finalSquareColors.length; i++) {
      if ((finalSquaresRow[i] == row) && (finalSquaresCol[i] == col))
        return true;
    }
    return false;
  }
  


  public boolean checkRight(int r, int c)
  {
    return gameBoard[r][c] == gameBoard[r][(c + 1)];
  }
  
  public boolean checkLeft(int r, int c) {
    return gameBoard[r][c] == gameBoard[r][(c - 1)];
  }
  
  public boolean checkUp(int r, int c) {
    return gameBoard[r][c] == gameBoard[(r - 1)][c];
  }
  
  public boolean checkDown(int r, int c) {
    return gameBoard[r][c] == gameBoard[(r + 1)][c];
  }
  

  public boolean isPathCompleted(int r, int c, int fr, int fc, Color m)
  {
    int direction = -1;
    do {
      direction = directionOfAdjacentSameColor(r, c);
      gameBoard[r][c] = m;
      if (direction == 0) {
        r--;
      } else if (direction == 1) {
        r++;
      } else if (direction == 2) {
        c++;
      } else if (direction == 3)
        c--;
      if ((r == fr) && (c == fc))
        return true;
    } while (direction != -1);
    return false;
  }
  

  public boolean allPathsCompleted()
  {
    if (isPathCompleted(finalSquaresRow[0], finalSquaresCol[0], finalSquaresRow[1], finalSquaresCol[1], Color.pink))
    {
      if (isPathCompleted(finalSquaresRow[2], finalSquaresCol[2], finalSquaresRow[3], finalSquaresCol[3], Color.magenta))
      {
        if (isPathCompleted(finalSquaresRow[4], finalSquaresCol[4], finalSquaresRow[5], finalSquaresCol[5], Color.darkGray))
        {
          if (!isPathCompleted(finalSquaresRow[6], finalSquaresCol[6], finalSquaresRow[7], finalSquaresCol[7], Color.gray)) {}
        }
      }
    }
    boolean isAlreadyColored = 
    






      isPathCompleted(finalSquaresRow[8], finalSquaresCol[8], finalSquaresRow[9], 
      finalSquaresCol[9], Color.cyan);
    
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        if (gameBoard[r][c] == Color.pink)
          gameBoard[r][c] = Color.red;
        if (gameBoard[r][c] == Color.cyan)
          gameBoard[r][c] = Color.blue;
        if (gameBoard[r][c] == Color.gray)
          gameBoard[r][c] = Color.green;
        if (gameBoard[r][c] == Color.magenta)
          gameBoard[r][c] = Color.orange;
        if (gameBoard[r][c] == Color.darkGray)
          gameBoard[r][c] = Color.yellow;
      }
    }
    return isAlreadyColored;
  }
  

  public Boolean setColor(int rowNum, int colNum, Color color)
  {
    if ((colNum >= 0) && (colNum < numCols) && (rowNum >= 0) && (rowNum < numRows) && 
      (color != Color.black) && (gameBoard[rowNum][colNum] != color) && 
      (!isFinalSquare(rowNum, colNum))) {
      gameBoard[rowNum][colNum] = color;
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public Color getColor(int rowNum, int colNum)
  {
    if ((colNum >= 0) && (colNum < numCols) && (rowNum >= 0) && (rowNum < numRows)) {
      return gameBoard[rowNum][colNum];
    }
    return Color.black;
  }
  
  public int[] getFinalSquaresRow()
  {
    return finalSquaresRow;
  }
  
  public int[] getFinalSquaresCol()
  {
    return finalSquaresCol;
  }
  
  public int directionOfAdjacentSameColor(int r, int c)
  {
    if ((r == 0) && (c == 0)) {
      if (checkRight(r, c))
        return 2;
      if (checkDown(r, c))
        return 1;
    } else if ((r == 0) && (c == 4)) {
      if (checkLeft(r, c))
        return 3;
      if (checkDown(r, c))
        return 1;
    } else if ((r == 4) && (c == 0)) {
      if (checkRight(r, c))
        return 2;
      if (checkUp(r, c))
        return 0;
    } else if ((r == 4) && (c == 4)) {
      if (checkLeft(r, c))
        return 3;
      if (checkUp(r, c))
        return 0;
    } else if (r == 0) {
      if (checkDown(r, c))
        return 1;
      if (checkRight(r, c))
        return 2;
      if (checkLeft(r, c))
        return 3;
    } else if (c == 0) {
      if (checkRight(r, c))
        return 2;
      if (checkUp(r, c))
        return 0;
      if (checkDown(r, c))
        return 1;
    } else if (c == 4) {
      if (checkLeft(r, c))
        return 3;
      if (checkUp(r, c))
        return 0;
      if (checkDown(r, c))
        return 1;
    } else if (r == 4) {
      if (checkUp(r, c))
        return 0;
      if (checkRight(r, c))
        return 2;
      if (checkLeft(r, c))
        return 3;
    } else {
      if (checkUp(r, c))
        return 0;
      if (checkDown(r, c))
        return 1;
      if (checkRight(r, c))
        return 2;
      if (checkLeft(r, c))
        return 3;
    }
    return -1;
  }
  
  public void chooseAndSetBoard() {
    FlowGameBoards.chooseAndSetFinalSquares(this);
    setBoard();
  }
}
