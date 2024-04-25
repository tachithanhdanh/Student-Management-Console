package com.studentmanagement.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    private Student student;


    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Test
    void testSetAndGetId() {
        student.setId(555);
        assertEquals(555, student.getId());
    }

    @Test
    void testSetAndGetName() {
        student.setName("Thành Danh");
        assertEquals("Thành Danh", student.getName());
    }

    @Test
    void testSetAndGetScore() {
        student.setScore(7.5F);
        assertEquals(7.5, student.getScore());
    }

    @Test
    void testSetAndGetImage() {
        student.setImage("image.png");
        assertEquals("image.png", student.getImage());
    }

    @Test
    void testSetAndGetAddress() {
        student.setAddress("60 Bùi Viện");
        assertEquals("60 Bùi Viện", student.getAddress());
    }

    @Test
    void testSetAndGetDescription() {
        student.setDescription("Java Programmer");
        assertEquals("Java Programmer", student.getDescription());
    }

    @Test
    void testToString() {
        student.setId(20);
        student.setName("Vinh");
        student.setScore(8.6F);
        student.setImage("VinhPham.png");
        student.setAddress("172 Lê Lợi");
        student.setDescription("Student at HCMUS");
        String expectedToString = """
                \tStudent ID          : 20
                \tStudent Name        : Vinh
                \tStudent Score       : 8.6
                \tStudent Image       : VinhPham.png
                \tStudent Address     : 172 Lê Lợi
                \tStudent Description : Student at HCMUS
                """;
        assertEquals(expectedToString, student.toString());
    }

    @Test
    void testToCsvString() {
        student.setId(20);
        student.setName("Vinh");
        student.setScore(8.6F);
        student.setImage("VinhPham.png");
        student.setAddress("172 Lê Lợi");
        student.setDescription("Student at HCMUS");
        String expectedString = "20,Vinh,8.6,VinhPham.png,172 Lê Lợi,Student at HCMUS";
        assertEquals(expectedString, student.toCsvString());
    }

    @Test
    void testConstructor() {
        student = new Student(50, "Danh", 10.0F, "avatar.png", "10 Han", "Java");
        assertEquals(50, student.getId());
        assertEquals("Danh", student.getName());
        assertEquals(10.0F, student.getScore());
        assertEquals("avatar.png", student.getImage());
        assertEquals("10 Han", student.getAddress());
        assertEquals("Java", student.getDescription());
    }
}
