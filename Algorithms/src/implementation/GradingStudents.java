package implementation;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> newGrades = new ArrayList<>();
        for (int grade : grades) {
            if (grade < 38) {
                newGrades.add(grade);
                continue;
            }
            String s = String.valueOf(grade);
            int value = Integer.parseInt(s.substring(s.toCharArray().length - 1, s.toCharArray().length));

            if (10 - value < 3) {
                newGrades.add(grade + (10 - value));
            } else if ((5 - value) < 3 && value < 5) {
                newGrades.add(grade + (5 - value));
            } else {
                newGrades.add(grade);
            }
        }
        return newGrades;
    }

    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<>();
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        for(int i : gradingStudents(grades)) System.out.println(i);
    }
}
