package md2.nmh.casestudy.services;

import md2.nmh.casestudy.manager.Gender;
import md2.nmh.casestudy.manager.InputOption;
import md2.nmh.casestudy.manager.Role;
import md2.nmh.casestudy.manager.Subject;

import java.util.ArrayList;
import java.util.Scanner;

public class InformationInput {
    public static Scanner sc = new Scanner(System.in);

    public static String inputName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.printf("%40s %s\n"," "," Nhập họ và tên (vd: Nguyễn Minh Hiếu) ");
                System.out.printf("%40s %s\n"," "," (Chữ cái đầu viết hoa, tên không bao gồm ký tự đặc biệt)");
                break;
            case UPDATE:
                System.out.printf("%40s %s\n"," "," Nhập tên mà bạn muốn sửa đổi");
                System.out.printf("%40s %s\n"," "," (Chữ cái đầu viết hoa, tên không bao gồm ký tự đặc biệt)");
                break;
        }
        String fullName;
        while (!Validex.isNameValid(fullName = AppUtils.retryString("Họ và tên"))) {
            System.out.printf("%40s %s\n"," "," Tên " + fullName + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.printf("%40s %s\n"," "," (Chữ cái đầu viết hoa, tên không bao gồm ký tự đặc biệt)");
        }
        return fullName;
    }

    public static Gender inputGender() {
        int choosen;
        do {
            System.out.printf("%40s %s\n"," "," Lựa chọn giới tính");
            System.out.printf("%50s %s\n"," "," 1. Nam");
            System.out.printf("%50s %s\n"," "," 2. Nữ");
            System.out.printf("%50s %s", " ", " ☞ ");
            try {
                choosen = Integer.parseInt(sc.nextLine());
                switch (choosen) {
                    case 1:
                        return Gender.Nam;
                    case 2:
                        return Gender.Nữ;
                    default:
                        System.out.printf("%40s %s\n"," "," Chưa chính xác, vui lòng chọn lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," ", e.getMessage() + " Vui lòng nhập lại!");
            }
        } while (true);
    }

    public static Role inputRole() {
        int choosen = -1;
        do {
            System.out.printf("%55s %s\n"," "," ░░░░░  Lựa chọn quyền truy cập  ░░░░░");
            System.out.printf("%55s %s\n"," "," ░░     1. ADMIN                    ░░");
            System.out.printf("%55s %s\n"," "," ░░     2. USER                     ░░");
            System.out.printf("%55s %s\n"," "," ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.printf("%50s %s", " ", " ☞ ");
            try {
                choosen = Integer.parseInt(sc.nextLine());
                switch (choosen) {
                    case 1:
                        return Role.ADMIN;
                    case 2:
                        return Role.USER;
                    default:
                        System.out.printf("%40s %s\n"," "," Chưa chính xác, vui lòng chọn lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," ", e.getMessage() + " Vui lòng nhập lại!");
            }
        } while (true);
    }

    public static String inputBirthday(InputOption option) {
        switch (option) {
            case ADD:
                System.out.printf("%40s %s\n"," "," Nhập ngày sinh: (vd: 02/02/2022)");
                break;
            case UPDATE:
                System.out.printf("%40s %s\n"," "," Nhập ngày sinh mà bạn muốn sửa đổi: ");
                break;
        }
        String birthday;
        while (!Validex.isBirthdayValid(birthday = AppUtils.retryString("Ngày sinh"))) {
            System.out.printf("%40s %s\n"," "," Giá trị " + birthday + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.printf("%40s %s\n"," "," Nhập ngày sinh: (vd: 02/02/2022) ");
        }
        return birthday;
    }

    public static String inputPhoneNumber(InputOption option) {
        switch (option) {
            case ADD:
                System.out.printf("%40s %s\n"," "," Nhập số điện thoại: (vd: 0989989999)");
                System.out.printf("%50s %s\n"," "," (Số điện thoại có 10 số, bắt đầu bằng số 0, không được bắt đầu bằng 00");
                break;
            case UPDATE:
                System.out.printf("%45s %s\n"," "," Nhập số điện thoại cần sửa: ");
                System.out.printf("%50s %s\n"," "," (Số điện thoại có 10 số, bắt đầu bằng số 0, không được bắt đầu bằng 00");
                break;
        }
        String phoneNumber;
        while (!Validex.isPhoneValid(phoneNumber = AppUtils.retryString("Số điện thoại"))) {
            System.out.printf("%40s %s\n"," "," Số " + phoneNumber + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.printf("%50s %s\n"," "," (Số điện thoại có 10 số, bắt đầu bằng số 0, không được bắt đầu bằng 00");
        }
        return phoneNumber;
    }

    public static String inputEmail(InputOption option) {
        switch (option) {
            case ADD:
                System.out.printf("%40s %s\n"," "," Nhập Email: (vd: Emailvidu@gmail.com)");
                System.out.printf("%50s %s\n"," "," (Email bao gồm chữ a-Z và số 0 - 9 và ký tự '.', chú ý trước @ không được '.' !");
                break;
            case UPDATE:
                System.out.printf("%40s %s\n"," "," Nhập Email cần sửa: ");
                System.out.printf("%50s %s\n"," "," (Email bao gồm chữ a-Z và số 0 - 9 và ký tự '.', chú ý trước @ không được '.' !");
                break;
        }
        String email;
        while (!Validex.isEmailValid(email = AppUtils.retryString("Email"))) {
            System.out.printf("%40s %s\n"," ", email + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.printf("%50s %s\n"," "," (Email bao gôm chữ a-Z và số 0 - 9 và ký tự '.', chú ý trước @ không được '.' !");
        }
        return email;
    }

    public static String inputClass(InputOption option) {
        switch (option) {
            case ADD:
                System.out.printf("%40s %s\n"," "," Nhập Lớp: (vd: 10A)");
                System.out.printf("%50s %s\n"," ", " Đây là trường cấp 3, bao gồm các lớp (A,B,C,D,E,G,H,K)!");
                break;
            case UPDATE:
                System.out.printf("%40s %s\n"," "," Nhập Lớp cần sửa: ");
                System.out.printf("%50s %s\n"," ", " Đây là trường cấp 3, bao gồm các lớp (A,B,C,D,E,G,H,K)!");
                break;
        }
        String classed;
        while (!Validex.isClassValid(classed = AppUtils.retryString("Email"))) {
            System.out.printf("%40s %s\n"," ", classed + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.printf("%50s %s\n"," ", " Đây là trường cấp 3, bao gồm các lớp (A,B,C,D,E,G,H,K)!");
        }
        return classed;
    }

    public static String inputPassword() {
        System.out.printf("%40s %s\n"," "," Nhập Password: ");
        System.out.printf("%50s %s\n"," "," + Không bao gồm dấu cách, ký tự ngắt dòng, ít nhất 6 ký tự");
        System.out.printf("%50s %s\n"," "," + Phải chứa ít nhất 1 ký tự số [0-9]");
        System.out.printf("%50s %s\n"," "," + Phải chứa ít nhất 1 ký tự chữ hoa");
        System.out.printf("%50s %s\n"," "," + Phải chứa ít nhất 1 ký tự chữ thường");
        System.out.printf("%50s %s\n"," "," + Phải chứa ít nhất 1 ký tự đặc biệt [! @ # $ % ^ & + = _ ]]");

        String password;
        while (!Validex.isPasswordValid(password = AppUtils.retryString("Password"))) {
            System.out.printf("%40s %s\n"," ",password + " không đúng định dạng hoặc chưa đủ mạnh." + " Vui lòng nhập lại!");
        }
        return password;
    }

    public static String inputUsername() {
        System.out.printf("%40s %s\n"," "," Nhập Username (>6 kí tự, không bao gồm dấu cách, không dấu)");
        String username;
        do {
            username = AppUtils.retryString("Username");
            if (!Validex.isUsernameValid(username) ) {
                System.out.printf("%40s %s\n"," ", username + " không đúng định dạng." + " Vui lòng nhập lại!");
                System.out.printf("%50s %s\n"," "," (>6 kí tự, không bao gồm dấu cách, không dấu)");
            }
            if (AppUtils.retryUserName(username)) {
                System.out.printf("%40s %s\n"," "," Tên đăng nhập đã tồn tại !!!");
            }
        } while (!Validex.isUsernameValid(username) || AppUtils.retryUserName(username));
        return username;
    }

    public static ArrayList<Float> inputListNumberScore() {
        ArrayList<Float> list = new ArrayList<>();
        float mark;
        while (true) {
            System.out.printf("%40s %s"," "," Nhập điểm: ");
            try {
                mark = (float) (Math.round(Float.parseFloat(sc.nextLine()) * 10)) / 10;
                list.add(mark);
                System.out.printf("%40s %s\n"," "," Nhấn 'q' để hoàn thành / phím bất kì để tiếp tục");
                System.out.printf("%50s %s", " ", " ☞ ");
                String option = sc.nextLine();
                if (option.equals("q")) {
                    break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," "," Điểm không hợp lệ! Vui lòng nhập lại!");
            }
        }

        return list;
    }
    public static ArrayList<String> inputListStringScore() {
        ArrayList<String> list = new ArrayList<>();
        float mark;
        while (true) {
            System.out.printf("%40s %s"," "," Nhập điểm: ");
            try {
                mark = (float) (Math.round(Float.parseFloat(sc.nextLine()) * 10)) / 10;
                list.add(String.valueOf(mark));
                System.out.printf("%40s %s\n"," "," Nhấn 'q' để hoàn thành / phím bất kì để tiếp tục");
                System.out.printf("%50s %s", " ", " ☞ ");
                String option = sc.nextLine();
                if (option.equals("q")) {
                    break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," "," Điểm không hợp lệ! Vui lòng nhập lại!");
            }
        }
        return list;
    }
    public static float inputScore() {
        float mark;
        while (true) {
            System.out.printf("%40s %s"," "," Nhập điểm: ");
            try {
                mark = (float) (Math.round(Float.parseFloat(sc.nextLine()) * 10)) / 10;
                return mark;
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," "," Điểm không hợp lệ! Vui lòng nhập lại!");
            }
        }
    }
    public static Subject inputSubject() {
        System.out.printf("%55s %s\n"," ","        ☑ Vui lòng lựa chọn môn học giảng dạy: ");
        System.out.printf("%55s %s\n"," ","        ┌ - - - - - - MÔN HỌC - - - - - - ┐");
        System.out.printf("%55s %s\n"," ","        ︲     0. Toán học                ︲");
        System.out.printf("%55s %s\n"," ","        ︲     1. Vật lý                  ︲");
        System.out.printf("%55s %s\n"," ","        ︲     2. Hóa học                 ︲");
        System.out.printf("%55s %s\n"," ","        ︲     3. Sinh học                ︲");
        System.out.printf("%55s %s\n"," ","        ︲     4. Tin học                 ︲");
        System.out.printf("%55s %s\n"," ","        ︲     5. Ngữ văn                 ︲");
        System.out.printf("%55s %s\n"," ","        ︲     6. Lịch sử                 ︲");
        System.out.printf("%55s %s\n"," ","        ︲     7. Anh văn                 ︲");
        System.out.printf("%55s %s\n"," ","        ︲     8. Địa lý                  ︲");
        System.out.printf("%55s %s\n"," ","        └ - - - - - - - - - - - - - - - - ┘");
        int option = AppUtils.retryChoose(0, 8);
        return Subject.parseSubject(option);
    }
}
