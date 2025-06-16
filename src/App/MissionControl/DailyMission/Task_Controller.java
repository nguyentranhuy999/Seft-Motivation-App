package App.MissionControl.DailyMission;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Task_Controller {
    private Task task;
    private ObservableList<Task> tasks;

    @FXML
    private Label taskName;

    @FXML
    private Label coin;

    @FXML
    private Label crystal;

    @FXML
    private Button doneButton;

    public void setTaskList(ObservableList<Task> tasks){
        this.tasks = tasks;
    }

    public void setTask(Task task) {
        this.task = task;
        taskName.setText(task.name);
        coin.setText(String.valueOf(task.coin));
        crystal.setText(String.valueOf(task.crystal));
    }

    public void done(){
        task.done = true;
        update();
    }

    public void update() {
        doneButton.setDisable(task.done);
        Task_Saver.saveTasks(tasks);
    }

    public void delete(){
        tasks.remove(task);
        Task_Saver.saveTasks(tasks);
    }
}
