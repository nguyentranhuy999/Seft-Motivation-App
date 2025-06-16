package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Root_Controller {
    @FXML
    private StackPane content;

    @FXML
    private AnchorPane detail;

    @FXML
    private Label coin;

    @FXML
    private Label crystal;

    @FXML
    public void initialize() {
        try {
            showMenu();
            update();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadContent(String fxmlPath) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent pane = loader.load();
        Node_Controller controller = (Node_Controller) loader.getController();
        controller.setController(this);
        content.getChildren().setAll(pane);
    }

    public void showMenu() throws Exception {
        loadContent("/App/Menu/Menu.fxml");
    }

    public void showBank() throws Exception {
        loadContent("/App/Bank/Bank.fxml");
    }

    public void showStore() throws Exception {
        loadContent("/App/Store/Store.fxml");
    }

    public void showTradeFloor() throws Exception {
        loadContent("/App/TradeFloor/TradeFloor.fxml");
    }

    public void showMissionControl() throws Exception {
        loadContent("/App/MissionControl/MissionControl.fxml");
    }

    public void showLuckyZone() throws Exception {
        loadContent(("/App/LuckyZone/LuckyZone.fxml"));
    }

    public void update(){
        Data data = Data_Saver.loadData();
        coin.setText(String.valueOf(data.coin));
        crystal.setText(String.valueOf(data.crystal));
        Data_Saver.saveData(data);
    }
}
