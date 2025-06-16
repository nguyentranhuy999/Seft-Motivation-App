package App.Menu;

import App.Node_Controller;
import javafx.fxml.FXML;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;

public class Menu_Controller extends Node_Controller {
    @FXML
    private ImageView missionControl;
    @FXML
    private ImageView tradeFloor;
    @FXML
    private ImageView bank;
    @FXML
    private ImageView store;
    @FXML
    private ImageView luckyZone;

    @FXML
    public void initialize() {
        // Tạo hiệu ứng làm tối
        ColorAdjust darken = new ColorAdjust();
        darken.setBrightness(0.2); // Làm tối 50%

        missionControl.setOnMouseEntered(e -> missionControl.setEffect(darken));
        missionControl.setOnMouseExited(e -> missionControl.setEffect(null));

        tradeFloor.setOnMouseEntered(e -> tradeFloor.setEffect(darken));
        tradeFloor.setOnMouseExited(e -> tradeFloor.setEffect(null));

        bank.setOnMouseEntered(e -> bank.setEffect(darken));
        bank.setOnMouseExited(e -> bank.setEffect(null));

        store.setOnMouseEntered(e -> store.setEffect(darken));
        store.setOnMouseExited(e -> store.setEffect(null));

        luckyZone.setOnMouseEntered(e -> luckyZone.setEffect(darken));
        luckyZone.setOnMouseExited(e -> luckyZone.setEffect(null));
    }


    public void missionControl() throws Exception {
        controller.showMissionControl();
    }

    public void tradeFloor() throws Exception {
        controller.showTradeFloor();
    }

    public void bank() throws Exception {
        controller.showBank();
    }

    public void store() throws Exception {
        controller.showStore();
    }

    public void luckyZone() throws Exception {
        controller.showLuckyZone();
    }
}
