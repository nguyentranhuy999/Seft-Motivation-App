package App.MissionControl.DailyMission;

public class Task {

    public String name;
    public int coin;
    public int crystal;
    public boolean done;
    public boolean newButton = false;

    public Task(String name, int coin, int crystal, boolean done, boolean newButton) {
        this.name = name;
        this.coin = coin;
        this.crystal = crystal;
        this.done = done;
        this.newButton = newButton;
    }
}
