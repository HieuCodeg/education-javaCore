package md2.nmh.casestudy.services;

import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.statistic.TeacherList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppUtils {
    public static Scanner sc = new Scanner(System.in);
    public static String retryString(String string) {
        String result;
        System.out.printf("%50s %s"," "," ⭆ ");
        while ((result = sc.nextLine()).isEmpty()) {
            System.out.printf("%50s không được để trống\n", string);
            System.out.printf("%50s %s"," "," ⭆ ");
        }
        return result;
    }
    public static int retryChoose(int min, int max) {
        int option;
        do {
            System.out.printf("%50s %s\n"," "," ⭆ ");
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option > max || option < min) {
                    System.out.printf("%40s %s\n"," ","Chọn chức năng không đúng! Vui lòng chọn lại");
                    continue;
                }
                break;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (true);
        return option;
    }
    public static boolean retryUserName(String userName) {
        List<Teacher> teachers = TeacherList.getInstance().findAll();
        for (Teacher teacher:teachers) {
            if (teacher.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public static Teacher retryPassword(String userName, String password) {
        List<Teacher> teachers = TeacherList.getInstance().findAll();
        for (Teacher teacher:teachers) {
            if (teacher.getUsername().equals(userName) && teacher.getPassword().equals(password)) {
                return teacher;
            }
        }
        return null;
    }
    public static void step() {
        System.out.printf("%50s %s"," "," Nhấn phím bất kì để tiếp tục !!!");
        sc.nextLine();
    }

    public static void exit() {
        System.out.printf("%40s %s\n", " ", "\tTạm biệt. Hẹn gặp lại!");
        System.exit(5);
    }
    public static void stepSort() {

        try
        {
            System.out.printf("%40s %s\n"," "," Bắt đầu sắp xếp :");
            Thread.sleep(100);
            System.out.printf("%50s %s\n"," ","    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.printf("%50s"," ");
            char[] loading = "=>>> ██████████████████████████████  100%".toCharArray();
            for (int i = 0; i < loading.length; i++) {
                System.out.print(loading[i]);
                Thread.sleep(50);
            }
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println();
        System.out.printf("%53s %s\n"," "," Sắp xếp xong !!!");
        System.out.printf("%51s\n  %50s\n %89s\n %50s\n",
                "_/﹋\\_",
                "(҂`_´)",
                "<,︻╦╤─ ҉ – –    Nhấn phím bất kì để tiếp tục !!!",
                "_/﹋\\_");
        sc.nextLine();
    }

}
