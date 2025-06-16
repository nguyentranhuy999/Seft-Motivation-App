package App;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Data_Saver {
    private static final String FILE_PATH = "src/App/data.json";
    private static final Gson gson = new Gson();

    public static void saveData(Data data) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Data loadData() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Data.class);
        } catch (IOException e) {
            return new Data(0,0);
        }
    }
}