package com.company;

public class SudokuElement {
    String elementValue;
    //constructor to initialize the sudoku element value
    SudokuElement(String value){
       this.elementValue = value;
    }
    //getter for the sudoku elements value
    public String getElementValue() {
        return elementValue;
    }
    //setter for the sudoku elements value
    public void setElementValue(String elementValue) {
        this.elementValue = elementValue;
    }
}
