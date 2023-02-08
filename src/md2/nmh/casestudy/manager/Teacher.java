package md2.nmh.casestudy.manager;

public class Teacher extends Person {
    private long id;
    private Subject subject;
    private String username;
    private String password;
    private Role role;

    public Teacher(long id, String name, Gender gender, String birthday, String classed, String subject, String username, String password, String role) {
        super(name, gender, birthday, classed);
        this.id = id;
        this.subject = Subject.parseSubject(subject);
        this.username = username;
        this.password = password;
        this.role = Role.parseRole(role);
    }

    public Teacher() {
        this.id = System.currentTimeMillis() - 1663165000000l;
    }

    public static Teacher parseInfo(String line) {
        Teacher teacher = new Teacher();
        String[] informationsList = line.split(",");
        teacher.setId(Long.parseLong(informationsList[0]));
        teacher.setName(informationsList[1]);
        teacher.setGender(informationsList[2].equals("Nam") ? Gender.Nam : Gender.Nữ);
        teacher.setBirthday(informationsList[3]);
        teacher.setClassed(informationsList[4]);
        teacher.setSubject(Subject.parseSubject(informationsList[5]));
        teacher.setUsername(informationsList[6]);
        teacher.setPassword(informationsList[7]);
        teacher.setRole(Role.parseRole(informationsList[8]));
        return teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSubject() {
        return subject.getValue();
    }

    public void setSubject(String subject) {
        this.subject = Subject.parseSubject(subject);
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s",
                id,
                super.getName(),
                super.getGender(),
                super.getBirthdayString(),
                super.getClassed(),
                subject.getValue(),
                username,
                password,
                role.toString()

        );
    }


}
