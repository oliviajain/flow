

public class FlowMain
{
  public FlowMain() {}
  
  public static void main(String[] args)
  {
    FlowModel model = new FlowModel();
    FlowView view = new FlowView();
    FlowController controller = new FlowController(model, view);
    controller.newBoard();
    view.setDefaultCloseOperation(3);
    view.setSize(635, 690);
    view.setLocation(0, 0);
    view.setResizable(false);
    view.setVisible(true);
  }
}
