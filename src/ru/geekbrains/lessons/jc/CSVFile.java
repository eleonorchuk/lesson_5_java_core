package ru.geekbrains.lessons.jc;

import java.io.*;
import java.util.Vector;

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

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(name+".csv"))) {
            String header = reader.readLine();
            String []headerArr = header.split(";");
            data.addHeader(headerArr);
            String str;
            Vector<Integer[]> dataVector=new Vector<>();

            while ((str = reader.readLine()) != null) {
                String []dat = str.split(";");
                Integer [] intData = new Integer[dat.length];
                for (int i = 0; i< dat.length; i++) {
                    intData[i] = Integer.parseInt(dat[i]);
                }
                dataVector.add(intData);
            }
            reader.close();
            int [][] dataArr = new int[dataVector.size()][headerArr.length];
            for (int i = 0; i<dataVector.size();i++)
                for (int j = 0; j<headerArr.length;j++)
                    dataArr[i][j] = dataVector.elementAt(i)[j];

            this.data.addData(dataArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
