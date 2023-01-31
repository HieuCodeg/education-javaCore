package md2.nmh.casestudy.manager;

public class Student extends Person {
    private long id;
    private String email;
    private String phoneNumber;
    private ScoreStudent score = new ScoreStudent();

    public Student() {
        this.id = System.currentTimeMillis() - 1663165000000l;
    }

    public Student(String name, Gender gender, String birthday, String classed, long id, String email, String phoneNumber, ScoreStudent score) {
        super(name, gender, birthday, classed);
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.score = score;
    }

    public static Student parseInfo(String line) {
        Student student = new Student();
        String[] informationsList = line.split(",");
        student.setId(Long.parseLong(informationsList[0]));
        student.setName(informationsList[1]);
        student.setGender(informationsList[2].equals("Nam") ? Gender.Nam : Gender.Nữ);
        student.setBirthday(informationsList[3]);
        student.setPhoneNumber(informationsList[4]);
        student.setEmail(informationsList[5]);
        student.setClassed(informationsList[6]);
        return student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ScoreStudent getScoreStudent() {
        return score;
    }

    public void setScore(ScoreStudent score) {
        this.score = score;
    }
    public String getScoreString() {
        String result = String.valueOf(getId());
        result += getScoreStudent().toString();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s",
                id,
                super.getName(),
                super.getGender(),
                super.getBirthdayString(),
                phoneNumber,
                email,
                super.getClassed()
        );
    }
}
