package md2.nmh.casestudy.manager;

import java.util.ArrayList;

public class ScoreSubject {
    private String name;
    private Score semesterOne = new Score();
    private Score semesterTwo = new Score();
    private float averageSubjectScore = 0;
    private float semester1AverageSubjectScore = 0;
    private float semester2AverageSubjectScore = 0;

    public ScoreSubject(String name) {
        this.name = name;
    }

    public float getSemester1AverageSubjectScore() {
        return semester1AverageSubjectScore;
    }

    public void setSemester1AverageSubjectScore() {
        this.semester1AverageSubjectScore = semesterOne.getAverageScore();
    }

    public float getSemester2AverageSubjectScore() {
        return semester2AverageSubjectScore;
    }

    public void setSemester2AverageSubjectScore() {
        this.semester2AverageSubjectScore = semesterTwo.getAverageScore();
    }

    private void countAverageScore() {
        if ((semesterOne.getAverageScore() == 0) && (semesterTwo.getAverageScore() == 0)) {
            return;
        }
        if ((semesterOne.getAverageScore() != 0) && (semesterTwo.getAverageScore() == 0)) {
            this.averageSubjectScore = semesterOne.getAverageScore();
            return;
        }
        this.averageSubjectScore = (float) Math.round(((semesterOne.getAverageScore() + (semesterTwo.getAverageScore() * 2))* 10 / 3) ) / 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getSemesterOne() {
        return semesterOne;
    }

    public void setSemesterOne(Score semesterOne) {
        this.semesterOne = semesterOne;
        countAverageScore();
        setSemester1AverageSubjectScore();
    }

    public Score getSemesterTwo() {
        return semesterTwo;
    }

    public void setSemesterTwo(Score semesterTwo) {
        this.semesterTwo = semesterTwo;
        countAverageScore();
        setSemester2AverageSubjectScore();
    }

    public float getAverageSubjectScore() {
        return averageSubjectScore;
    }
    public void showSemester1SubjectScore() {
        System.out.printf("%-1s %-13s", "┃",getName());
        System.out.printf(getSemesterOne().parseScoreSubject());
        System.out.printf("%-1s\n", "┃");
    }
    public void showSemester2SubjectScore() {
        System.out.printf("%-1s %-13s", "┃",getName());
        System.out.printf(getSemesterTwo().parseScoreSubject());
        System.out.printf("%-1s\n", "┃");
    }
    public void showAllScore() {
        System.out.printf("%-1s %-12s %-29s %-31s %-25s %-28s %-5s %-6s %-1s\n",
                "┃", getName(),
                "│",getSemesterOne().getAverageScore(),
                "│",getSemesterTwo().getAverageScore(),
                "│",averageSubjectScore,
                "┃");
    }
    private ArrayList<String> getSemester1List() {
        ArrayList<String> result = new ArrayList<>();
        if (getSemester1AverageSubjectScore() == 0) {
            return result;
        }
        result.add("HK1");
        result.addAll(semesterOne.getScoreList());
        return result;
    }
    private ArrayList<String> getSemester2List() {
        ArrayList<String> result = new ArrayList<>();
        if (getSemester2AverageSubjectScore() == 0) {
            return result;
        }
        result.add("HK2");
        result.addAll(semesterTwo.getScoreList());
        return result;
    }
    public ArrayList<String> getScoreSubjectList() {
        ArrayList<String> result = new ArrayList<>();
        result.add(name);
        result.addAll(getSemester1List());
        result.addAll(getSemester2List());
        return result;
    }

    @Override
    public String toString() {
        String result = getScoreSubjectList().toString();
        result = result.substring(1,result.length() -1);
        return result;
    }
}
