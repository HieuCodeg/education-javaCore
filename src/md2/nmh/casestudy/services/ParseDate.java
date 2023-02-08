package md2.nmh.casestudy.services;

import java.time.LocalDate;

public class ParseDate {
    public static LocalDate parseLocalDate(String str) {
        String[] list = str.split("/");
        LocalDate date;
        date = LocalDate.of(Integer.parseInt(list[2]),Integer.parseInt(list[1]),Integer.parseInt(list[0]));
        return date;
    }
}
