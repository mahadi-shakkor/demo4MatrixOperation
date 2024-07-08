package com.oop.mahadi.demo4matrixoperation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Random;

public class MatOperationController {

    @FXML
    private ComboBox<String> ComboxFxid;

    @FXML
    private TextField M1CollumFxid;

    @FXML
    private TextField M2collumFxid;

    @FXML
    private TextField M2rowFxid;

    @FXML
    private TextField ValuFXid;

    @FXML
    private Label addValuShowFxidLavel;

    @FXML
    private TextField m1RowFxid;

    @FXML
    private TextArea textAreaFxidForshowalll;

    @FXML
    private RadioButton ma1TGFxid;

    @FXML
    private RadioButton m2TGFxid;

    int r, c;
    int currentRow, currentCol;

    @FXML
    public void initialize() {
        r = 0;
        c = 0;
        currentRow = 0;
        currentCol = 0;

        ComboxFxid.getItems().addAll("add", "sub", "inv", "tran");
        m2TGFxid.setDisable(true);
        ma1TGFxid.setDisable(true);
    }

    int itms;
    Matrix m1,m2;

    @FXML
    void AddButtonAction(ActionEvent event) {
        if (m1 == null) {
            r = Integer.parseInt(m1RowFxid.getText());
            c = Integer.parseInt(M1CollumFxid.getText());
            m1 = new Matrix(r, c);
            itms = r * c;
        }

        if (itms > 0) {
            m1.vals[currentRow][currentCol] = Integer.parseInt(ValuFXid.getText());
            itms--;

            // Update row and column indices
            currentCol++;
            if (currentCol == c) {
                currentCol = 0;
                currentRow++;
            }

            // Optionally, clear the input field

        }

        if (itms == 0) {
            // All elements have been added
            // Perform any needed final actions here
            // For example, disable the Add button or notify the user
            // AddButton.setDisable(true);
            textAreaFxidForshowalll.setText(m1.toString());
        }
    }

    @FXML
    void ComBoxOnAction(ActionEvent event) {
        if (!ComboxFxid.getValue().equals("tran")) {
            m2TGFxid.setDisable(true);
            ma1TGFxid.setDisable(true);
        } else {
            m2TGFxid.setDisable(false);
            ma1TGFxid.setDisable(false);
        }
    }

    @FXML
    void GenrateButtonONAction(ActionEvent event) {


        r = Integer.parseInt(M2rowFxid.getText());
        c = Integer.parseInt(M2collumFxid.getText());
        m2 = new Matrix(r, c);
        Random random = new Random();
        for (int i = 0; i < m2.vals.length; i++) {
            for (int j = 0; j < m2.vals[i].length; j++) {
                m2.vals[i][j] = random.nextInt(100); // Generate a random number between 0 and 99
            }
        }



      textAreaFxidForshowalll.setText(m2.toString());


    }
    String

    @FXML
    public void executeButtonOnaction(ActionEvent actionEvent) {

        if (ComboxFxid.getValue().equals("add")){
           textAreaFxidForshowalll.setText( m1.add(m2).toString());
        }
        if (ComboxFxid.getValue().equals("sub")){
            textAreaFxidForshowalll.setText(m1.sub(m2).toString());
        }
        if (ComboxFxid.getValue().equals("tran")){
            if (ma1TGFxid.isSelected()){
                textAreaFxidForshowalll.setText( m1.tran().toString());
            }
            else {
                textAreaFxidForshowalll.setText("select m1 radio button");
            }

            if (m2TGFxid.isSelected()){
                textAreaFxidForshowalll.appendText("\n"+ m2.tran().toString());
            }
            else {
                textAreaFxidForshowalll.setText("select m2 radio button");
            }

        }
        if (ComboxFxid.getValue().equals("inv")){
            textAreaFxidForshowalll.setText(m1.inv().toString());
        }

    }

    @FXML
    public void newM1buttononaction(ActionEvent actionEvent) {

        r = 0;
        c = 0;
        currentRow = 0;
        currentCol = 0;
        m1=null;
        m1RowFxid.clear();
        M1CollumFxid.clear();
        ValuFXid.clear();

    }

    @FXML
    public void saveTextF(ActionEvent actionEvent) {



    }
}
