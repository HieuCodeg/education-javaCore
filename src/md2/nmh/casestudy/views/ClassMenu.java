package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.*;
import md2.nmh.casestudy.services.AppUtils;
import md2.nmh.casestudy.services.FileUtil;
import md2.nmh.casestudy.services.InformationInput;
import md2.nmh.casestudy.services.ScoreUtil;
import md2.nmh.casestudy.statistic.ClassList;
import md2.nmh.casestudy.statistic.StudentsList;

import java.util.*;

public class ClassMenu {
    public final static String PATH = "data/score.csv";
//    Khởi tạo danh sách các lớp + thêm học sinh vào lớp
    public static ClassList classList = ClassList.getInstance();
    public static Map<String, Classed> classedMap = classList.findAll();

    static Scanner sc = new Scanner(System.in);

    public static void launch(Teacher teacherLogin) {
        do {
            Menu.showMenuGrade();
            try {
                System.out.printf("%40s %s", " ", "CHỌN ➽ :");
                int choosen = Integer.parseInt(sc.nextLine());
                switch (choosen) {
                    case 1:
                        showMenuClass("10", teacherLogin);
                        break;
                    case 2:
                        showMenuClass("11", teacherLogin);
                        break;
                    case 3:
                        showMenuClass("12", teacherLogin);
                        break;
                    case 4:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n", " ", " Chọn chức năng không đúng! Vui lòng chọn lại");
                        launch(teacherLogin);
                }
            } catch (Exception e) {
                System.out.printf("%40s %s\n", " ", " Nhập sai! vui lòng nhập lại");
            }
        } while (true);
    }

    public static void showMenuClass(String grade, Teacher teacherLogin) {
        do {
            Menu.showMenuClass(grade);
            try {
                System.out.printf("%40s %s", " ", "Chọn ➽ :");
                int choosen = Integer.parseInt(sc.nextLine());
                switch (choosen) {
                    case 1:
                       classOption(grade + "A", teacherLogin);
                        break;
                    case 2:
                        classOption(grade + "B", teacherLogin);
                        break;
                    case 3:
                        classOption(grade + "C", teacherLogin);
                        break;
                    case 4:
                       classOption(grade + "D", teacherLogin);
                        break;
                    case 5:
                       classOption(grade + "E", teacherLogin);
                        break;
                    case 6:
                        classOption(grade + "G", teacherLogin);
                        break;
                    case 7:
                       classOption(grade + "H", teacherLogin);
                        break;
                    case 8:
                       classOption(grade + "K", teacherLogin);
                        break;
                    case 9:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n", " ", " Chọn chức năng không đúng! Vui lòng chọn lại");
                        launch(teacherLogin);
                }
            } catch (InputMismatchException io) {
                System.out.printf("%40s %s\n", " ", " Nhập sai! vui lòng nhập lại");
            }
        } while (true);
    }

    public static void classOption(String name, Teacher teacherLogin) {
        int choosen = -1;
        do {
            Menu.showMenuClassOption();
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
                        ManagerView.showClass(classedMap.get(name));
                        AppUtils.step();
                        break;
                    case 2:
                        sortByName(classedMap.get(name).getStudentslist());
                        break;
                    case 3:
                        sortByBirthday(classedMap.get(name).getStudentslist());
                        break;
                    case 4:
                        sortById(classedMap.get(name).getStudentslist());
                        break;
                    case 5:
                        ManagerView.showStudentScore(classList.findAll().get(name).getStudentslist());
                        AppUtils.step();
                        break;
                    case 6:
                        findStudentScore(classList.findAll().get(name).getStudentslist());
                        AppUtils.step();
                        break;
                    case 7:
                        if (teacherLogin.getRole().equals(Role.ADMIN) || teacherLogin.getClassed().equals(name)) {
                            editStudentScore(classList.findAll().get(name).getStudentslist());
                        } else {
                            System.out.printf("%40s %s\n"," "," Bạn không có quyền truy cập!!!");
                        }
                        AppUtils.step();
                        break;
                    case 8:
                        if (teacherLogin.getRole().equals(Role.ADMIN) || teacherLogin.getClassed().equals(name)) {
                            addStudentScore(classList.findAll().get(name).getStudentslist());
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
            }
            catch (Exception e){
                System.out.printf("%40s %s\n"," "," Nhập sai! vui lòng nhập lại");
            }
        } while (choosen != 0);
    }

    private static void findStudentScore(List<Student> students) {
        long id;
        while (true) {
            try {
                System.out.printf("%40s %s\n"," "," Nhập id học sinh");
                System.out.printf("%50s %s"," "," ☞ ");
                id = Long.parseLong(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," "," Nhập sai! vui lòng nhập lại");
            }
        }
        for (Student student : students) {
            if (student.getId() == id) {
                ManagerView.showStudentTableScore(student);
                return;
            }
        }
        System.out.printf("%40s %s\n"," "," Không tìm thấy học sinh! Vui lòng kiểm tra lại!");
    }

    private static void sortById(List<Student> studentList) {
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                };
                return -1;
            }

        });
        AppUtils.stepSort();
    }

    private static void sortByBirthday(List<Student> studentList) {
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getBirthday().compareTo(o1.getBirthday());
            }
        });
        AppUtils.stepSort();
    }

    private static void sortByName(List<Student> students) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        AppUtils.stepSort();
    }

    private static Student findStudentById(List<Student> students) {
        long id;
        while (true) {
            try {
                System.out.printf("%40s %s\n"," "," Nhập id học sinh");
                System.out.printf("%50s %s"," "," ☞ ");
                id = Long.parseLong(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.printf("%40s %s\n"," "," Nhập sai! vui lòng nhập lại");
            }
        }
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static void editStudentScore(List<Student> students) {
        Student student = findStudentById(students);
        if (student == null) {
            System.out.printf("%40s %s\n"," "," Không tìm thấy học sinh! Vui lòng kiểm tra lại!");
            return;
        }
        showMenuSubject(InputOption.UPDATE, student);
    }

    private static void addStudentScore(List<Student> students) {
        Student student = findStudentById(students);
        if (student == null) {
            System.out.printf("%40s %s\n"," "," Không tìm thấy học sinh! Vui lòng kiểm tra lại!");
            return;
        }
        showMenuSubject(InputOption.ADD, student);

    }

    private static void showMenuSubject(InputOption option, Student student) {
        int choosen;
        do {
            Menu.showMenuEditSubject();

                do {
                    if (option.equals(InputOption.UPDATE)) {
                        System.out.printf("%40s %s\n"," "," Chọn môn học cần sửa điểm: ");
                    } else {
                        System.out.printf("%40s %s\n"," "," Chọn môn học nhập điểm: ");
                    }
                    System.out.printf("%50s %s"," "," ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        showMenuSemester(option, student, Subject.ANH);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 2:
                        showMenuSemester(option, student, Subject.HOA);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 3:
                        showMenuSemester(option, student, Subject.SU);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 4:
                        showMenuSemester(option, student, Subject.VAN);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 5:
                        showMenuSemester(option, student, Subject.SINH);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 6:
                        showMenuSemester(option, student, Subject.TIN);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 7:
                        showMenuSemester(option, student, Subject.TOAN);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 8:
                        showMenuSemester(option, student, Subject.LY);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 9:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }

        } while (choosen != 0);
    }

    private static void showMenuSemester(InputOption option, Student student, Subject subject) {
        int choosen;
        do {
            Menu.showMenuEditSemester();

                do {
                    if (option.equals(InputOption.UPDATE)) {
                        System.out.printf("%40s %s\n"," "," Chọn học kì cần sửa: ");
                    } else {
                        System.out.printf("%40s %s\n"," "," Chọn học kì nhập điểm: ");
                    }
                    System.out.printf("%50s %s"," ","  ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 3 || choosen < 0)
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 3 || choosen < 0);
                switch (choosen) {
                    case 1:
                        showMenuScore(option, student, subject, "HK1");
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 2:
                        showMenuScore(option, student, subject, "HK2");
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 3:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
        } while (choosen != 0);
    }

    private static void showMenuScore(InputOption option, Student student, Subject subject, String semester) {
        int choosen;
        do {
            Menu.showMenuEditScore();

                do {
                    if (option.equals(InputOption.UPDATE)) {
                        System.out.printf("%40s %s\n"," "," Chọn mục sửa: ");
                    } else {
                        System.out.printf("%40s %s\n"," "," Chọn mục nhập điểm: ");
                    }
                    System.out.printf("%50s %s"," ","  ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 5 || choosen < 0)
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 5 || choosen < 0);
                switch (choosen) {
                    case 1:
                        if (option.equals(InputOption.UPDATE)) {
                            editScore(student, subject, semester, "Điểm miệng");
                            return;
                        } else {
                            addScore(student, subject, semester, "Điểm miệng");
                            break;
                        }
                    case 2:

                        if (option.equals(InputOption.UPDATE)) {
                            editScore(student, subject, semester, "Điểm 15 phút");
                            return;
                        } else {
                            addScore(student, subject, semester, "Điểm 15 phút");
                            break;
                        }
                    case 3:

                        if (option.equals(InputOption.UPDATE)) {
                            editScore(student, subject, semester, "Điểm 1 tiết");
                            return;
                        } else {
                            addScore(student, subject, semester, "Điểm 1 tiết");
                            break;
                        }
                    case 4:

                        if (option.equals(InputOption.UPDATE)) {
                            editScore(student, subject, semester, "Điểm học kỳ");
                            return;
                        } else {
                            addScore(student, subject, semester, "Điểm học kỳ");
                            break;
                        }
                    case 5:
                        return;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.printf("%40s %s\n"," "," Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }

        } while (choosen != 0);
    }

    private static void editScore(Student student, Subject subject, String semester, String score) {
        List<Student> students;
        switch (semester) {
            case "HK1":
                switch (score) {
                    case "Điểm miệng":
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.printf("%40s %s"," "," Điểm miệng hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getMouthScore());

                            students = StudentsList.getInstance().findAll();
                            for (Student value : students) {
                                if (value.getId() == student.getId()) {
                                    value.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().setMouthScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.printf("%40s %s\n"," "," Sửa hoàn thành !!!");
                        } else {
                            System.out.printf("%40s %s\n"," "," chưa có điểm !!!");
                        }

                        return;
                    case "Điểm 15 phút":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.printf("%40s %s"," "," Điểm 15 phút hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getFifteenScore());

                            students = StudentsList.getInstance().findAll();
                            for (Student value : students) {
                                if (value.getId() == student.getId()) {
                                    value.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().setFifteenScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.printf("%40s %s\n"," "," Sửa hoàn thành !!!");
                        } else {
                            System.out.printf("%40s %s\n"," "," chưa có điểm !!!");
                        }

                        return;
                    case "Điểm 1 tiết":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.printf("%40s %s"," "," Điểm 1 tiết hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getOneLessonScore());

                            students = StudentsList.getInstance().findAll();
                            for (Student value : students) {
                                if (value.getId() == student.getId()) {
                                    value.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().setOneLessonScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.printf("%40s %s\n"," "," Sửa hoàn thành !!!");
                        } else {
                            System.out.printf("%40s %s\n"," "," chưa có điểm !!!");
                        }

                        return;
                    case "Điểm học kỳ":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.printf("%40s %s"," "," Điểm học kỳ I hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getSemesterScore());

                            students = StudentsList.getInstance().findAll();
                            for (Student value : students) {
                                if (value.getId() == student.getId()) {
                                    value.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().setSemesterScore(InformationInput.inputScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.printf("%40s %s\n"," "," Sửa hoàn thành !!!");
                        } else {
                            System.out.printf("%40s %s\n"," "," chưa có điểm !!!");
                        }

                        return;
                }
                break;
            case "HK2":
                switch (score) {
                    case "Điểm miệng":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.printf("%40s %s"," "," Điểm miệng hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getMouthScore());

                            students = StudentsList.getInstance().findAll();
                            for (Student value : students) {
                                if (value.getId() == student.getId()) {
                                    value.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().setMouthScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.printf("%40s %s\n"," "," Sửa hoàn thành !!!");
                        } else {
                            System.out.printf("%40s %s\n"," "," chưa có điểm !!!");
                        }

                        return;
                    case "Điểm 15 phút":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.printf("%40s %s"," "," Điểm 15 phút hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getFifteenScore());

                            students = StudentsList.getInstance().findAll();
                            for (Student value : students) {
                                if (value.getId() == student.getId()) {
                                    value.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().setFifteenScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.printf("%40s %s\n"," "," Sửa hoàn thành !!!");
                        } else {
                            System.out.printf("%40s %s\n"," "," chưa có điểm !!!");
                        }

                        return;
                    case "Điểm 1 tiết":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.printf("%40s %s"," "," Điểm 1 tiết hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getOneLessonScore());

                            students = StudentsList.getInstance().findAll();
                            for (Student value : students) {
                                if (value.getId() == student.getId()) {
                                    value.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().setOneLessonScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.printf("%40s %s\n"," "," Sửa hoàn thành !!!");
                        } else {
                            System.out.printf("%40s %s\n"," "," chưa có điểm !!!");
                        }

                        return;
                    case "Điểm học kỳ":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.printf("%40s %s"," "," Điểm học kỳ II hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getSemesterScore());

                            students = StudentsList.getInstance().findAll();
                            for (Student value : students) {
                                if (value.getId() == student.getId()) {
                                    value.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().setSemesterScore(InformationInput.inputScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.printf("%40s %s\n"," "," Sửa hoàn thành !!!");
                        } else {
                            System.out.printf("%40s %s\n"," "," chưa có điểm !!!");
                        }

                        return;
                }
                break;
        }

    }

    private static void addScore(Student student, Subject subject, String semester, String score) {
        ArrayList<String> list;
        String line;
        List<Student> students;
        if (!student.getScoreStudent().containSubject(subject.getValue())) {
            list = new ArrayList<>();
            list.add(subject.getValue());
        } else {
            list = student.getScoreStudent().getScoreSubject(subject.getValue()).getScoreSubjectList();
        }
        switch (semester) {
            case "HK1":
                switch (score) {
                    case "Điểm miệng":
                        System.out.printf("%40s %s"," "," Điểm miệng hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getMouthScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> mouthList = InformationInput.inputListStringScore();
                        addList(list,semester,"a",mouthList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);
                        ScoreSubject scoreSubject = ScoreUtil.parseScore(line);

                        students = StudentsList.getInstance().findAll();
                        for (Student value : students) {
                            if (value.getId() == student.getId()) {
                                value.getScoreStudent().setSubjectScore(scoreSubject);
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);

                        System.out.printf("%40s %s\n"," "," Thêm thành công !!!");
                        break;
                    case "Điểm 15 phút":
                        System.out.printf("%40s %s"," "," Điểm 15 phút hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getFifteenScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> fifteenList = InformationInput.inputListStringScore();
                        addList(list,semester,"b",fifteenList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (Student value : students) {
                            if (value.getId() == student.getId()) {
                                value.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);
//                        student.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                        System.out.printf("%40s %s\n"," "," Thêm thành công !!!");
                        break;
                    case "Điểm 1 tiết":
                        System.out.printf("%40s %s"," "," Điểm 1 tiết hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getOneLessonScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> oneLessonList = InformationInput.inputListStringScore();
                        addList(list,semester,"c",oneLessonList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);
                        students = StudentsList.getInstance().findAll();
                        for (Student value : students) {
                            if (value.getId() == student.getId()) {
                                value.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);
                        System.out.printf("%40s %s\n"," "," Thêm thành công !!!");
                        break;
                    case "Điểm học kỳ":
                        System.out.printf("%40s %s"," "," Điểm học kỳ I hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getSemesterScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> semesterList = new ArrayList<>();
                        semesterList.add(String.valueOf(InformationInput.inputScore()));
                        addList(list,semester,"d",semesterList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (Student value : students) {
                            if (value.getId() == student.getId()) {
                                value.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);
                        System.out.printf("%40s %s\n"," "," Thêm thành công !!!");
                        break;
                }
                break;
            case "HK2":
                switch (score) {
                    case "Điểm miệng":
                        System.out.printf("%40s %s"," "," Điểm miệng hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getMouthScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> mouthList = InformationInput.inputListStringScore();
                        addList(list,semester,"a",mouthList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (Student value : students) {
                            if (value.getId() == student.getId()) {
                                value.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);
                        System.out.printf("%40s %s\n"," "," Thêm thành công !!!");
                        break;
                    case "Điểm 15 phút":
                        System.out.printf("%40s %s"," "," Điểm 15 phút hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getFifteenScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> fifteenList = InformationInput.inputListStringScore();
                        addList(list,semester,"b",fifteenList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (Student value : students) {
                            if (value.getId() == student.getId()) {
                                value.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);
                        System.out.printf("%40s %s\n"," "," Thêm thành công !!!");
                        break;
                    case "Điểm 1 tiết":
                        System.out.printf("%40s %s"," "," Điểm 1 tiết hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getOneLessonScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> oneLessonList = InformationInput.inputListStringScore();
                        addList(list,semester,"c",oneLessonList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (Student value : students) {
                            if (value.getId() == student.getId()) {
                                value.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);
                        System.out.printf("%40s %s\n"," "," Thêm thành công !!!");
                        break;
                    case "Điểm học kỳ":
                        System.out.printf("%40s %s"," "," Điểm học kỳ II hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getSemesterScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> semesterList = new ArrayList<>();
                        semesterList.add(String.valueOf(InformationInput.inputScore()));
                        addList(list,semester,"d",semesterList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (Student value : students) {
                            if (value.getId() == student.getId()) {
                                value.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);
                        System.out.printf("%40s %s\n"," "," Thêm thành công !!!");
                        break;
                }
                break;
        }

    }

    public static void addList(List<String> list, String semester, String key, List<String> value) {
        switch (semester) {
            case "HK1":
                if (!list.contains(semester)) {
                    list.add(1, semester);
                    list.add(2,key);
                    list.addAll(3, value);
                    return;
                }
                int endIndex = 0;
                while (endIndex < list.size() && !list.get(endIndex).equals("HK2")) {
                    endIndex++;
                }
//    Lịch sử,HK1,a,8,9,b,9,c,7,7,6,d,6.6,HK2,a,8,9,b,9,c,7.4

                ArrayList<String> semester1List = new ArrayList<>();
                for (int i = 2; i < endIndex; i++) {
                    semester1List.add(list.get(2));
                    list.remove(2);
                }
//                Trường hợp đã có mục điểm
                if (semester1List.contains(key)) {
                    int index = 0;
                    for (int i = 0; i < semester1List.size(); i++) {
                        if (semester1List.get(i).equals(key)) {
                            index = i;
                            break;
                        }
                    }
                    do {
                        index++;
                        if (index >= semester1List.size()) {
                            break;
                        }
                    } while (ScoreUtil.isNumber(semester1List.get(index)));
                    semester1List.addAll(index, value);
                    list.addAll(2, semester1List);
                    return;
                }
//                 Trường hợp chưa có mục điểm
                switch (key) {
                    case "a":
                        semester1List.add(0, "a");
                        semester1List.addAll(1, value);
                        break;
                    case "b":
                        if (semester1List.get(0).equals("c") || semester1List.get(0).equals("d")) {
                            semester1List.add(0, "b");
                            semester1List.addAll(1, value);
                            break;
                        }
                        int index = 0;
                        do {
                            index++;
                            if (index >= semester1List.size()) {
                                break;
                            }
                        } while (ScoreUtil.isNumber(semester1List.get(index)));
                        semester1List.addAll(index, value);
                        semester1List.add(index, "b");
                        break;
                    case "c":
                        if (!semester1List.contains("d")) {
                            semester1List.add(semester1List.size(),"c");
                            semester1List.addAll(semester1List.size(),value);
                            break;
                        }
                        int indexd = 0;
                        for (int i = 0; i < semester1List.size(); i++) {
                            if (semester1List.get(i).equals("d")) {
                                indexd = i;
                                break;
                            }
                        }
                        semester1List.addAll(indexd,value);
                        semester1List.add(indexd,"c");
                        break;
                    case "d":
                        semester1List.add(semester1List.size(),"d");
                        semester1List.addAll(semester1List.size(),value);
                        break;
                }
                list.addAll(2, semester1List);
                break;
            case "HK2":
                if (!list.contains(semester)) {
                    list.add(semester);
                    list.add(key);
                    list.addAll(value);
                    return;
                }
                int beginIndex = 0;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).equals("HK2")) {
                        beginIndex = i +1;
                        break;
                    }
                }
//    Lịch sử,HK1,a,8,9,b,9,c,7,7,6,d,6.6,HK2,a,8,9,b,9,c,7

                ArrayList<String> semester2List = new ArrayList<>();
                int size = list.size();
                for (int i = beginIndex; i < size; i++) {
                    semester2List.add(list.get(beginIndex));
                    list.remove(beginIndex);
                }
//                Trường hợp đã có mục điểm

                if (semester2List.contains(key)) {
                    int index = 0;
                    for (int i = 0; i < semester2List.size(); i++) {
                        if (semester2List.get(i).equals(key)) {
                            index = i;
                            break;
                        }
                    }
                    do {
                        index++;
                        if (index >= semester2List.size()) {
                            break;
                        }
                    } while (ScoreUtil.isNumber(semester2List.get(index)));
                    semester2List.addAll(index, value);
                    list.addAll(beginIndex, semester2List);
                    return;
                }
//                 Trường hợp chưa có mục điểm
                //                a,8,9,b,9,c,7,7,6,d,6
                switch (key) {
                    case "a":
                        semester2List.add(0, "a");
                        semester2List.addAll(1, value);
                        break;
                    case "b":
                        if (semester2List.get(0).equals("c") || semester2List.get(0).equals("d")) {
                            semester2List.add(0, "b");
                            semester2List.addAll(1, value);
                            break;
                        }
                        int index = 0;
                        do {
                            index++;
                            if (index >= semester2List.size()) {
                                break;
                            }
                        } while (ScoreUtil.isNumber(semester2List.get(index)));
                        semester2List.addAll(index, value);
                        semester2List.add(index, "b");
                        break;
                    case "c":
                        if (!semester2List.contains("d")) {
                            semester2List.add(semester2List.size(),"c");
                            semester2List.addAll(semester2List.size(),value);
                            break;
                        }
                        int indexd = 0;
                        for (int i = 0; i < semester2List.size(); i++) {
                            if (semester2List.get(i).equals("d")) {
                                indexd = i;
                                break;
                            }
                        }
                        semester2List.addAll(indexd,value);
                        semester2List.add(indexd,"c");
                        break;
                    case "d":
                        semester2List.add(semester2List.size(),"d");
                        semester2List.addAll(semester2List.size(),value);
                        break;
                }
                list.addAll(beginIndex, semester2List);
                break;
        }
    }


}
