package App.MissionControl;

import App.Node_Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;

public class MissionControl_Controller extends Node_Controller {
    @FXML
    private StackPane contentPane;

    @FXML
    private ImageView image;

    @FXML
    public void initialize(){
        try{
            showDailyMission();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadContent(String fxmlPath) throws Exception {
        Node node = (Node) FXMLLoader.load(getClass().getResource(fxmlPath));
        contentPane.getChildren().setAll(node);
    }

    public void setImage(String imagePath) {
        image.setImage(new Image(getClass().getResourceAsStream(imagePath)));
    }

    public void showDailyMission() throws Exception {
        loadContent("/App/MissionControl/DailyMission/DailyMission.fxml");
        setImage("/App/MissionControl/DailyMission/DailyMission.png");
    }

    public void showProgress() throws Exception {
        loadContent("/App/MissionControl/Progress/Progress.fxml");
        setImage("/App/MissionControl/Progress/Progress.png");
    }

    public void showProject() throws Exception {
        loadContent("/App/MissionControl/Project/Project.fxml");
    }
}
