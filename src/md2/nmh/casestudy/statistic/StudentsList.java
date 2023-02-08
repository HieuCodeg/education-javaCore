package md2.nmh.casestudy.statistic;

import md2.nmh.casestudy.manager.Person;
import md2.nmh.casestudy.manager.Student;
import md2.nmh.casestudy.services.AppUtils;
import md2.nmh.casestudy.services.FileUtil;
import md2.nmh.casestudy.services.ScoreUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsList implements IPersonList{
    public final static String PATH = "data/student.csv";
    private static StudentsList instance;
    public static StudentsList getInstance() {
        if (instance == null)
            instance = new StudentsList();
        return instance;
    }

    public StudentsList() {
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        List<String> lineList = FileUtil.read(PATH);
        for (String line: lineList) {
            students.add(Student.parseInfo(line));
        }
        ScoreUtil.read(students);
        return students;
    }

    public void add(Person newStudent) {
        List<Student> students = findAll();
        students.add((Student) newStudent);
        FileUtil.write(PATH,students);
    }

    public boolean existsById(long id) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getId() == id)
                return true;
        }
        return false;
    }
    public boolean existByName(String name) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getName().toUpperCase().contains(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void remove(Student student) {
        List<Student> students = findAll();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.remove(i);
                break;
            }
        }
//        students.remove(student);
        FileUtil.write(PATH,students);
        FileUtil.writeScore("data/score.csv",students);
    }

    public Student getById(long id) {
        List<Student> students = findAll();
        for (Student student: students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public void sortByName() {
        List<Student> students = findAll();
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        FileUtil.write(PATH,students);
        AppUtils.stepSort();
    }
    public void sortByBirthday() {
        List<Student> students = findAll();
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getBirthday().compareTo(o1.getBirthday());
            }
        });
        FileUtil.write(PATH,students);
        AppUtils.stepSort();
    }
    public void sortByClass() {
        List<Student> students = findAll();
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getClassed().compareTo(o2.getClassed());
            }
        });
        FileUtil.write(PATH,students);
        AppUtils.stepSort();
    }
}
