package com.studentmanagement.util;

import com.studentmanagement.config.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import com.studentmanagement.Model.Student;

public class StudentFileManager {
    public static List<Student> importStudentListFromFile(String filePath) throws IOException, FileNotFoundException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Student> students = (ArrayList<Student>)objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return students;
    }

    public static List<Student> importStudentListFromCsv(String filePath) throws IOException, FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        bufferedReader.readLine();
        ArrayList<Student> studentList = new ArrayList<>();
        Student studentTemp;

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            // split data with ','
            String[] attributes = line.split(",");
            if (attributes.length == Constants.NUMBER_OF_FIELDS) {
                studentTemp = new Student();
                studentTemp.setId(Integer.parseInt(attributes[Constants.ID_POS]));
                studentTemp.setName(attributes[Constants.NAME_POS]);
                studentTemp.setScore(Float.parseFloat(attributes[Constants.SCORE_POS]));
                studentTemp.setImage(attributes[Constants.IMAGE_POS]);
                studentTemp.setAddress(attributes[Constants.ADDRESS_POS]);
                studentTemp.setDescription(attributes[Constants.DESCRIPTION_POS]);
                studentList.add(studentTemp);
            }
        }
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        return studentList;
    }

    public static void exportStudentListToFile(List<Student> studentList, String filePath) throws IOException, FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        // DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentList);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static void exportStudentListToCsv(List<Student> studentList, String filePath) throws IOException, FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        // write file header
        bufferedWriter.write(Constants.CSV_FILE_HEADER);
        bufferedWriter.newLine();

        for (Student student : studentList) {
            String data = student.toCsvString();
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }
}
