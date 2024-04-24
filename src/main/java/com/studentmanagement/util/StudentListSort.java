package com.studentmanagement.util;

import java.util.Collections;
import java.util.List;

import com.studentmanagement.Model.Student;

public class StudentListSort {
    public static void sortById(List<Student> studentList, boolean descending) {
        Collections.sort(studentList, (s1, s2) -> {
            if (s1.getId() < s2.getId()) {
                return -1;
            } else if (s1.getId() > s2.getId()) {
                return 1;
            }
            return 0;
        });
        if (descending) {
            Collections.reverse(studentList);
        }
    }

    public static void sortByScore(List<Student> studentList, boolean descending) {
        Collections.sort(studentList, (s1, s2) -> {
            if (s1.getScore() < s2.getScore()) {
                return -1;
            } else if (s1.getScore() > s2.getScore()) {
                return 1;
            }
            return 0;
        });
        if (descending) {
            Collections.reverse(studentList);
        }
    }
}
