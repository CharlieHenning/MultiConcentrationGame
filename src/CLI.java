import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.omg.CORBA.SystemException;

public class CLI {
	public int GridSize;
	public  ArrayList<ArrayList<Tile>> gameGrid;
	public Logic logicClass;
	public Scanner s;
	public boolean gameFinished = false;
	
	public CLI(int gridSize){
		//Boolean to quit the game
		boolean _quit = false;
		//Initalize the scanner
		s = new Scanner(System.in);
		//Set global variable for gridSize
		this.GridSize = gridSize;
		//Create an instance of the logic class
		 logicClass = new Logic();
		 //Create the game board
		gameGrid = logicClass.generateGrid(gridSize);
		
		do{
			//Welcome and rules are displayed
			System.out.println(logicClass.welcomeMessage());
			
			System.out.println("To begin playing enter 'y', 'q' to quit or anything else to see the directions again.");
			//startGame
			String input = s.nextLine();
			if(input.equalsIgnoreCase("y")){
				playGame();
			}
			else if(input.equalsIgnoreCase("q")){
				_quit = true;
			}
			
		}while(!_quit);
		
		System.exit(0);
	}
	
	public void playGame(){
		//Displays the letters of the grid
		displayLetterGrid();
		//Waits for 5 seconds
		delayGame();
		//Clears the console
		clearScreen();
		//GamePlay loop
		do{
			//local Vars for grid elements to evaluate
			int choice1 = -1; 
			int choice2 = -1;
			boolean goodInput = true;
			String input;
			//Displays the game board
			displayGameGrid();
			s.reset();
			//Take in user input
			try{
				
				//Propt user for first tile
				System.out.println("Please enter the number of the two tiles you would like to flip seperated by a space, R to restart, or Q to quit.");
				
				input = s.nextLine();
				if(input.equalsIgnoreCase("R"))
					newGame();
				if(input.equalsIgnoreCase("Q")){
					System.out.println("Goodbye.");
					System.exit(0);
				}
					
				String[] strgAry = input.split(" ");
					if(strgAry.length< 2){
						System.out.println("Please enter two valid integers");
						continue;
					}
					else if(strgAry.length == 2){
						//Get first int
						choice1 = Integer.parseInt(strgAry[0]);
						//Get second int
						choice2 = Integer.parseInt(strgAry[1]);
					}
					else{
						System.out.println("Please enter two valid integers");
						continue;
					}
				if(choice1 == choice2){
					System.out.println("Please enter two different integers");
					//Repeat loop if values are bad
					goodInput = false;
				}
				//See if values exist in the current set of IDs
				if(!validSelection(choice1, choice2)){
					System.out.println("Please enter a value between 1 and " + GridSize*GridSize);
					//repeat loop if values are bad
					goodInput = false;
				}
			}
			catch(InputMismatchException e){
				//incorrect input
				System.out.println("Please enter a valid integer.");
				goodInput = false;
			}
			//If input is good and we have valid  numbers entered proceed to evaluate the numbers
			if(goodInput && (choice1 != -1 && choice2 != -1)){
				//Check for match
				if(!logicClass.evaluateMatch(getTile(choice1), getTile(choice2))){
					//If they don't match
					System.out.println("Sorry, it looks like those two don't match!");
					//Show game board with the wrong guesses as letters
					dsplyWrongGuessLtrs(choice1, choice2);
					//time delay
					delayGame();
					//clear the screen
					clearScreen();
				}
				//Update the value of game finished
				gameFinished = logicClass.gameFinished(gameGrid);
			}		
			//If game is not finished repeat loop
		}while(!gameFinished);
			displayGameGrid();
		System.out.println("Congratulations! You Win!");
			System.out.println("If  you'd like to play again enter 'y' press anything else to quit");
			if(s.nextLine().equalsIgnoreCase("y")){
				newGame();
			}
			else{
				System.out.println("Thanks for playing!");
			}
		System.exit(0);
	}
	
	private boolean validSelection(int choice1, int choice2) {
		return (choice1>= 1 && choice1 <= GridSize*GridSize) && (choice2 >= 1 && choice2 <= GridSize*GridSize);
	}

	public Tile getTile(int tileID){
		Tile tempTile = null;
		for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary){
				if(t.ID == tileID){
					tempTile = t;
					break;
				}
			}
			if(tempTile != null)
				break;
		}
		return tempTile;
	}
	
	public void displayGameGrid(){
		if(gameGrid != null){
			for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary){
				if(t.matchFound){
					System.out.print(t.Letter+ "  ");
				}
				else{
					System.out.print(t.ID + "  ");
				}
			}
				System.out.println("");
			}
		}
	}
	
	public void displayLetterGrid(){
		if(gameGrid != null){
			for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary)
				System.out.print(t.Letter + "  ");
			
			System.out.println("");
			}
		}
	}
	
	public void clearScreen(){
		for(int i=0; i< 150; i++)
			System.out.println("");
	}
	
	public void delayGame(){
		//Waits for 10 seconds
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void dsplyWrongGuessLtrs(int choice1, int choice2){
		for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary){
				if(t.ID == choice1 || t.ID == choice2){
					System.out.print(t.Letter + "  ");
				}
				else{
					System.out.print(t.ID + "  ");
				}
			}
				System.out.println("");
			}
		
	}
	public void newGame(){
		CLI newGame = new CLI(GridSize);
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

