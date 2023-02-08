package md2.nmh.casestudy.manager;

public enum Role {
    ADMIN("ADMIN"),USER("USER");
    private String value;

    Role(String value) {
        this.value = value;
    }
    public static Role parseRole(String value) {
        Role[] values = values();
        for (Role role: values) {
            if (role.value.equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid role value = %s", value));
    }
//    public static Role parseRole(int ordinal) {
//        Role[] values = values();
//        for (Role role: values) {
//            if (role.ordinal() == ordinal) {
//                return role;
//            }
//        }
//        throw new IllegalArgumentException(String.format("Invalid role ordinal = %s", ordinal));
//    }
}
