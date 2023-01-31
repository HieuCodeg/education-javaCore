package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.services.AppUtils;

import java.util.Scanner;

public class MainMenu {
    public static Teacher teacherLogin = null;

    public static void launch() {
        LoginView loginView = new LoginView();
        teacherLogin = loginView.login();
        menuOption(teacherLogin);
    }

    public static void menuOption(Teacher teacherLogin) {
        Scanner sc = new Scanner(System.in);
        int choosen = -1;
        do {
            Menu.showMenuManager();
            try {
                do {
                    System.out.printf("%40s %s"," "," CHỌN ︻╦╤─ ҉:  ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 4 || choosen < 1)
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 4 || choosen < 1);
                switch (choosen) {
                    case 1:
                        StudentMenu.launch(teacherLogin);
                        break;
                    case 2:
                        TeacherMenu.launch(teacherLogin);
                        break;
                    case 3:
                        ClassMenu.launch(teacherLogin);
                        break;
                    case 4:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," "," Nhập sai! vui lòng nhập lại");
            }
        } while (choosen != 4);
    }
}
