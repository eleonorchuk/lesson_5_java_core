package ru.geekbrains.lessons.jc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFile {
    private String name;
    private AppDate data;

    public CSVFile(String name) {
        this.name = name;
        data = new AppDate();
    }

    public void addHeader(String [] header) {
        data.addHeader(header);
    }

    public void addData(int [][] data) {
        this.data.addData(data);
    }

    public AppDate getData() {
        return data;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name+".csv"))) {
            writer.write(data.getData());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
