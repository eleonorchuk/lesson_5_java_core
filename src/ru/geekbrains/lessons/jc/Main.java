package ru.geekbrains.lessons.jc;

public class Main {

    public static void main(String[] args) {
	// write your code here
    /*    Пример:
        Value 1;Value 2;Value 3
        100;200;123
        300,400,500
     */
        String []header = new String[]{"Value 1", "Value 2","Value 3"};
        int [][]data = new int[][]{{100,200,123},{300,400,500}};

        CSVFile testCsvFile = new CSVFile("test file");
        testCsvFile.addHeader(header);
        testCsvFile.addData(data);

        testCsvFile.save();
    }
}
