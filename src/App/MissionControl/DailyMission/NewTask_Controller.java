package App.MissionControl.DailyMission;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

public class NewTask_Controller {
    @FXML
    private TextField taskName;

    @FXML
    public void initialize() {
        taskName.setTextFormatter(new TextFormatter<>(change -> {
            if(change.getControlNewText().length() <= 92){
                return change;
            }
            else {
                return null;
            }
        }));
    }

    public String name;

    public void create(){
        name = taskName.getText();
        ((Stage) taskName.getScene().getWindow()).close();
    }
}
