package com.studentmanagement;

import java.util.Comparator;

public class SortStudentByScore implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        double eps = 1E-6;
        if (Math.abs(s1.getScore() - s2.getScore()) < eps) {
            return 0;
        }
        return s1.getScore() > s2.getScore() ? 1 : -1;
    }
}
