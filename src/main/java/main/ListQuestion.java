package main;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListQuestion {
    private final List<Question> lquestions;

    private static ListQuestion instance;
    private ListQuestion() {
        this.lquestions = new ArrayList<>();

    }
    public static ListQuestion getInstance(){
        if (instance == null){
            File jsfile = new File("Qjson.json");
            try (FileReader rader = new FileReader(jsfile)){
                 instance = new Gson().fromJson(rader, ListQuestion.class);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public List<Question> getLquestions() {
        return lquestions;
    }
}
