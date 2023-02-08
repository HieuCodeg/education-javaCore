package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.Classed;
import md2.nmh.casestudy.manager.Role;
import md2.nmh.casestudy.manager.Student;
import md2.nmh.casestudy.manager.Teacher;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManagerView {
    static Scanner sc = new Scanner(System.in);

    public static void showStudent(List<Student> students) {

        System.out.println("┍-------┬-----------┬----------------------------------▓▓▓▓▓《      DANH SÁCH HỌC SINH      》▓▓▓▓▓--------┬-------------------------------------┬--------┑");
        System.out.printf("%-2s %-4s %-5s %-5s %-19s %-21s %-1s %-9s %-1s %-10s %-4s %-13s %-16s %-20s %-2s %-5s %-1s\n",
                "┃", "STT", "│", "ID", "│", "TÊN", "│", "GIỚI TÍNH", "│", "NGÀY SINH", "│", "ĐIỆN THOẠI", "│", "EMAIL", "│", "LỚP", "┃");
        for (Student student : students) {
            System.out.printf("%-2s %-4s %-1s %-9s %-1s %-39s %-4s %-6s %-1s %-10s %-4s %-13s %-1s %-35s %-2s %-5s %-1s\n",
                    "┃", students.indexOf(student) + 1,
                    "┆", student.getId(),
                    "┆", student.getName(),
                    "┆", student.getGender(),
                    "┆", student.getBirthdayString(),
                    "┆", student.getPhoneNumber(),
                    "┆", student.getEmail(),
                    "┆ ", student.getClassed(),
                    "┃"
            );
        }
        System.out.println("┗-------┴-----------┴-----------------------------------------┴-----------┴------------┴------------------┴-------------------------------------┴--------┛");
    }

    public static void showStudent(List<Student> students, String name) {
        int count = 1;

        System.out.println("┍-------┬-----------┬----------------------------------▓▓▓▓▓《      DANH SÁCH HỌC SINH      》▓▓▓▓▓--------┬-------------------------------------┬--------┑");
        System.out.printf("%-2s %-4s %-5s %-5s %-19s %-21s %-1s %-9s %-1s %-10s %-4s %-13s %-16s %-20s %-2s %-5s %-1s\n",
                "┃", "STT", "│", "ID", "│", "TÊN", "│", "GIỚI TÍNH", "│", "NGÀY SINH", "│", "ĐIỆN THOẠI", "│", "EMAIL", "│", "LỚP", "┃");
        for (Student student : students) {
            if (student.getName().toUpperCase().contains(name.toUpperCase())) {
                System.out.printf("%-2s %-4s %-1s %-9s %-1s %-39s %-4s %-6s %-1s %-10s %-4s %-13s %-1s %-35s %-2s %-5s %-1s\n",
                        "┃", count,
                        "┆", student.getId(),
                        "┆", student.getName(),
                        "┆", student.getGender(),
                        "┆", student.getBirthdayString(),
                        "┆", student.getPhoneNumber(),
                        "┆", student.getEmail(),
                        "┆ ", student.getClassed(),
                        "┃"
                );
                count++;
            }
        }
        System.out.println("┗-------┴-----------┴-----------------------------------------┴-----------┴------------┴------------------┴-------------------------------------┴--------┛");
    }

    public static void showOnlyStudent(Student student) {
        System.out.printf("%-5s %-5s %-19s %-21s %-1s %-9s %-1s %-10s %-4s %-13s %-16s %-20s %-2s %-5s %-1s\n",
                "┃", "ID",
                "│", "TÊN",
                "│", "GIỚI TÍNH",
                "│", "NGÀY SINH",
                "│", "ĐIỆN THOẠI",
                "│", "EMAIL",
                "│", "LỚP",
                "┃");

        System.out.printf("%-1s %-9s %-1s %-39s %-4s %-6s %-1s %-10s %-3s %-14s %-1s %-35s %-2s %-5s %-1s\n",
                "┃", student.getId(),
                "┆", student.getName(),
                "┆", student.getGender(),
                "┆", student.getBirthdayString(),
                "┆", student.getPhoneNumber(),
                "┆", student.getEmail(),
                "┆ ", student.getClassed(),
                "┃"
        );
    }

    public static void showStudentScore(List<Student> list) {

        System.out.println("┍------------------------------------------------------------《      DANH SÁCH ĐIỂM      》-----------------------------------------------------------┑");
        System.out.printf("%-1s %-10s %-26s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-4s %-1s\n",
                "┃", "Id", "Tên", "Anh văn", "Hóa học", "Lịch sử", "Ngữ văn", "Sinh học", "Tin học", "Toán học", "Vật lý", "ĐTB", "┃");
        for (Student student : list) {
            float english = 0;
            float chemistry = 0;
            float history = 0;
            float literature = 0;
            float biology = 0;
            float informatic = 0;
            float math = 0;
            float physics = 0;
            float average = 0;

            try {
                english = student.getScoreStudent().getScoreSubject("Anh văn").getAverageSubjectScore();
            } catch (Exception e) {
            }
            try {
                chemistry = student.getScoreStudent().getScoreSubject("Hóa học").getAverageSubjectScore();
            } catch (Exception e) {
            }
            try {
                history = student.getScoreStudent().getScoreSubject("Lịch sử").getAverageSubjectScore();
            } catch (Exception e) {
            }
            try {
                literature = student.getScoreStudent().getScoreSubject("Ngữ văn").getAverageSubjectScore();
            } catch (Exception e) {
            }
            try {
                biology = student.getScoreStudent().getScoreSubject("Sinh học").getAverageSubjectScore();
            } catch (Exception e) {
            }
            try {
                informatic = student.getScoreStudent().getScoreSubject("Tin học").getAverageSubjectScore();
            } catch (Exception e) {
            }
            try {
                math = student.getScoreStudent().getScoreSubject("Toán học").getAverageSubjectScore();
            } catch (Exception e) {
            }
            try {
                physics = student.getScoreStudent().getScoreSubject("Vật lý").getAverageSubjectScore();
            } catch (Exception e) {
            }
            try {
                average = student.getScoreStudent().getAverageScore();
            } catch (Exception e) {
            }
            System.out.printf("%-1s %-10s %-26s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-4s %-1s\n",
                    "┃",
                    student.getId(),
                    student.getName(),
                    english,
                    chemistry,
                    history,
                    literature,
                    biology,
                    informatic,
                    math,
                    physics,
                    average,
                    "┃");
        }
        System.out.println("┗----------------------------------------------------------------------------------------------------------------------------------------------------┛");

    }

    public static void showStudentTableScore(Student student) {
        System.out.println("┍─────────────────────────────────────────────────────────────〘    BẢNG ĐIỂM     〙──────────────────────────────────────────────────────────────┑");
        ManagerView.showOnlyStudent(student);
        System.out.println("┃------------------------------------------------------------------------------------------------------------------------------------------------┃");
        System.out.printf("%-1s %74s %69s\n", "┃", "HỌC KÌ I", "┃");
        System.out.println("┃------------------------------------------------------------------------------------------------------------------------------------------------┃");
        System.out.printf("%-4s %-9s %-11s %-21s %-10s %-22s %-11s %-21s %-1s %-12s %-5s %-6s %-1s\n",
                "┃", "MÔN HỌC",
                "│", "ĐIỂM MIỆNG",
                "│", "ĐIỂM 15 PHÚT",
                "│", "ĐIỂM 1 TIẾT",
                "│", " ĐIỂM HỌC KÌ",
                "│", "ĐTB",
                "┃");
        student.getScoreStudent().showSemester1Score();
        System.out.println("┃------------------------------------------------------------------------------------------------------------------------------------------------┃");
        System.out.printf("%-1s %74s %69s\n", "┃", "HỌC KÌ II", "┃");
        System.out.println("┃------------------------------------------------------------------------------------------------------------------------------------------------┃");
        System.out.printf("%-4s %-9s %-11s %-21s %-10s %-22s %-11s %-21s %-1s %-12s %-5s %-6s %-1s\n",
                "┃", "MÔN HỌC",
                "│", "ĐIỂM MIỆNG",
                "│", "ĐIỂM 15 PHÚT",
                "│", "ĐIỂM 1 TIẾT",
                "│", " ĐIỂM HỌC KÌ",
                "│", "ĐTB",
                "┃");
        student.getScoreStudent().showSemester2Score();
        System.out.println("┃------------------------------------------------------------------------------------------------------------------------------------------------┃");
        System.out.printf("%-1s %74s %69s\n", "┃", "CẢ NĂM", "┃");
        System.out.println("┃------------------------------------------------------------------------------------------------------------------------------------------------┃");
        System.out.printf("%-1s %-12s %-21s %-39s %-17s %-36s %-1s %-10s %-1s\n",
                "┃", "   MÔN HỌC",
                "│", "ĐIỂM TRUNG BÌNH HKI",
                "│", "ĐIỂM TRUNG BÌNH HKII",
                "│", "    ĐTB",
                "┃");
        student.getScoreStudent().showAllScore();
        System.out.printf("%-1s %-12s %-26s %-34s %-22s %-31s %-2s %-9s %-1s\n",
                "┃", "▓▓TỔNG KẾT▓▓",
                "│", "=> " + student.getScoreStudent().getSemester1AverageScore() + " <=",
                "│", "=> " + student.getScoreStudent().getSemester2AverageScore() + " <=",
                "│", "=> " + student.getScoreStudent().getAverageScore() + " <=",
                "┃");
        System.out.println("┗────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┛");
    }

    public static void showTeacher(List<Teacher> teachers, Teacher teacherLogin) {
        System.out.println("┍-------┬-----------------┬-----------------------------▓▓▓▓▓▓▓▓▓▓▓▓▓《      DANH SÁCH GIÁO VIÊN      》▓▓▓▓▓▓▓▓▓▓▓▓▓---------------------┬--------------------┬--------┑");
        System.out.printf("%-2s %-4s %-8s %-8s %-14s %-16s %-1s %-9s %-1s %-10s %-2s %-5s %-4s %-13s %-6s %-18s %-6s %-12s  %-2s %-5s %-1s\n",
                "┃", "STT", "│", "ID", "│", "TÊN", "│", "GIỚI TÍNH", "│", "NGÀY SINH", "│", "LỚP", "│", "MÔN HỌC", "│", "TÊN ĐĂNG NHẬP", "│", "MẬT KHẨU", "│", "ROLE", "┃");
        for (Teacher teacher : teachers) {
            System.out.printf("%-3s %-3s %-2s %-14s %-2s %-28s %-3s %-7s %-1s %-10s %-2s %-5s %-4s %-13s %-2s %-22s %-2s %-16s  %-2s %-5s %-1s\n",
                    "┃", teachers.indexOf(teacher),
                    "│", teacher.getId(),
                    "│", teacher.getName(),
                    "│", teacher.getGender(),
                    "│", teacher.getBirthdayString(),
                    "│", teacher.getClassed(),
                    "│", teacher.getSubject(),
                    "│",
                    teacherLogin.getRole().equals(Role.ADMIN) ? teacher.getUsername() : teacher.getId() == teacherLogin.getId() ? teacher.getUsername() : "**************",
                    "│",
                    teacherLogin.getRole().equals(Role.ADMIN) ? teacher.getPassword() : teacher.getId() == teacherLogin.getId() ? teacher.getPassword() : "**************",
                    "│", teacher.getRole(),
                    "┃"
            );
        }
        System.out.println("┗-------┴-----------------┴-------------------------------┴-----------┴------------┴--------┴------------------┴-------------------------┴--------------------┴--------┛");
    }

    public static void showTeacher(List<Teacher> teachers, Teacher teacherLogin, String name) {
        int count = 1;
        System.out.println("┍-------┬-----------------┬-----------------------------▓▓▓▓▓▓▓▓▓▓▓▓▓《      DANH SÁCH GIÁO VIÊN      》▓▓▓▓▓▓▓▓▓▓▓▓▓---------------------┬--------------------┬--------┑");
        System.out.printf("%-2s %-4s %-8s %-8s %-14s %-16s %-1s %-9s %-1s %-10s %-2s %-5s %-4s %-13s %-6s %-18s %-6s %-12s  %-2s %-5s %-1s\n",
                "┃", "STT", "│", "ID", "│", "TÊN", "│", "GIỚI TÍNH", "│", "NGÀY SINH", "│", "LỚP", "│", "MÔN HỌC", "│", "TÊN ĐĂNG NHẬP", "│", "MẬT KHẨU", "│", "ROLE", "┃");
        for (Teacher teacher : teachers) {
            if (teacher.getName().toUpperCase().contains(name.toUpperCase())) {
                System.out.printf("%-3s %-3s %-2s %-14s %-2s %-28s %-3s %-7s %-1s %-10s %-2s %-5s %-4s %-13s %-2s %-22s %-2s %-16s  %-2s %-5s %-1s\n",
                        "┃", count,
                        "│", teacher.getId(),
                        "│", teacher.getName(),
                        "│", teacher.getGender(),
                        "│", teacher.getBirthdayString(),
                        "│", teacher.getClassed(),
                        "│", teacher.getSubject(),
                        "│",
                        teacherLogin.getRole().equals(Role.ADMIN) ? teacher.getUsername() : teacher.getId() == teacherLogin.getId() ? teacher.getUsername() : "**************",
                        "│",
                        teacherLogin.getRole().equals(Role.ADMIN) ? teacher.getPassword() : teacher.getId() == teacherLogin.getId() ? teacher.getPassword() : "**************",
                        "│", teacher.getRole(),
                        "┃"
                );
                count++;
            }
        }
        System.out.println("┗-------┴-----------------┴-------------------------------┴-----------┴------------┴--------┴------------------┴-------------------------┴--------------------┴--------┛");
    }

    public static void showOnlyTeacher(Teacher teacher) {
        System.out.println("┍-----------------┬-----------------------------▓▓▓▓▓▓▓▓▓▓▓▓▓《      THÔNG TIN GIÁO VIÊN      》▓▓▓▓▓▓▓▓▓▓▓▓▓---------------------┬--------------------┬--------┑");
        System.out.printf("%-8s %-8s %-14s %-16s %-1s %-9s %-1s %-10s %-2s %-5s %-4s %-13s %-6s %-18s %-6s %-12s  %-2s %-5s %-1s\n",
                "┃", "ID", "│", "TÊN", "│", "GIỚI TÍNH", "│", "NGÀY SINH", "│", "LỚP", "│", "MÔN HỌC", "│", "TÊN ĐĂNG NHẬP", "│", "MẬT KHẨU", "│", "ROLE", "┃");

            System.out.printf("%-2s %-14s %-2s %-28s %-3s %-7s %-1s %-10s %-2s %-5s %-4s %-13s %-2s %-22s %-2s %-16s  %-2s %-5s %-1s\n",
                    "┃", teacher.getId(),
                    "│", teacher.getName(),
                    "│", teacher.getGender(),
                    "│", teacher.getBirthdayString(),
                    "│", teacher.getClassed(),
                    "│", teacher.getSubject(),
                    "│", teacher.getUsername(),
                    "│", teacher.getPassword(),
                    "│", teacher.getRole(),
                    "┃"
            );
        System.out.println("┗-----------------┴-------------------------------┴-----------┴------------┴--------┴------------------┴-------------------------┴--------------------┴--------┛");
    }

    public static void showClass(Classed classed) {
        System.out.println("┍─────────────────────────────────────────────────────────────〘      DANH SÁCH LỚP       〙──────────────────────────────────────────────────────────────┑");

        System.out.printf("%-8s %-143s %-1s\n", "┃", "Lớp: " + classed.getName(), "┃");
        System.out.printf("%-8s %-143s %-1s\n", "┃", "Sĩ số: " + classed.getTotal(), "┃");
        System.out.printf("%-8s %-143s %-1s\n", "┃", "Giáo viên chủ nhiệm: " + classed.getHeadTeacher(), "┃");
        showStudent(classed.getStudentslist());
    }
}
