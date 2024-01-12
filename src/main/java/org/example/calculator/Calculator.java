package org.example.calculator;

public class Calculator {

    private String value;
    private char operator;
    private String storedValue;

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public java.lang.String getStoredValue() {
        return storedValue;
    }

    public Calculator() {
        this.value = "";
        this.operator = 'E'; //Empty
        this.storedValue = "";
    }

    public java.lang.String getValue() {
        return value;
    }

    public void setValue(java.lang.String value) {
        this.value = value;
    }


    public boolean addNumberToValue(String x) {
        if (value.length() < 10) {
            this.value += x;
            return true;
        }
        return false;
    }

    public void resetOperation() {
        this.value = "";
        this.operator = 'E'; //Empty
        this.storedValue = "";
    }

    public void sendValueToStorage() {
        this.storedValue = this.value;
        this.value = "";
    }

    public char getOperator() {
        return operator;
    }

    public double calculateOperation() {
        double value = Double.parseDouble(this.value);
        double storedValue = Double.parseDouble(this.storedValue);
        switch (this.operator) {
            case '-':
                return storedValue - value;
            case '+':
                return storedValue + value;
            case '*':
                return storedValue * value;
            case '÷':
                return storedValue / value;
            default:
                return 0;
        }
    }

    public void getPercentage(){
        double value = Double.parseDouble(this.value);
        double storedValue = Double.parseDouble(this.storedValue);
        double result = storedValue * (value/100);
        this.value = result + "";
    }
}
