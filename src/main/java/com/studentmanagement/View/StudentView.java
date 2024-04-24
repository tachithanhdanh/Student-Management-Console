package com.studentmanagement.View;

import java.util.List;
import java.util.Scanner;

import com.studentmanagement.Model.Student;


public class StudentView {
    private final Scanner scanner;

    public StudentView() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("Student Management System Console Application");
        System.out.println("#1. Add student");
        System.out.println("#2. Update student information");
        System.out.println("#3. Find student by id");
        System.out.println("#4. Delete student");
        System.out.println("#5. Show student list");
        System.out.println("#6. Sort student list");
        System.out.println("#7. Import student list");
        System.out.println("#8. Export student list");
        System.out.println("#9. Exit");
    }

    public int getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public int getStudentId() {
        return getInput("Enter student id: ");
    }

    public Student getStudentInput() {
        scanner.nextLine();
        int id = getStudentId();
        scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student score: ");
        float score = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter student image: ");
        String image = scanner.nextLine();
        System.out.print("Enter student address: ");
        String address = scanner.nextLine();
        System.out.print("Enter student description: ");
        String description = scanner.nextLine();
        return new Student(id, name, score, image, address, description);
    }

    public void showStudentDetails(Student student) {
        System.out.println(student);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showStudentList(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); ++i) {
            showMessage("Student No." + Integer.toString(i + 1));
            showStudentDetails(studentList.get(i));;
        }
    }

    public void showSortingOptions() {
        System.out.println("#1. Sort ascending by student id");
        System.out.println("#2. Sort descending by student id");
        System.out.println("#3. Sort ascending by student score");
        System.out.println("#4. Sort descending by student score");
    }

    public void showFileOptions() {
        System.out.println("#1. Binary file");
        System.out.println("#2. Text file (csv format)");
    }
}

