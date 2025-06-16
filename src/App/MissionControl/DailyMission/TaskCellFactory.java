package App.MissionControl.DailyMission;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

public class TaskCellFactory extends ListCell<Task> {
    private AnchorPane taskPane;
    private Task_Controller controller;

    public TaskCellFactory(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/App/MissionControl/DailyMission/Task.fxml"));
            taskPane = loader.load();
            controller = loader.getController();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        setStyle("-fx-background-color: transparent;");
        setOnMousePressed(e -> getListView().getSelectionModel().clearSelection());
    }

    @Override
    protected void updateItem(Task task, boolean empty) {
        super.updateItem(task, empty);
        if (empty || task == null) {
            setGraphic(null);
        } else {
            try {
                controller.setTask(task);
                controller.setTaskList(getListView().getItems());
                controller.update();
                setGraphic(taskPane);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
