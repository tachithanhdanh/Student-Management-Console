package com.studentmanagement;

public class Student {
    private int id;
    private String name;
    private double score;
    private String address;
    private String note;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.score = builder.score;
        this.address = builder.address;
        this.note = builder.note;
    }

    public int getId() {
        return this.id;
    }

    public static class StudentBuilder {
        private int id;
        private String name;
        private double score;
        private String address;
        private String note;

        public StudentBuilder(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public StudentBuilder score(double score) {
            this.score = score;
            return this;
        }

        public StudentBuilder note(String note) {
            this.note = note;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
