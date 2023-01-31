package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.InputOption;
import md2.nmh.casestudy.manager.Role;
import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.services.AppUtils;
import md2.nmh.casestudy.services.FileUtil;
import md2.nmh.casestudy.services.InformationInput;
import md2.nmh.casestudy.statistic.TeacherList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeacherMenu {
    public final static String PATH = "data/teacher.csv";
    public static Scanner sc = new Scanner(System.in);

    public static TeacherList teacherList = TeacherList.getInstance();

    public static void launch(Teacher teacherLogin) {
        int choosen = -1;
        do {
            Menu.showMenuTeacherManager();
            try {
                do {
                    System.out.printf("%40s %s\n"," "," Chọn chức năng: ");
                    System.out.printf("%50s %s"," "," ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        ManagerView.showTeacher(teacherList.findAll(),teacherLogin);
                        AppUtils.step();
                        break;
                    case 2:
                        teacherList.sortByName();
                        break;
                    case 3:
                        teacherList.sortByBirthday();
                        break;
                    case 4:
                        teacherList.sortByClass();
                        break;
                    case 5:
                        findTeacherByName(teacherLogin);
                        AppUtils.step();
                        break;
                    case 6:
                        editTeacher(teacherLogin);
                        AppUtils.step();
                        break;
                    case 7:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            deleteTeacher();
                        } else {
                            System.out.printf("%40s %s\n"," "," Bạn không có quyền truy cập!!!");
                        }
                        AppUtils.step();
                        break;
                    case 8:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            addTeacher();
                        } else {
                            System.out.printf("%40s %s\n"," "," Bạn không có quyền truy cập!!!");
                        }
                        AppUtils.step();
                        break;
                    case 9:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," "," Nhập sai !!!");
            }
        } while (choosen != 0);
    }

    private static void findTeacherByName(Teacher teacherLogin) {
        System.out.printf("%40s %s\n"," "," Nhập tên giáo viên:");
        System.out.printf("%50s %s", " ", " ☞ ");
        String name = sc.nextLine();
        name = name.trim();
        if (!teacherList.existByName(name)) {
            System.out.printf("%40s %s\n"," "," Không tìm thấy giáo viên");
            return;
        }
        ManagerView.showTeacher(teacherList.findAll(), teacherLogin,name);


    }


    private static void addTeacher() {
        Teacher newTeacher = new Teacher();
        newTeacher.setName(InformationInput.inputName(InputOption.ADD));
        newTeacher.setGender(InformationInput.inputGender());
        newTeacher.setBirthday(InformationInput.inputBirthday(InputOption.ADD));
        newTeacher.setClassed(InformationInput.inputClass(InputOption.ADD));
        newTeacher.setSubject(InformationInput.inputSubject());
        newTeacher.setUsername(InformationInput.inputUsername());
        newTeacher.setPassword(InformationInput.inputPassword());
        newTeacher.setRole(InformationInput.inputRole());
        teacherList.add(newTeacher);
        System.out.printf("%40s %s\n"," ","Thêm giáo viên " + newTeacher.getName() + " thành công !!!");
    }

    private static void deleteTeacher() {
        System.out.printf("%40s %s\n"," "," Nhập id giáo viên cần xóa");
        System.out.printf("%50s %s"," "," ☞ ");
        int id = -1;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (id < 0 || !teacherList.existsById(id)) {
            System.out.printf("%40s %s\n"," "," Không tìm thấy giáo viên");
            return;
        }
        Teacher teacher = teacherList.getById(id);
        ManagerView.showOnlyTeacher(teacher);
        System.out.printf("%40s %s\n"," "," Bạn chắc chắn muốn xóa giáo viên này?");

        System.out.printf("%50s %s\n"," "," 1. Đồng ý");
        System.out.printf("%50s %s\n"," "," 2. Hủy (Or eny key)");
        System.out.printf("%50s %s"," "," ☞ ");
        String choosen = sc.nextLine();

        if (choosen.equals("1")) {
            System.out.printf("%40s %s\n"," ","Đã xóa giáo viên: " + teacher.getName());
            teacherList.remove(teacher);
        } else {
            System.out.printf("%40s %s\n"," ","Hủy thành công!!!");
        }
}

    private static void editTeacher(Teacher teacherLogin) {

        if (teacherLogin.getRole().equals(Role.USER)) {
            ManagerView.showOnlyTeacher(teacherLogin);
            selectionEdit(teacherLogin,teacherLogin);
        } else {
            System.out.printf("%40s %s\n"," "," Nhập id giáo viên cần sửa: ");
            System.out.printf("%50s %s"," "," ☞ ");
            int    id = Integer.parseInt(sc.nextLine());

            if (id < 0 || !teacherList.existsById(id)) {
                System.out.printf("%40s %s\n"," "," Không tìm thấy giáo viên !!!");
                return;
            }
            Teacher teacher = teacherList.getById(id);
            ManagerView.showOnlyTeacher(teacher);

            selectionEdit(teacherLogin,teacher);
        }
    }

    private static void selectionEdit(Teacher teacherLogin,Teacher teacher) {
        int choosen = -1;
        do {
            Menu.showMenuEditTeacher();
            try {
                do {
                    System.out.printf("%40s %s\n"," "," Chọn chức năng: ");
                    System.out.printf("%50s %s"," "," ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        teacherList.remove(teacher);
                        teacher.setName(InformationInput.inputName(InputOption.UPDATE));
                        teacherList.add(teacher);
                        System.out.printf("%40s %s\n"," "," ☑ Sửa thành công !!! ");

                        return;
                    case 2:
                        teacherList.remove(teacher);
                        teacher.setGender(InformationInput.inputGender());
                        teacherList.add(teacher);
                        System.out.printf("%40s %s\n"," "," ☑ Sửa thành công !!! ");

                        return;
                    case 3:
                        teacherList.remove(teacher);
                        teacher.setBirthday(InformationInput.inputBirthday(InputOption.UPDATE));
                        teacherList.add(teacher);
                        System.out.printf("%40s %s\n"," "," ☑ Sửa thành công !!! ");

                        return;
                    case 4:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            teacherList.remove(teacher);
                            teacher.setClassed(InformationInput.inputClass(InputOption.UPDATE));
                            teacherList.add(teacher);
                            System.out.printf("%40s %s\n"," "," ☑ Sửa thành công !!! ");
                        } else {
                            System.out.printf("%40s %s\n"," "," Giáo viên không có quyền truy cập !!! ");
                        }


                        return;
                    case 5:
                        teacherList.remove(teacher);
                        teacher.setSubject(InformationInput.inputSubject());
                        teacherList.add(teacher);
                        System.out.printf("%40s %s\n"," "," ☑ Sửa thành công !!! ");

                        return;
                    case 6:
                        teacherList.remove(teacher);
                        teacher.setUsername(InformationInput.inputUsername());
                        teacherList.add(teacher);
                        System.out.printf("%40s %s\n"," "," ☑ Sửa thành công !!! ");

                        return;
                    case 7:
                        teacherList.remove(teacher);
                        teacher.setPassword(InformationInput.inputPassword());
                        teacherList.add(teacher);
                        System.out.printf("%40s %s\n"," "," ☑ Sửa thành công !!! ");

                        return;
                    case 8:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            teacherList.remove(teacher);
                            teacher.setRole(InformationInput.inputRole());
                            teacherList.add(teacher);
                            System.out.printf("%40s %s\n"," "," ☑ Sửa thành công !!! ");
                        } else {
                            System.out.printf("%40s %s\n"," "," Bạn không có quyền truy cập!!!");
                        }
                        return;
                    case 9:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," "," Nhập sai! vui lòng nhập lại");
            }
        } while (choosen != 0);

    }
}
