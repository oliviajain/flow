public class FlowGameBoards {
  public FlowGameBoards() {}
  
  public static void chooseAndSetFinalSquares(FlowModel model) {
    int newBoard = (int)(Math.random() * 19.0D + 1.0D);
    














    switch (newBoard) {
    case 1: 
      model.setFinalSquares(new int[] { 3, 2, 3, 4, 3, 1, 2, 2, 2, 3, 1, 0, 1, 1, 1, 3, 2, 
        0, 4, 4 });
    case 2: 
      model.setFinalSquares(new int[] { 2, 0, 4, 0, 0, 1, 1, 4, 4, 2, 2, 4, 1, 2, 4, 1, 
        0, 0, 2, 2 });
      break;
    case 3: 
      model.setFinalSquares(new int[] { 0, 2, 1, 4, 2, 4, 4, 4, 0, 1, 4, 1, 4, 0, 2, 2, 
        0, 0, 2, 1 });
      break;
    case 4: 
      model.setFinalSquares(new int[] { 2, 1, 1, 3, 1, 0, 0, 1, 4, 0, 2, 3, 0, 2, 4, 4, 2, 
        0, 2, 2 });
      break;
    case 5: 
      model.setFinalSquares(new int[] { 0, 3, 4, 3, 4, 0, 3, 1, 1, 1, 2, 2, 4, 2, 1, 3, 1, 2, 
        3 });
      break;
    case 6: 
      model.setFinalSquares(new int[] { 3, 1, 3, 3, 0, 3, 1, 4, 2, 4, 2, 0, 1, 0, 2, 2, 
        0, 0, 2, 3 });
      break;
    case 7: 
      model.setFinalSquares(new int[] { 0, 3, 3, 4, 0, 0, 3, 0, 4, 0, 4, 4, 2, 3, 0, 4, 3, 1, 
        0, 2 });
      break;
    case 8: 
      model.setFinalSquares(new int[] { 0, 3, 2, 0, 3, 0, 4, 2, 1, 1, 4, 4, 1, 3, 0, 4, 1, 2, 
        3, 4 });
      break;
    case 9: 
      model.setFinalSquares(new int[] { 1, 0, 0, 3, 2, 2, 3, 4, 4, 2, 4, 4, 4, 0, 0, 4, 4, 1, 
        3, 3 });
      break;
    case 10: 
      model.setFinalSquares(new int[] { 4, 0, 3, 2, 0, 4, 3, 4, 0, 0, 0, 3, 3, 1, 2, 2, 3, 
        0, 4, 4 });
      break;
    case 11: 
      model.setFinalSquares(new int[] { 1, 1, 1, 3, 1, 0, 2, 3, 4, 0, 4, 4, 0, 0, 2, 4, 3, 
        0, 3, 4 });
      break;
    case 12: 
      model.setFinalSquares(new int[] { 1, 1, 1, 3, 1, 0, 1, 4, 2, 0, 4, 0, 4, 1, 3, 3, 3, 1, 
        4, 3 });
      break;
    case 13: 
      model.setFinalSquares(new int[] { 0, 1, 0, 4, 3, 0, 2, 3, 4, 2, 3, 4, 0, 0, 2, 4, 4, 
        0, 3, 3 });
      break;
    case 14: 
      model.setFinalSquares(new int[] { 0, 1, 2, 0, 1, 1, 3, 2, 4, 0, 2, 1, 4, 1, 4, 4, 2, 2, 
        1, 3 });
      break;
    case 15: 
      model.setFinalSquares(new int[] { 0, 0, 0, 3, 4, 3, 3, 4, 2, 4, 0, 4, 1, 2, 3, 1, 1, 1, 
        1, 3 });
      break;
    case 16: 
      model.setFinalSquares(new int[] { 3, 3, 4, 4, 4, 1, 2, 3, 4, 0, 0, 3, 0, 2, 2, 0, 0, 4, 
        3, 4 });
      break;
    case 17: 
      model.setFinalSquares(new int[] { 2, 0, 4, 3, 2, 2, 0, 4, 0, 1, 0, 3, 0, 0, 3, 3, 2, 3, 
        4, 4 });
      break;
    case 18: 
      model.setFinalSquares(new int[] { 0, 3, 3, 1, 0, 4, 3, 2, 1, 3, 2, 2, 3, 4, 4, 2, 
        0, 0, 4, 1 });
      break;
    case 19: 
      model.setFinalSquares(new int[] { 1, 3, 2, 2, 3, 3, 4, 2, 3, 0, 0, 1, 0, 3, 4, 3, 0, 2, 
        4 });
      break;
    case 20: 
      model.setFinalSquares(new int[] { 0, 0, 4, 1, 1, 4, 4, 3, 0, 4, 3, 3, 0, 2, 3, 1, 1, 2, 
        4, 2 });
      break;
    default: 
      model.setFinalSquares(new int[] { 0, 3, 2, 0, 3, 4, 3, 0, 3, 3, 4, 4, 0, 4, 1, 3, 1, 2, 
        3, 1 });
    }
  }
}
