package com.studentmanagement.Model;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private float score;
    private String image;
    private String address;
    private String description;
    
    public Student(int id, String name, float score, String image, String address, String description){
        this.id = id;
        this.name = name;
        this.score = score;
        this.image = image;
        this.address = address;
        this.description = description;
    }

    public Student() {
        
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(float score) {
        this.score = score;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDescription(String  description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public float getScore() {
        return score;
    }
    public String getImage() {
        return image;
    }
    public String getAddress() {
        return address;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\tStudent ID          : " +
                id +
                "\n" +
                "\tStudent Name        : " +
                name +
                "\n" +
                "\tStudent Score       : " +
                score +
                "\n" +
                "\tStudent Image       : " +
                image +
                "\n" +
                "\tStudent Address     : " +
                address +
                "\n" +
                "\tStudent Description : " +
                description +
                "\n";
    }

    public String toCsvString() {
        return id + "," + name + "," + score + "," + image + "," + address + "," + description;
    }
}
