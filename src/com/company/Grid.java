package com.company;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private int gridSize;// variable to store the grid size
    private SudokuElement [][] grid; // stores the grid array
    private Set gridCharacters; //store the unique grid characters

    //initializes all the grid attributes and calls the build grid and read character methods while validating the grid
    public Grid(int size, String sudoku, String sudokuCharacters){

        gridSize = size;
        grid = new SudokuElement[gridSize][gridSize];
        gridCharacters = new HashSet<String>();
        if(sudokuCharacters.length() == gridSize && sudoku.length() == (size*size)){
            buildGrid(sudoku);
            readCharacters(sudokuCharacters);
        }else{
            System.out.println();
            System.out.println(sudoku.length());
            System.out.println("sudoku should be "+(size*size)+"characters");
        }
    }

    //builds the grid of objects from the String that was passed in
    private void buildGrid(String Sudoku){
        int count = 0;
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){

                grid[i][j] = new SudokuElement(Sudoku.substring(count,count+1));
                count = count + 1;
            }
        }
    }

    //Reads the Characters from the String that was passed to form a set of unique characters
    private void readCharacters(String sudokuCharacters){
        for(int i = 0;i < gridSize; i++){
            gridCharacters.add(sudokuCharacters.substring(i,i+1));
        }
    }
    //Prints the object Grid
    public void printFinalObjectGrid(){
        for(int row = 0; row < gridSize; row++){
            System.out.println("");
            for(int col = 0; col < gridSize; col++){
                System.out.print(grid[row][col].elementValue);
            }
        }
    }

    //Getter for Grid Size
    public int getGridSize() {
        return gridSize;
    }

    //Getter for Sudoku element grid
    public SudokuElement[][] getGrid() {
        return grid;
    }

    //Setter for Grid Size
    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    //Setter for CompleteGrid
    public void setGrid(SudokuElement[][] grid) {
        this.grid = grid;
    }

    //Getter for Grid Characters
    public Set<String> getGridCharacters() {
        return gridCharacters;
    }

    //Getter for Grid Characters
    public void setGridCharacters(Set gridCharacters) {
        this.gridCharacters = gridCharacters;
    }
}
