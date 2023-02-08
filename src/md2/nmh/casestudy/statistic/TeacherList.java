package md2.nmh.casestudy.statistic;

import md2.nmh.casestudy.manager.Person;
import md2.nmh.casestudy.manager.Student;
import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.services.AppUtils;
import md2.nmh.casestudy.services.FileUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeacherList implements IPersonList{
    public final static String PATH = "data/teacher.csv";
    private static TeacherList instance;
    public static TeacherList getInstance() {
        if (instance == null)
            instance = new TeacherList();
        return instance;
    }
    public List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<>();
        List<String> tampList = FileUtil.read(PATH);
        for (String line: tampList) {
            teachers.add(Teacher.parseInfo(line));
        }
        return teachers;
    }
    public Teacher getById(long id) {
        List<Teacher> teachers = findAll();
        for (Teacher teacher: teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
    public void add(Person newTeacher) {
        List<Teacher> teachers = findAll();
        teachers.add((Teacher) newTeacher);
        FileUtil.write(PATH,teachers);
    }
    public boolean existsById(long id) {
        List<Teacher> teachers = findAll();
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean existByName(String name) {
        List<Teacher> teachers = findAll();
        for (Teacher teacher : teachers) {
            if (teacher.getName().toUpperCase().contains(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
    public void remove(Teacher teacher) {
        List<Teacher> teachers = findAll();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == teacher.getId()) {
                teachers.remove(i);
                break;
            }
        }
        FileUtil.write(PATH,teachers);
    }
    @Override
    public void sortByBirthday() {
        List<Teacher> teachers = findAll();
        teachers.sort(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        FileUtil.write(PATH,teachers);
        AppUtils.stepSort();
    }
    @Override
    public void sortByName() {
        List<Teacher> teachers = findAll();
        teachers.sort(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        FileUtil.write(PATH,teachers);
        AppUtils.stepSort();
    }
    @Override
    public void sortByClass() {
        List<Teacher> teachers = findAll();
        teachers.sort(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getClassed().compareTo(o2.getClassed());
            }
        });
        FileUtil.write(PATH,teachers);
        AppUtils.stepSort();
    }


}
