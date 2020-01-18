package com.company;

public class Solver {
    // declares variable of type grid
    Grid sudokuGrid;

    public Solver(Grid sudokuGrid){
        //initialize the grid
        this.sudokuGrid = sudokuGrid;
        solve();
    }

    private void solve(){
        //checks the element is intialized
        if(sudokuGrid.getGrid()[0][0]!=null){
            //calls recusive solve function with the first element of the puzzle
            if(!sudokuSolver(0,0)){
                System.out.println("");
                System.out.println("no solution");
            }else{
                //prints the final grid
                printFinalObjectGrid();
            }
        }
    }

    //elementinRow checks if an element already exist in the row(Passed in the contructor)
    //and returns a boolean value based on the result
    private boolean elementInRow(int row, String element){
        boolean result = true;
        for(int i = 0; i < sudokuGrid.getGridSize(); i++){
            if(sudokuGrid.getGrid()[i][row].getElementValue().equals(element)){
                result = false;
            }
        }
        return result;
    }

    //elementInCol method check if an element exists within a column and return a boolean value based on the result
    private boolean elementInCol(int col, String element){
        boolean result = true;
        for(int i = 0; i < sudokuGrid.getGridSize(); i++){
            if(sudokuGrid.getGrid()[col][i].getElementValue().equals(element)){
                result = false;
            }
        }
        return result;
    }

    //elementInGrid method checks if an element in a sub grid of the sudoku puzzle and returns a boolean based on the result
    //it determines the Starting grid point and sends it to the run grid method
    private boolean elementInGrid(int col,int row,String element){
        int subGridSize = (int)Math.sqrt(sudokuGrid.getGridSize());
        int StartCol = col - (col%subGridSize);
        int StartRow = row - (row%subGridSize);
        return runGrid(StartRow, StartCol,subGridSize,element);
    }

    //runGrid method checks if a particular element is in a grid from the start point to the end point of the grid
    private boolean runGrid(int startRow, int StartCol,int subGridSize,String element ){
        boolean result = true;
        for(int row = startRow; row < subGridSize+startRow; row++){
            for(int col = StartCol; col < subGridSize+StartCol; col++){
                if(sudokuGrid.getGrid()[col][row].getElementValue().equals(element)){
                    result = false;
                }
            }
        }
        return result;
    }
    //Checks is an element is valid and can be added to the grid
    private boolean isValid(int col, int row,String element){
        return elementInCol(col,element) && elementInRow(row,element) && elementInGrid(col,row,element);
    }

    //recusive backtracking method to solve the puzzle
    private boolean sudokuSolver(int row, int col){
        //checks if the row is full and moves to the next column
        if(row == sudokuGrid.getGridSize() && ++col == sudokuGrid.getGridSize()){
            return true;
        }
        //sets the full row to zero on the next line
        if(row == sudokuGrid.getGridSize()){
            row=0;
        }
        //if the element is not empty it moves to the next row
        if(!sudokuGrid.getGrid()[row][col].getElementValue().equals(".")){
            //recusive call on the next element
            return sudokuSolver(row+1,col);
        }

        // loop through the possible grid characters
        for(String element : sudokuGrid.getGridCharacters()){
            //checks if the element is valid
            if(isValid(row,col,element)){
                //set the element in the grid
                sudokuGrid.getGrid()[row][col].setElementValue(element);
                //recusive call on the next element
                if(sudokuSolver(row+1,col)) {
                    return true;
                }
            }
        }
        //backtracking if all possibilities fail
        sudokuGrid.getGrid()[row][col].setElementValue(".");
        return false;
    }

    //this function Prints out the puzzle from multi dimensional grid object
    public void printFinalObjectGrid(){
        for(int row = 0; row < sudokuGrid.getGridSize(); row++){
            System.out.println("");
            for(int col = 0; col < sudokuGrid.getGridSize(); col++){
                System.out.print(sudokuGrid.getGrid()[row][col].elementValue);
            }
        }
    }



}
