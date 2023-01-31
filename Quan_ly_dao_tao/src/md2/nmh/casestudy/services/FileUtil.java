package md2.nmh.casestudy.services;

import md2.nmh.casestudy.manager.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> read(String path) {
        List<String> linesList = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty())
                linesList.add(line);
        } catch (IOException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
        return linesList;
    }

    public static <T> void write(String path, List<T> items) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            for (T item : items) {
                printWriter.println(item.toString());
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
    }
    public static  void writeScore(String path, List<Student> items) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            for (Student student : items) {
                if (student.getScoreString().length() > 8) {
                    printWriter.println(student.getScoreString());
                }
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
    }
}
