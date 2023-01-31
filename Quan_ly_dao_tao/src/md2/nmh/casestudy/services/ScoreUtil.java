package md2.nmh.casestudy.services;

import md2.nmh.casestudy.manager.*;
import md2.nmh.casestudy.statistic.StudentsList;


import java.util.List;

public class ScoreUtil {

    public final static String PATH = "data/score.csv";
    public static void read(List<Student> students) {
        List<String> lineList = FileUtil.read(PATH);
        ScoreStudent scoreStudent= new ScoreStudent();
        String idLine = "";
        for (int i = 0; i < lineList.size(); i++) {
            String line = lineList.get(i);
            if (line.length() < 8) {
                if (i > 0) {
                    add(idLine,scoreStudent,students);
                }
                idLine = line;
                scoreStudent = new ScoreStudent();
                continue;
            }
            scoreStudent.setSubjectScore(parseScore(line));
            if (i == lineList.size() - 1) {
                add(idLine,scoreStudent,students);
            }

        }
    }
    public static void add(String idLine,ScoreStudent scoreStudent,List<Student> students) {
        long id = Long.parseLong(idLine);
        for (Student student : students) {
            if (student.getId() == id) {
                student.setScore(scoreStudent);
                break;
            }
        }
    }
    public static ScoreSubject parseScore(String line) {
        String[] scoreList = line.split(",");
        for (int i = 0; i < scoreList.length; i++) {
            scoreList[i]=scoreList[i].trim();
        }
        int length = scoreList.length;
        int count = 1;
        ScoreSubject scoreSubject = new ScoreSubject(scoreList[0]);
        while (count < length) {
            switch (scoreList[count]) {
                case "HK1":
                    Score scoreSemester1 = new Score();
                    count++;
                    while (count < length && !scoreList[count].equals("HK2")) {
                        switch (scoreList[count]) {
                            case "a":
                                count++;
                                do {
                                    scoreSemester1.setMouthScore(Float.parseFloat(scoreList[count]));
                                    count++;
                                    if (count >= length) {
                                        break;
                                    }
                                } while (isNumber(scoreList[count]));
                                break;
                            case "b":
                                count++;
                                do {
                                    scoreSemester1.setFifteenScore(Float.parseFloat(scoreList[count]));
                                    count++;
                                    if (count >= length) {
                                        break;
                                    }
                                } while (isNumber(scoreList[count]));
                                break;
                            case "c":
                                count++;
                                do {
                                    scoreSemester1.setOneLessonScore(Float.parseFloat(scoreList[count]));
                                    count++;
                                    if (count >= length) {
                                        break;
                                    }
                                } while (isNumber(scoreList[count]));
                                break;
                            case "d":
                                count++;
                                do {
                                    scoreSemester1.setSemesterScore(Float.parseFloat(scoreList[count]));
                                    count++;
                                    if (count >= length) {
                                        break;
                                    }
                                } while (isNumber(scoreList[count]));
                                break;
                        }
                    }
                    scoreSubject.setSemesterOne(scoreSemester1);
                    break;
                case "HK2":
                    Score scoreSemester2 = new Score();
                    count++;
                    while (count < length) {
                        switch (scoreList[count]) {
                            case "a":
                                count++;
                                do {
                                    scoreSemester2.setMouthScore(Float.parseFloat(scoreList[count]));
                                    count++;
                                    if (count >= length) {
                                        break;
                                    }
                                } while (isNumber(scoreList[count]));
                                break;
                            case "b":
                                count++;
                                do {
                                    scoreSemester2.setFifteenScore(Float.parseFloat(scoreList[count]));
                                    count++;
                                    if (count >= length) {
                                        break;
                                    }
                                } while (isNumber(scoreList[count]));
                                break;
                            case "c":
                                count++;
                                do {
                                    scoreSemester2.setOneLessonScore(Float.parseFloat(scoreList[count]));
                                    count++;
                                    if (count >= length) {
                                        break;
                                    }
                                } while (isNumber(scoreList[count]));
                                break;
                            case "d":
                                count++;
                                do {
                                    scoreSemester2.setSemesterScore(Float.parseFloat(scoreList[count]));
                                    count++;
                                    if (count >= length) {
                                        break;
                                    }
                                } while (isNumber(scoreList[count]));
                                break;
                        }
                    }
                    scoreSubject.setSemesterTwo(scoreSemester2);
                    break;
            }
        }
        return scoreSubject;
    }

    public static boolean isNumber(String s) {
        try {
            Float iVal = Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
