package md2.nmh.casestudy.manager;

public enum Subject {
    TOAN("Toán học"), LY("Vật lý"), HOA("Hóa học"),
    SINH("Sinh học"), TIN("Tin học"), VAN("Ngữ văn"),
    SU("Lịch sử"), ANH("Anh văn"),DIA("Địa lý");
    private String value;

    private Subject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static Subject parseSubject(int ordinal) {
        Subject[] values = values();
        for (Subject subject : values) {
            if (subject.ordinal() == ordinal) return subject;
        }
        throw new IllegalArgumentException(String.format("Invalid subject ordinal = %s", ordinal));
    }
    public static Subject parseSubject(String value) {
        Subject[] values = values();
        for (Subject subject : values) {
            if (subject.value.equals(value)) return subject;
        }
        throw new IllegalArgumentException(String.format("Invalid subject ordinal = %s", value));
    }
}
