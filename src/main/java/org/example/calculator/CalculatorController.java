package org.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class CalculatorController {
    @FXML
    private Label lblValueStorage;
    @FXML
    private Label lblValueInput;
    Calculator calculator = new Calculator();
    @FXML
    protected void onClickBtnZero(){
        addNewNumber("0");
    }
    @FXML
    protected void onClickBtn01(){
        addNewNumber("1");
    }
    @FXML
    protected void onClickBtn02(){
        addNewNumber("2");
    }
    @FXML
    protected void onClickBtn03(){
        addNewNumber("3");
    }
    @FXML
    protected void onClickBtn04(){
        addNewNumber("4");
    }
    @FXML
    protected void onClickBtn05(){
        addNewNumber("5");
    }
    @FXML
    protected void onClickBtn06(){
        addNewNumber("6");
    }
    @FXML
    protected void onClickBtn07(){
        addNewNumber("7");
    }
    @FXML
    protected void onClickBtn08(){
        addNewNumber("8");
    }
    @FXML
    protected void onClickBtn09(){
        addNewNumber("9");
    }
    @FXML
    protected void onClickBtnDot() {
        if (!calculator.getValue().contains(".")) {
            if (calculator.addNumberToValue(".")) {
                lblValueInput.setText(calculator.getValue());
                playSound("sound/press-key.mp3");
            }
            else{
                playSound("sound/error.mp3");
            }
        }else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtnAC(){
        calculator.resetOperation();
        lblValueInput.setText("");
        lblValueStorage.setText("");

    }
    @FXML
    protected void onClickBtnEqual(){
        if (lblValueInput.getText() != "") {
            if (calculator.getOperator() != 'E') {
                playSound("sound/press-key.mp3");
                double result = calculator.calculateOperation();
                calculator.resetOperation();
                calculator.setValue(result + "");
                lblValueInput.setText(result + "");
                lblValueStorage.setText("");
            }
            else {
                playSound("sound/error.mp3");
            }
        }
        else {
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtnMinus() {
        if (calculator.getValue() == "") {
            calculator.setValue("-");
            lblValueInput.setText("-");
        }
        else if (calculator.getOperator() == 'E') {
            playSound("sound/press-key.mp3");
            calculator.setOperator('-');
            calculator.sendValueToStorage();
            lblValueStorage.setText(calculator.getStoredValue() + " -");
            lblValueInput.setText("");
        }
        else {
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtnPlus(){
        if (calculator.getValue() != "" && calculator.getOperator() == 'E') {
            playSound("sound/press-key.mp3");
            calculator.setOperator('+');
            calculator.sendValueToStorage();
            lblValueStorage.setText(calculator.getStoredValue() + " +");
            lblValueInput.setText("");
        }
        else {
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtnMultiplication(){
        if (calculator.getValue() != "" && calculator.getOperator() == 'E') {
            playSound("sound/press-key.mp3");
            calculator.setOperator('*');
            calculator.sendValueToStorage();
            lblValueStorage.setText(calculator.getStoredValue() + " x");
            lblValueInput.setText("");
        }
        else {
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtnDivision(){
        if (calculator.getValue() != "" && calculator.getOperator() == 'E') {
            playSound("sound/press-key.mp3");
            calculator.setOperator('÷');
            calculator.sendValueToStorage();
            lblValueStorage.setText(calculator.getStoredValue() + " ÷");
            lblValueInput.setText("");
        }
        else {
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtnPercentage(){
        if (calculator.getStoredValue() != "") {
            calculator.getPercentage();
            playSound("sound/press-key.mp3");
            lblValueInput.setText(calculator.getValue());
        }
        else {
            playSound("sound/error.mp3");
        }
    }

    protected void playSound(String path){
        Media sound = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    protected void addNewNumber(String number){
        if (calculator.addNumberToValue(number)) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }

}