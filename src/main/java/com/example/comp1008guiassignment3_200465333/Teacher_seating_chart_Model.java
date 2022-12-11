package com.example.comp1008guiassignment3_200465333;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Teacher_seating_chart_Model {

    private String studentName, studentColor;

    private List<String> allStudentName = new ArrayList<>();

    private static int MIN_LENGTH = 3;

    private static String tooShort = "should be at least 3 character";

    private static String COLOR_CODE_WHITE = "0xffffffff";

    Random ran = new Random();

    public int process(String studentName, String studentColor, String[] label_studentNames, String[] panes_studentColors_BackgroundFill, Label errorMsg){
        setStudentName(studentName,label_studentNames);
        setStudentColor(studentColor, panes_studentColors_BackgroundFill);
        isAllSeatsTaken(allStudentName, errorMsg);
        return getValidRandomResult(label_studentNames);
    }

    public String getStudentName() {
        return studentName;
    }

    private void setStudentName(String studentName, String[] label_studentNames) {
        if(studentName.length() < MIN_LENGTH)
            throw new IllegalArgumentException("Student Name " + tooShort);
        if(studentName.isBlank())
            throw new IllegalArgumentException("Student Name can not be blank");
        checkStudentNameUnique(label_studentNames, studentName);
        if(getValidRandomResult(label_studentNames) > -1){
            this.studentName = studentName;
            allStudentName.add(this.studentName);
        }
    }

    private void setStudentColor(String studentColor, String[] panes_studentColors_BackgroundFill) {
        processColor(studentColor, panes_studentColors_BackgroundFill);
        this.studentColor = studentColor;
    }

    private void checkStudentNameUnique(String[] label_studentNames, String textField_studentName){
        if(Arrays.asList(label_studentNames).contains(textField_studentName))
            throw new IllegalArgumentException("Student Name " + textField_studentName + " already exits!");
    }

    // get valid random number which is checked whether Current Random Selected Label Empty Or Blank
    private int getValidRandomResult(String[] label_studentNames){
        while(Arrays.asList(label_studentNames).contains("")) {
            int temp_Random = ran.nextInt(0, 9);
            if(Arrays.asList(label_studentNames).get(temp_Random).isEmpty()) {
                return temp_Random;
            }
        }
        throw new IllegalArgumentException("Full, All seats taken.");
    }

    private void isAllSeatsTaken(List<String> allStudentName, Label errorMsg){
        if(allStudentName.size() == 9){
            errorMsg.setText("Congratulations!" + " All Seats Completed!!!");
        }
    }
    /*
    public boolean isAllStudentNameEmpty(String[] label_studentNames){
        boolean is_Empty = false;
        for (String element : label_studentNames) {
            if (element.equals("")) {
                is_Empty = true;
                break;
            }
        }
        return is_Empty;
    }

    public int isRandomLabelStudentNameEmpty(String[] label_studentNames, String textField_studentName) {
        int temp_Random = ran.nextInt(0, 9);
        boolean isEmpty = true;
        while (isEmpty) {
            if (label_studentNames[temp_Random].isEmpty()) {
                isEmpty = false;
                break;
            } else {
                if (isAllStudentNameEmpty(label_studentNames)) {
                    temp_Random = ran.nextInt(0, 9);
                } else {
                    throw new IllegalArgumentException("full");
                }
            }
        }
        return temp_Random;
    }
     */

    private void processColor(String studentColor, String[] panes_studentColors_BackgroundFill){
        if(studentColor.equals(COLOR_CODE_WHITE)){
            throw new IllegalArgumentException("Default Color: White can not be selected");
        }
        isColorRepeat(studentColor, panes_studentColors_BackgroundFill);
    }

    private void isColorRepeat(String color_selected_String, String[] extractedColorsString){
        if(Arrays.asList(extractedColorsString).contains(color_selected_String))
            throw new IllegalArgumentException("Color: " + color_selected_String + " is already exist");
    }
}
