package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.Gender;
import md2.nmh.casestudy.manager.Role;
import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.services.AppUtils;

import java.util.Scanner;

public class LoginView {
    private final Scanner sc = new Scanner(System.in);

    public LoginView() {
    }

    public Teacher login() {
        boolean isRetry;
        System.out.printf("%50s %s\n", " ", " ███████ ░ ▓ ░ ▓ ░ ▓    ĐĂNG NHẬP HỆ THỐNG    ░ ▓ ░ ▓ ░ ▓ ░ ███████");
        Teacher teacher = null;
        do {
            String username = "";
            do {
                System.out.printf("%40s %s\n", " ", " USERNAME: ");
                username = AppUtils.retryString("USERNAME");
                if (!AppUtils.retryUserName(username)) {
                    System.out.printf("%40s %s\n", " ", " Tài khoản không tồn tại! Vui lòng kiểm tra lại!!!");
                } else {
                    break;
                }
            } while (true);
            System.out.printf("%40s %s\n", " ", " MẬT KHẨU: ");
            String password = AppUtils.retryString("MẬT KHẨU");
            teacher = AppUtils.retryPassword(username, password);
            if (teacher == null) {
                System.out.printf("%40s %s\n", " ", " Mật khẩu không đúng, vui lòng kiểm tra lại !!! ");
                isRetry = isRetry();
            } else {
                System.out.printf("%50s %s\n", " ", "                  \uD83D\uDD10 Đăng nhập thành công \uD83D\uDD10\n");
                System.out.printf("%40s %s\n", " ", "  \uD83D\uDCBB  CHÀO MỪNG  ❀" +
                        (teacher.getGender().equals(Gender.Nam) ? " THẦY " : " CÔ ") +
                        (teacher.getName()).toUpperCase() +
                        " ❀  ĐÃ ĐẾN VỚI CỔNG THÔNG TIN TRƯỜNG CODE  \uD83D\uDCBB\n");
                if (teacher.getRole().equals(Role.ADMIN)) {
                    System.out.printf("%55s %s\n", " ", "    \uD83C\uDF38  CHÚC ADMIN <" +
                            (teacher.getName()).toUpperCase() +
                            ">  MỘT NGÀY VUI  \uD83C\uDF38\n");
                }

                isRetry = false;
            }
        } while (isRetry);
        return teacher;
    }

    private boolean isRetry() {
        do {
            System.out.printf("%50s %s\n", " ", "           ❐ ❐ ❐ ❐ ❐ ❐ ❐【  CHỌN  】❐ ❐ ❐ ❐ ❐ ❐ ❐");
            System.out.printf("%50s %s\n", " ", "           ❐                                        ❐");
            System.out.printf("%50s %s\n", " ", "           ❐   1.Nhấn phím bất kỳ để đăng nhập lại  ❐");
            System.out.printf("%50s %s\n", " ", "           ❐   2.Nhấn 'n' để thoát chương trình     ❐");
            System.out.printf("%50s %s\n", " ", "           ❐   3.Nhấn 'm' nếu bạn quên mật khẩu     ❐");
            System.out.printf("%50s %s\n", " ", "           ❐                                        ❐");
            System.out.printf("%50s %s\n", " ", "           ❐ ❐ ❐ ❐ ❐ ♦♢ ♦♢ ♦♢ ♦♢ ♦♢ ♦♢ ♦♢ ❐ ❐ ❐ ❐");
            System.out.printf("%50s %s", " ", " ⭆ ");
            String option = sc.nextLine();
            switch (option) {
                case "m":
                    System.out.printf("%50s %s\n", " ", " ◙‿◙ Vui lòng tự nhớ lại mật khẩu  ◙‿◙ !!!");
                    return true;
                case "n":
                    AppUtils.exit();
                    break;
                default:
                    return true;
            }
        } while (true);
    }
}
