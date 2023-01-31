package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.InputOption;
import md2.nmh.casestudy.manager.Role;
import md2.nmh.casestudy.manager.Student;
import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.services.AppUtils;
import md2.nmh.casestudy.services.InformationInput;
import md2.nmh.casestudy.statistic.StudentsList;

import java.util.*;

public class StudentMenu {
    public static Scanner sc = new Scanner(System.in);
    public static StudentsList studentsList = StudentsList.getInstance();

    public static void launch(Teacher teacherLogin) {
        int choosen = -1;
        do {
            Menu.showMenuStudentManager();
            try {
                do {
                    System.out.printf("%40s %s\n", " ", " Chọn chức năng: ");
                    System.out.printf("%50s %s", " ", " ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.printf("%40s %s\n", " ", " Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        ManagerView.showStudent(studentsList.findAll());
                        AppUtils.step();
                        break;
                    case 2:
                        studentsList.sortByName();
                        break;
                    case 3:
                        studentsList.sortByBirthday();
                        break;
                    case 4:
                        studentsList.sortByClass();
                        break;
                    case 5:
                        findStudentByName();
                        AppUtils.step();
                        break;
                    case 6:
                        editStudent(teacherLogin);
                        AppUtils.step();
                        break;
                    case 7:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            deleteStudent();
                        } else {
                            System.out.printf("%40s %s\n", " ", " Bạn không có quyền truy cập!!!");
                        }
                        AppUtils.step();
                        break;
                    case 8:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            addStudent();
                        } else {
                            System.out.printf("%40s %s\n", " ", " Bạn không có quyền truy cập!!!");
                        }
                        break;
                    case 9:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n", " ", " Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n", " ", " Nhập sai! vui lòng nhập lại");
            }
        } while (choosen != 0);
    }

    private static void findStudentByName() {
        System.out.printf("%40s %s\n", " ", " Nhập tên học sinh:");
        System.out.printf("%50s %s", " ", " ☞ ");
        String name = sc.nextLine();
        name = name.trim();
        if (!studentsList.existByName(name)) {
            System.out.printf("%40s %s\n", " ", " Không tìm thấy học sinh");
            return;
        }
        ManagerView.showStudent(studentsList.findAll(), name);
    }

    private static void addStudent() {
        Student newStudent = new Student();
        newStudent.setName(InformationInput.inputName(InputOption.ADD));
        newStudent.setGender(InformationInput.inputGender());
        newStudent.setBirthday(InformationInput.inputBirthday(InputOption.ADD));
        newStudent.setPhoneNumber(InformationInput.inputPhoneNumber(InputOption.ADD));
        newStudent.setEmail(InformationInput.inputEmail(InputOption.ADD));
        newStudent.setClassed(InformationInput.inputClass(InputOption.ADD));
        studentsList.add(newStudent);
        System.out.printf("%40s %s\n", " ", " Thêm học sinh thành công !!!");
    }

    private static void deleteStudent() {
        System.out.printf("%40s %s\n", " ", " Nhập id học sinh cần xóa");
        System.out.printf("%50s %s", " ", " ☞ ");
        int id = Integer.parseInt(sc.nextLine());
        if (id < 0 || !studentsList.existsById(id)) {
            System.out.printf("%40s %s\n", " ", " Không tìm thấy học sinh");
            return;
        }

        Student student = studentsList.getById(id);
        ManagerView.showOnlyStudent(student);

        System.out.printf("%40s %s\n", " ", " Bạn chắc chắn muốn xóa học sinh?");
        System.out.printf("%50s %s\n", " ", " 1. Đồng ý");
        System.out.printf("%50s %s\n", " ", " 2. Hủy (Or eny key)");
        System.out.printf("%50s %s", " ", " ☞ ");
        String choosen = sc.nextLine();

        if (choosen.equals("1")) {
            System.out.printf("%40s %s\n", " ", " Đã xóa học sinh: " + student.getName());
            studentsList.remove(student);
        } else {
            System.out.printf("%40s %s\n", " ", " Hủy thành công!!!");
        }

    }

    private static void editStudent(Teacher teacherLogin) {
        System.out.printf("%40s %s\n", " ", " Nhập id học sinh cần sửa");
        System.out.printf("%50s %s", " ", " ☞ ");
        int id;
        id = Integer.parseInt(sc.nextLine());
        if (id < 0 || !studentsList.existsById(id)) {
            System.out.printf("%40s %s\n", " ", " Không tìm thấy học sinh");
            return;
        }

        Student student = studentsList.getById(id);
        if (!student.getClassed().equals(teacherLogin.getClassed()) && teacherLogin.getRole().equals(Role.USER)) {
            System.out.printf("%40s %s\n", " ", " Bạn chỉ có quyền sửa thông tin học sinh lớp mình!!!");
            return;
        }
        ManagerView.showOnlyStudent(student);
        selectionEdit(student);

    }

    private static void selectionEdit(Student student) {
        int choosen = -1;
        do {
            Menu.showMenuEdit();
            try {
                do {
                    System.out.printf("%40s %s\n", " ", " Chọn chức năng: ");
                    System.out.printf("%50s %s", " ", " ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 7 || choosen < 0)
                        System.out.printf("%40s %s\n", " ", " Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 7 || choosen < 0);
                switch (choosen) {
                    case 1:
                        studentsList.remove(student);
                        student.setName(InformationInput.inputName(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.printf("%40s %s\n", " ", " ☑ Sửa thành công !!! ");
                        break;
                    case 2:
                        studentsList.remove(student);
                        student.setGender(InformationInput.inputGender());
                        studentsList.add(student);
                        System.out.printf("%40s %s\n", " ", " ☑ Sửa thành công !!! ");
                        break;
                    case 3:
                        studentsList.remove(student);
                        student.setBirthday(InformationInput.inputBirthday(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.printf("%40s %s\n", " ", " ☑ Sửa thành công !!! ");
                        break;
                    case 4:
                        studentsList.remove(student);
                        student.setPhoneNumber(InformationInput.inputPhoneNumber(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.printf("%40s %s\n", " ", " ☑ Sửa thành công !!! ");
                        break;
                    case 5:
                        studentsList.remove(student);
                        student.setEmail(InformationInput.inputEmail(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.printf("%40s %s\n", " ", " ☑ Sửa thành công !!! ");
                        break;
                    case 6:
                        studentsList.remove(student);
                        student.setClassed(InformationInput.inputClass(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.printf("%40s %s\n", " ", " ☑ Sửa thành công !!! ");
                        break;
                    case 7:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n", " ", " Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n", " ", " Nhập sai! vui lòng nhập lại");
            }
        } while (choosen != 0);

    }

}
