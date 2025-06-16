package App.MissionControl.DailyMission;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class DailyMission_Controller{
    @FXML
    private ListView<Task> listView;

    private ObservableList<Task> tasks;

    @FXML
    public void initialize() {
        List<Task> loadedTasks = Task_Saver.loadTasks();
        if (loadedTasks == null) {
            loadedTasks = new ArrayList<>();
        }

        this.tasks = FXCollections.observableArrayList(loadedTasks);

        listView.setItems(this.tasks);
        listView.setCellFactory(param -> new TaskCellFactory());
    }

    public void newTask(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/App/MissionControl/DailyMission/NewTask.fxml"));
            Parent root = fxmlLoader.load();
            Stage newTaskStage = new Stage();
            newTaskStage.setResizable(false);
            newTaskStage.initModality(Modality.APPLICATION_MODAL);
            newTaskStage.setScene(new Scene(root));
            newTaskStage.showAndWait();

            NewTask_Controller newTaskController = fxmlLoader.getController();
            if (newTaskController.name == null || newTaskController.name.isEmpty()) {
                return;
            }
            tasks.add(new Task(newTaskController.name, 0,0, false, false));
            Task_Saver.saveTasks(tasks);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
