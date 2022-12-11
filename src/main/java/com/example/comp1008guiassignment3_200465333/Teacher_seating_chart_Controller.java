package com.example.comp1008guiassignment3_200465333;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Teacher_seating_chart_Controller {

    @FXML
    private Label errorMsg;

    @FXML
    private Label label_01;

    @FXML
    private Label label_03;

    @FXML
    private Label label_05;

    @FXML
    private Label label_11;

    @FXML
    private Label label_13;

    @FXML
    private Label label_15;

    @FXML
    private Label label_21;

    @FXML
    private Label label_23;

    @FXML
    private Label label_25;

    @FXML
    private HBox pane_00;

    @FXML
    private HBox pane_02;

    @FXML
    private HBox pane_04;

    @FXML
    private HBox pane_10;

    @FXML
    private HBox pane_12;

    @FXML
    private HBox pane_14;

    @FXML
    private HBox pane_20;

    @FXML
    private HBox pane_22;

    @FXML
    private HBox pane_24;

    @FXML
    private ColorPicker studentColor_text;

    @FXML
    private TextField textField_studentName;


    Teacher_seating_chart_Model model = new Teacher_seating_chart_Model();

    // Create a Color Picker Control
    ColorPicker colorPicker_Default = new ColorPicker();


    public Label getErrorMsg(){
        return errorMsg;
    }
    public Label getLabels(int index) {
        Label[] labels = {
                label_01, label_03, label_05,
                label_11, label_13, label_15,
                label_21, label_23, label_25
        };
        return labels[index];
    }

    public HBox getPanes(int index) {
        HBox[] panes = {
                pane_00, pane_02, pane_04,
                pane_10, pane_12, pane_14,
                pane_20, pane_22, pane_24
        };
        return panes[index];
    }

    @FXML
    void onAddStudent(ActionEvent event) {
        errorMsg.setText("");
        String[] label_studentNames = {
                label_01.getText(), label_03.getText(), label_05.getText(),
                label_11.getText(), label_13.getText(), label_15.getText(),
                label_21.getText(), label_23.getText(), label_25.getText()
        };

        String[] panes_studentColors_BackgroundFill = {
                pane_00.getBackground().getFills().get(0).getFill().toString(), pane_02.getBackground().getFills().get(0).getFill().toString(), pane_04.getBackground().getFills().get(0).getFill().toString(),
                pane_10.getBackground().getFills().get(0).getFill().toString(), pane_12.getBackground().getFills().get(0).getFill().toString(), pane_14.getBackground().getFills().get(0).getFill().toString(),
                pane_20.getBackground().getFills().get(0).getFill().toString(), pane_22.getBackground().getFills().get(0).getFill().toString(), pane_24.getBackground().getFills().get(0).getFill().toString()
        };

        try {
            int random_result = model.process(textField_studentName.getText(), studentColor_text.getValue().toString(), label_studentNames, panes_studentColors_BackgroundFill, getErrorMsg());
            getLabels(random_result).setText(model.getStudentName());
            getLabels(random_result).setTextFill(studentColor_text.getValue());
            getPanes(random_result).setBackground(new Background(new BackgroundFill(studentColor_text.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
            studentColor_text.setValue(Color.WHITE);
        }
        catch (Exception e){
            errorMsg.setText(e.getMessage());
        }
    }

    public void onSelectColor(ActionEvent actionEvent) {
    }

}
