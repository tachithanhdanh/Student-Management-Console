package com.studentmanagement.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.studentmanagement.Model.Student;

public interface StudentDao {
    void addStudent(Student student);
    void updateStudent(int id, Student student);
    Student getStudentById(int id);
    boolean deleteStudent(int id);
    List<Student> getAllStudent();
    void sortById(boolean descending);
    void sortByScore(boolean descending);
    void importDataFromBinaryFile(String fileName) throws IOException, FileNotFoundException, ClassNotFoundException;
    void importDataFromCsv(String fileName) throws IOException, FileNotFoundException;
    void exportDataToBinaryFile(String fileName) throws IOException, FileNotFoundException;
    void exportDataToCsv(String fileName) throws IOException, FileNotFoundException;
}
