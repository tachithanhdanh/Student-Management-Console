package com.studentmanagement.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.Model.Student;
import com.studentmanagement.util.StudentListSort;
import com.studentmanagement.util.StudentFileManager;

public class StudentDaoImpl implements StudentDao {
    private List<Student> studentList;

    public StudentDaoImpl() {
        studentList = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentList.remove(getStudentById(id));
    }

    @Override
    public List<Student> getAllStudent() {
        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(int id, Student student) {
        for (int i = 0; i < id; ++i) {
            if (i == id) {
                studentList.set(i, student);
            }
        }
    }
    
    @Override
    public void sortById(boolean descending) {
        StudentListSort.sortById(studentList, descending);
    }

    @Override
    public void sortByScore(boolean descending) {
        StudentListSort.sortByScore(studentList, descending);
    }

    @Override
    public void exportDataToBinaryFile(String filePath) throws IOException, FileNotFoundException {
        StudentFileManager.exportStudentListToFile(studentList, filePath);
    }

    @Override
    public void exportDataToCsv(String filePath) throws IOException, FileNotFoundException {
        StudentFileManager.exportStudentListToCsv(studentList, filePath);
    }

    @Override
    public void importDataFromBinaryFile(String filePath) throws IOException, FileNotFoundException, ClassNotFoundException {
        studentList = StudentFileManager.importStudentListFromFile(filePath);
    }

    @Override
    public void importDataFromCsv(String filePath) throws IOException, FileNotFoundException {
        studentList = StudentFileManager.importStudentListFromCsv(filePath);
    }
    
}
