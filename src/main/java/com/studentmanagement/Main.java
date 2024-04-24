package com.studentmanagement;

import com.studentmanagement.Controller.StudentController;

public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.run();
    }
}
