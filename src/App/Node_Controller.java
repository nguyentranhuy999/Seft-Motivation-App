package App;

public abstract class Node_Controller {
    public Root_Controller controller;

    public void setController(Root_Controller controller) {
        this.controller = controller;
    }

    public void exit() throws Exception {
        controller.showMenu();
    }
}
