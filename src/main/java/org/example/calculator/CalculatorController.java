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
        if (calculator.addNumberToValue("0")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtn01(){
        if (calculator.addNumberToValue("1")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtn02(){
        if (calculator.addNumberToValue("2")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtn03(){
        if (calculator.addNumberToValue("3")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtn04(){
        if (calculator.addNumberToValue("4")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtn05(){
        if (calculator.addNumberToValue("5")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtn06(){
        if (calculator.addNumberToValue("6")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }

    }
    @FXML
    protected void onClickBtn07(){
        if (calculator.addNumberToValue("7")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtn08(){
        if (calculator.addNumberToValue("8")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
    }
    @FXML
    protected void onClickBtn09(){
        if (calculator.addNumberToValue("9")) {
            lblValueInput.setText(calculator.getValue());
            playSound("sound/press-key.mp3");
        }
        else{
            playSound("sound/error.mp3");
        }
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

    }

    protected void playSound(String path){
        Media sound = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

}