package md2.nmh.casestudy.manager;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private ArrayList<Float> mouthScore = new ArrayList<>();
    private ArrayList<Float> fifteenScore = new ArrayList<>();
    private ArrayList<Float> oneLessonScore = new ArrayList<>();
    private float semesterScore;
    private float averageScore = 0;

    public Score() {
    }

    public float getAverageScore() {
        return averageScore;
    }

    private void countAverageScore() {
        int count = 0;
        float sum = 0;
        for (Float mark : mouthScore) {
            sum += mark;
            count++;
        }
        for (Float mark : fifteenScore) {
            sum += mark;
            count++;
        }
        for (Float mark : oneLessonScore) {
            sum += (mark * 2);
            count += 2;
        }
        if (this.semesterScore > 0) {
            sum += (semesterScore * 3);
            count += 3;
        }
        if (count == 0 || sum == 0) {
            return;
        }
        this.averageScore = (float) (Math.round(sum * 10 / count)) / 10;
    }

    public void setMouthScore(ArrayList<Float> mouthScore) {
        this.mouthScore = mouthScore;
    }

    public void setFifteenScore(ArrayList<Float> fifteenScore) {
        this.fifteenScore = fifteenScore;
    }

    public void setOneLessonScore(ArrayList<Float> oneLessonScore) {
        this.oneLessonScore = oneLessonScore;
    }


    public List<Float> getListMouthScore() {
        return mouthScore;
    }

    public List<Float> getListFifteenScore() {
        return fifteenScore;
    }

    public List<Float> getListOneLessonScore() {
        return oneLessonScore;
    }

    public void setMouthScore(Float mouthScore) {
        this.mouthScore.add(mouthScore);
        countAverageScore();
    }

    public String getMouthScore() {
        String result = "";
        for (float score : mouthScore) {
            result += score + "  ";
        }
        return result;
    }

    public String getFifteenScore() {
        String result = "";
        for (float score : fifteenScore) {
            result += score + "  ";
        }
        return result;
    }

    public String getOneLessonScore() {
        String result = "";
        for (float score : oneLessonScore) {
            result += score + "  ";
        }
        return result;
    }

    public ArrayList<String> getMouthList() {
        ArrayList<String> result = new ArrayList<>();
        if (mouthScore.isEmpty()) {
            return result;
        }
        result.add("a");
        for (float score : mouthScore) {
            result.add(String.valueOf(score));
        }
        return result;
    }

    public ArrayList<String> getFifteenList() {
        ArrayList<String> result = new ArrayList<>();
        if (fifteenScore.isEmpty()) {
            return result;
        }
        result.add("b");
        for (float score : fifteenScore) {
            result.add(String.valueOf(score));
        }
        return result;
    }

    public ArrayList<String> getOneLessonList() {
        ArrayList<String> result = new ArrayList<>();
        if (oneLessonScore.isEmpty()) {
            return result;
        }
        result.add("c");
        for (float score : oneLessonScore) {
            result.add(String.valueOf(score));
        }
        return result;
    }

    public ArrayList<String> getsemesterList() {
        ArrayList<String> result = new ArrayList<>();
        if (getSemesterScore() == 0) {
            return result;
        }
        result.add("d");
        result.add(String.valueOf(semesterScore));
        return result;
    }

    public void setFifteenScore(Float fifteenScore) {
        this.fifteenScore.add(fifteenScore);
        countAverageScore();
    }


    public void setOneLessonScore(Float oneLessonScore) {
        this.oneLessonScore.add(oneLessonScore);
        countAverageScore();
    }

    public float getSemesterScore() {
        return semesterScore;
    }

    public void setSemesterScore(float semesterScore) {
        this.semesterScore = semesterScore;
        countAverageScore();
    }

    public String parseScoreSubject() {

        return String.format("%-1s %-31s %-1s %-31s %-1s %-31s %-5s %-8s %-5s %-7s",
                "┆", getMouthScore(),
                "┆", getFifteenScore(),
                "┆", getOneLessonScore(),
                "┆", semesterScore,
                "┆", averageScore);
    }

    public ArrayList<String> getScoreList() {
        ArrayList<String> result = new ArrayList<>();
//        if (!getMouthList().isEmpty()) {
//            result.addAll(getMouthList());
//        }
//        if (!getFifteenList().isEmpty()) {
//            result.addAll(getFifteenList());
//        }
//        if (!getsemesterList().isEmpty()) {
//            result.addAll(getOneLessonList());
//        }
//        if (!getsemesterList().isEmpty()) {
//            result.addAll(getsemesterList());
//        }
        result.addAll(getMouthList());
        result.addAll(getFifteenList());
        result.addAll(getOneLessonList());
        result.addAll(getsemesterList());
        return result;
    }
}
