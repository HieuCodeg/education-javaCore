package md2.nmh.casestudy.manager;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.*;

public class ScoreStudent {
    private Map<String, ScoreSubject> myScore = new TreeMap<>();
    private float averageScore = 0;
    private float semester1AverageScore = 0;
    private float semester2AverageScore = 0;

    public ScoreStudent() {
    }
    public boolean containSubject(String key) {
        return myScore.containsKey(key);
    }
    private void countevArageScore() {
        int count = 0;
        float sum = 0;
        for (ScoreSubject scoreSubject: myScore.values()) {
            if (scoreSubject.getName().equals("Toán học") || scoreSubject.getName().equals("Ngữ văn")) {
                sum += (scoreSubject.getAverageSubjectScore() * 2);
                count += 2;
                continue;
            }
            sum += scoreSubject.getAverageSubjectScore();
            count++;
        }
        this.averageScore = (float) round((sum *10/count))/10;
    }
    private void countAverage1Score() {
        int count = 0;
        float sum = 0;
        for (ScoreSubject scoreSubject: myScore.values()) {
            if (scoreSubject.getName().equals("Toán học") || scoreSubject.getName().equals("Ngữ văn")) {
                sum += (scoreSubject.getSemester1AverageSubjectScore() * 2);
                count += 2;
                continue;
            }
            sum += scoreSubject.getSemester1AverageSubjectScore();
            count++;
        }
        this.semester1AverageScore = (float) round((sum *10/count))/10;
    }
    private void countAverage2Score() {
        int count = 0;
        float sum = 0;
        for (ScoreSubject scoreSubject: myScore.values()) {
            if (scoreSubject.getName().equals("Toán học") || scoreSubject.getName().equals("Ngữ văn")) {
                sum += (scoreSubject.getSemester2AverageSubjectScore() * 2);
                count += 2;
                continue;
            }
            sum += scoreSubject.getSemester2AverageSubjectScore();
            count++;
        }
        this.semester2AverageScore = (float) round((sum *10/count))/10;
    }

    public float getSemester1AverageScore() {
        countAverage1Score();
        return semester1AverageScore;
    }

    public float getSemester2AverageScore() {
        countAverage2Score();
        return semester2AverageScore;
    }

    public ScoreSubject getScoreSubject(String subject) {
        return myScore.get(subject);
    }

    public void setSubjectScore(ScoreSubject scoreSubject) {
        myScore.put(scoreSubject.getName(), scoreSubject);
    }

    public float getAverageScore() {
        countevArageScore();
        return averageScore;
    }
    public void showSemester1Score() {
        for (ScoreSubject scoreSubject: myScore.values()) {
            scoreSubject.showSemester1SubjectScore();
        }
    }
    public void showSemester2Score() {
        for (ScoreSubject scoreSubject: myScore.values()) {
            scoreSubject.showSemester2SubjectScore();
        }
    }
    public void showAllScore() {
        for (ScoreSubject scoreSubject: myScore.values()) {
            scoreSubject.showAllScore();
        }
    }
    public void showScore() {
        for (ScoreSubject scoreSubject: myScore.values()) {
            System.out.println(scoreSubject.toString());
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (ScoreSubject score: myScore.values()) {
            result += "\n" + score.toString();
        }
        return result;
    }
}
