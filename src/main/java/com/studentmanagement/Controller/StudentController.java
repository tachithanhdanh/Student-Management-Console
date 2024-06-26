package com.studentmanagement.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.studentmanagement.Data.StudentDao;
import com.studentmanagement.Data.StudentDaoImpl;
import com.studentmanagement.Model.Student;
import com.studentmanagement.View.StudentView;

public class StudentController {
    private final StudentView studentView;
    private final StudentDao studentDao;

    public StudentController() {
        studentView = new StudentView();
        studentDao = new StudentDaoImpl();
    }

    public void run() {
        studentView.showMessage("Student Management System Console Application");
        boolean running = true;
        while (running) {
            studentView.showMenu();
            int choice = studentView.getInput("(?) Enter your choice: ");
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> findStudent();
                case 4 -> deleteStudent();
                case 5 -> showStudentList();
                case 6 -> sortStudentList();
                case 7 -> importStudentList();
                case 8 -> exportStudentList();
                case 9 -> running = false;
                default -> studentView.showMessage("Invalid choice");
            }
            studentView.pause();
        }
    }

    private void addStudent() {
        int id = studentView.getStudentId();
        if (studentDao.getStudentById(id) != null) {
            studentView.showMessage("Student with id = " + id + " is already in the database");
            return;
        }
        Student student = studentView.getStudentInput(id);
        studentDao.addStudent(student);
        studentView.showMessage("Student added sucessfully");
    }
    
    private void updateStudent() {
        int id = studentView.getStudentId();
        if (studentDao.getStudentById(id) != null) {
            Student newStudent = studentView.getStudentInput(id);
            studentDao.updateStudent(id, newStudent);
            studentView.showMessage("Student updated successfully");
        } else {
            studentView.showMessage("Student id does not exist");
        }
    }
    
    private void findStudent() {
        int id = studentView.getStudentId();
        Student student = studentDao.getStudentById(id);
        if (student != null) {
            studentView.showMessage("Student with id " + id + " found");
            studentView.showStudentDetails(student);
        } else {
            studentView.showMessage("Student id does not exist");
        }  
    }
    
    private void deleteStudent() {
        int id = studentView.getStudentId();
        boolean idFound = studentDao.deleteStudent(id);
        if (idFound) {
            studentView.showMessage("Student removed");
        } else {
            studentView.showMessage("Student id not found");
        }
    }
    
    private void showStudentList() {
        List<Student> studentList = studentDao.getAllStudent();
        studentView.showStudentList(studentList);
    }

    private void sortStudentList() {
        studentView.showSortingOptions();
        int choice = studentView.getInput("Your choice: ");
        switch (choice) {
            case 1 -> studentDao.sortById(false);
            case 2 -> studentDao.sortById(true);
            case 3 -> studentDao.sortByScore(false);
            case 4 -> studentDao.sortByScore(true);
            default -> {
                studentView.showMessage("Invalid choice");
                return;
            }
        }
        studentView.showMessage("Student list sorted successfully");
    }

    private void importStudentList() {
        try {
            studentView.showFileOptions();
            int choice = studentView.getInput("Your choice: ");
            switch (choice) {
                case 1 -> importStudentListFromFile();
                case 2 -> importStudentListFromCsv();
                default -> throw new Exception("Invalid choice");
            }
            studentView.showMessage("Data imported successfully");
        } catch (FileNotFoundException e) {
            studentView.showMessage("Error: File does not exist or cannot be opened!");
        } catch (Exception e) {
            studentView.showMessage("#####ERROR#####");
            studentView.showMessage(e.getMessage());
        }
    }

    private void importStudentListFromFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        String path = studentView.getFilePath("Enter the file path of binary file: ");
        studentDao.importDataFromBinaryFile(path);
    }

    private void importStudentListFromCsv() throws IOException, FileNotFoundException, ClassNotFoundException {
        String path = studentView.getFilePath("Enter the file path of csv file: ");
        studentDao.importDataFromCsv(path);
    }

    private void exportStudentList() {
        try {
            studentView.showFileOptions();
            int choice = studentView.getInput("Enter your choice: ");
            switch (choice) {
                case 1 -> exportStudentListToFile();
                case 2 -> exportStudentListToCsv();
                default -> throw new IOException("Invalid choice");
            }
            studentView.showMessage("Data exported to file successfully");
        } catch (FileNotFoundException e) {
            studentView.showMessage("Error: File cannot be created or opened!");
        } catch (IOException e) {
            studentView.showMessage("Error: Cannot complete the process!");
            studentView.showMessage(e.getMessage());
        }
    }

    private void exportStudentListToFile() throws IOException, FileNotFoundException {
        String path = studentView.getFilePath("Enter the file path of binary file: ");
        studentDao.exportDataToBinaryFile(path);
    }

    private void exportStudentListToCsv() throws IOException, FileNotFoundException {
        String path = studentView.getFilePath("Enter the file path of csv file: ");
        studentDao.exportDataToCsv(path);
    }
}
