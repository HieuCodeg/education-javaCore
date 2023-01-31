package md2.nmh.casestudy.statistic;

import md2.nmh.casestudy.manager.Person;
import md2.nmh.casestudy.manager.Student;


public interface IPersonList {
    void add(Person person);
    boolean existsById(long id);
    boolean existByName(String name);

    void sortByBirthday();
    void sortByName();
    void sortByClass();
}
