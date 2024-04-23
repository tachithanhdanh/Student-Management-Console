package com.studentmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StudentController {
    private final StudentDao studentDao;
    private final BufferedReader bufferedReader;
    private final PrintWriter printWriter;
    private final StudentView studentView;

    public StudentController() {
        this.studentDao = new StudentDaoImpl();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.printWriter = new PrintWriter(System.out);
        this.studentView = new StudentView(bufferedReader, printWriter);
    }

    public StudentController(BufferedReader bufferedReader, PrintWriter printWriter) {
        this.bufferedReader = bufferedReader;
        this.printWriter = printWriter;
        this.studentDao = new StudentDaoImpl();
        this.studentView = new StudentView(bufferedReader, printWriter);
    }

    public void showMenu() {
        boolean running = true;
        while (running) {
            studentView.showMenu();
            try {
                int choice = studentView.getInput("Enter your choice: ");
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        updateStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        viewStudent();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        studentView.showMessage("Invalid choice");
                }
            } catch (Exception e) {
                studentView.showMessage("Invalid input");
            }
        }
    }

    public void addStudent() {
        Student student = null;
        try {
            student = studentView.getInputStudent();
        } catch (Exception e) {
            studentView.showMessage("Invalid input");
        }
        studentDao.save(student);
        studentView.showMessage("Student added sucessfully");
    }

    public void updateStudent() throws IOException {
        int id = 0;
        id = studentView.getInput("Enter student id: ");
        Student student = studentDao.get(id).orElse(null);
        if (student == null) {
            studentView.showMessage("Student not found");
            return;
        }
        studentView.showMessage("Enter new student details");
        student = studentView.getInputStudent();
        studentView.showMessage("Invalid input");
        studentDao.update(student);
        studentView.showMessage("Student updated sucessfully");
    }

    public void deleteStudent() throws IOException {
        int id = 0;
        id = studentView.getInput("Enter student id to delete: ");
        studentView.showMessage("Invalid input");
        studentDao.delete(id);
        studentView.showMessage("Student deleted sucessfully");
    }

    public void viewStudent() throws IOException {
        boolean running = true;
        while (running) {
            studentView.showViewOption();
            int choice = studentView.getInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    viewAllStudents();
                    break;
                case 2:
                    viewStudentById();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    studentView.showMessage("Invalid choice");
            }
        }
    }

    public void viewStudentById() {
        int id = 0;
        try {
            id = studentView.getInput("Enter student id: ");
        } catch (Exception e) {
            studentView.showMessage("Invalid input");
        }
        Student student = studentDao.get(id).orElse(null);
        if (student == null) {
            studentView.showMessage("Student not found");
            return;
        }
        studentView.showStudent(student);
    }

    public void viewAllStudents() throws IOException {
        boolean running = true;
        while (running) {
            studentView.showViewAllStudentsOption();
            int choice = studentView.getInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    studentDao.getAll().stream().sorted((s1, s2) -> s1.getId() - s2.getId()).forEach(studentView::showStudent);
                    break;
                case 2:
                    studentDao.getAll().stream().sorted((s1, s2) -> s2.getId() - s1.getId()).forEach(studentView::showStudent);
                    break;
                case 3:
                    studentDao.getAll().stream().sorted((s1, s2) -> Double.compare(s1.getScore(), s2.getScore())).forEach(studentView::showStudent);
                    break;
                case 4:
                    studentDao.getAll().stream().sorted((s1, s2) -> Double.compare(s2.getScore(), s1.getScore())).forEach(studentView::showStudent);
                    break;
                default:
                    studentView.showMessage("Invalid choice");
            }
        }
    }
}
