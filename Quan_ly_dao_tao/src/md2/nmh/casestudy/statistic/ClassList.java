package md2.nmh.casestudy.statistic;

import md2.nmh.casestudy.manager.Classed;
import md2.nmh.casestudy.manager.Student;
import md2.nmh.casestudy.services.FileUtil;

import java.util.*;

public class ClassList {
    public final static String PATH = "data/classed.csv";
    private static ClassList instance;

    public static ClassList getInstance() {
        if (instance == null)
            instance = new ClassList();
        return instance;
    }

    public ClassList() {
    }

    public Map<String, Classed> findAll() {
        Map<String, Classed> classes = new TreeMap<>();
        List<String> records = FileUtil.read(PATH);
        for (String record : records) {
            classes.put(Classed.parseInfo(record).getName(), Classed.parseInfo(record));
        }
        List<Student> students = StudentsList.getInstance().findAll();
        for (Student student : students) {
            classes.get(student.getClassed()).add(student);
            classes.get(student.getClassed()).setTotal();
        }
        return classes;
    }

    public void add(Classed newClass) {
        Map<String, Classed> classes = findAll();
        classes.put(newClass.getName(), newClass);
    }

    public void remove(Classed oldClass) {
        Map<String, Classed> classes = new TreeMap<>();
        classes.remove(oldClass);
    }

    public Classed getClassed(String name) {
        Map<String, Classed> classes = new TreeMap<>();
        return classes.get(name);
    }

}
