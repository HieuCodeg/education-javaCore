package md2.nmh.casestudy.manager;

import md2.nmh.casestudy.services.ParseDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private String name;
    private Gender gender;
    private LocalDate birthday;


    private String classed;

    public Person( String name, Gender gender, String birthday, String classed) {
        this.name = name;
        this.gender = gender;
        setBirthday(birthday);
        this.classed = classed;
    }

    public Person() {
    }

    public String getBirthdayString() {
        return birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public String getLastName() {
        String s = this.name.trim();
        if (s.indexOf(" ") >=0) {
            int index = s.lastIndexOf(" ");
            return s.substring(index + 1);
        } else {
            return s;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = ParseDate.parseLocalDate(birthday);
    }

    public String getClassed() {
        return classed;
    }

    public void setClassed(String classed) {
        this.classed = classed;
    }
}
