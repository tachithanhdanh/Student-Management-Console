package com.studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao{
    private final List<Student> students;

    public StudentDaoImpl() {
        students = new ArrayList<>();
    }

    @Override
    public void delete(int id) {
        get(id).ifPresent(existStudent -> students.remove(existStudent));     
    }

    @Override
    public Optional<Student> get(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void read() {
        // TODO Auto-generated method stub
        System.out.println("Read");
    }

    @Override
    public void save(Student student) {
        get(student.getId()).ifPresentOrElse(null, () -> students.add(student));
    }

    @Override
    public void update(Student student) {
        get(student.getId()).ifPresent(existStudent -> students.set(students.indexOf(existStudent), student));
    }

    @Override
    public void write() {
        // TODO Auto-generated method stub
        System.out.println("Write");
    }
    
}
