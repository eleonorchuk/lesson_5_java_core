package ru.geekbrains.lessons.jc;

public class AppDate {
    private String[] header;
    private int[][] data;

    public String getData() {
        String result = new String();
        for(int i = 0; i < header.length; i++) {
            result += header[i];
            if ( i != (header.length - 1) )
                result += ";";
        }
        result += "\n";

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                result += data[i][j];
                if ( j != (data[i].length - 1) )
                    result += ";";
            }
            result += "\n";
        }
        return result;
    }

    public void addHeader(String [] header) {
        this.header = header;
    }
    public void addData(int [][] data) {
        this.data = data;
    }
}
