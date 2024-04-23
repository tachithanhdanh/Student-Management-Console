package com.studentmanagement;

import java.util.Optional;
import java.util.List;

public interface StudentDao {
    Optional<Student> get(int id);
    List<Student> getAll();
    void save(Student t);
    void update(Student t);
    void delete(int id);
    void write();
    void read();
}
