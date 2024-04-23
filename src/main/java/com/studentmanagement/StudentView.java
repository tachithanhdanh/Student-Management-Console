package com.studentmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class StudentView {
    private final BufferedReader reader;
    private final PrintWriter writer;

    public StudentView(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public StudentView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.writer = new PrintWriter(System.out);
    }

    public void showMenu() {
        writer.println("1. Add Student");
        writer.println("2. Update Student");
        writer.println("3. Delete Student");
        writer.println("4. View Student");
        writer.println("5. Exit");
        writer.println("Enter your choice: ");
        writer.flush();
    }

    public void showViewOption() {
        writer.println("1. View All Students");
        writer.println("2. View Student by ID");
        writer.println("3. Back");
        writer.println("Enter your choice: ");
        writer.flush();
    }

    public void showViewAllStudentsOption() {
        writer.println("1. View by student id ascending");
        writer.println("2. View by student id descending");
        writer.println("3. View by score ascending");
        writer.println("4. View by score descending");
        writer.flush();
    }

    public int getInput(String prompt) throws IOException, NumberFormatException {
        writer.print(prompt);
        writer.flush();
        return Integer.parseInt(reader.readLine());
    }

    public double getInputDouble() throws IOException, NumberFormatException {
        return Double.parseDouble(reader.readLine());
    }

    public void showMessage(String message) {
        writer.println(message);
        writer.flush();
    }

    public Student getInputStudent() throws IOException {
        writer.println("Enter student details");
        int id = getInput("Enter student id: ");
        writer.print("Enter student name: ");
        writer.flush();
        String name = reader.readLine();
        writer.print("Enter student score: ");
        writer.flush();
        double score = getInputDouble();
        writer.print("Enter student address: ");
        writer.flush();
        String address = reader.readLine();
        writer.print("Enter student note: ");
        writer.flush();
        String note = reader.readLine();
        return new Student.StudentBuilder(id, name, address).score(score).note(note).build();
    }

    public void showStudent(Student student) {
        writer.println("Student id: " + student.getId());
        writer.println("Student name: " + student.getName());
        writer.println("Student score: " + student.getScore());
        writer.println("Student address: " + student.getAddress());
        writer.println("Student note: " + student.getNote());
        writer.flush();
    }

    public void showAllStudents(List<Student> students) {
        students.forEach(student -> {
            writer.println("Student id: " + student.getId());
            writer.println("Student name: " + student.getName());
            writer.println();
            writer.flush();
        });
    }
}
