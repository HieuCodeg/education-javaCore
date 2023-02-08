package md2.nmh.casestudy.services;

import java.util.regex.Pattern;

public class Validex {
    public static final String NAME_REGEX = "^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ]{1}[a-záàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵ]+[ ]?)+$";
    public static final String BIRTHDAY_REGEX = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8}$";
    public static final String USERNAME_REGEX = "^\\S{6,}$";

    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_])(?=\\S+$).{6,}$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9.]*[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String CLASSED_REGEX = "^10[A|B|C|D|E|G|H|K]|11[A|B|C|D|E|G|H|K]|12[A|B|C|D|E|G|H|K]$";
    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }
    public static boolean isBirthdayValid(String birthday) {
        return Pattern.compile(BIRTHDAY_REGEX).matcher(birthday).matches();
    }
    public static boolean isPhoneValid(String birthday) {
        return Pattern.compile(PHONE_REGEX).matcher(birthday).matches();
    }
    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
    public static boolean isClassValid(String classed) {
        return Pattern.compile(CLASSED_REGEX).matcher(classed).matches();
    }
    public static boolean isUsernameValid(String password) {
        return Pattern.compile(USERNAME_REGEX).matcher(password).matches();
    }

    public static boolean isPasswordValid(String password) {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }
}
