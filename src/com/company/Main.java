package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	//reads in the size of the grid
	System.out.println("Enter The Size Of The Grid");
	int size = input.nextInt();
	//reads a list of symbols
	System.out.println("Enter The List Of Symbols");
	String list = input.next();
	String[] inputpuzzle = new String[size];
	input.nextLine();
	System.out.println("Enter The Sudoku Puzzle");
	//read the entire puzzle in
	for(int i = 0; i < size; i++){
	    inputpuzzle[i] = input.nextLine();
    }
	String puzzle="";
        System.out.println("");
        for(String puzzleItem :inputpuzzle){
            System.out.println(puzzleItem);
            puzzle = puzzle + puzzleItem;
        }
	input.close();
        //create the grid object and the solver object then passes the grid to the solver
        Grid grid = new Grid(size,puzzle,list);
        Solver sudokuSolver = new Solver(grid);
    }
}
