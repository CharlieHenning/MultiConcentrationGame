import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	public int GridSize;
	public  ArrayList<ArrayList<Tile>> gameGrid;
	public Logic logicClass;
	public Scanner s;
	public boolean gameFinished = false;
	
	public CLI(int gridSize){
		//Initalize the scanner
		s = new Scanner(System.in);
		//Set global variable for gridSize
		this.GridSize = gridSize;
		//Create an instance of the logic class
		 logicClass = new Logic();
		 //Create the game board
		gameGrid = logicClass.generateGrid(gridSize);
		//Welcome and rules are displayed
		System.out.println(welcomeMessage());
		
		System.out.println("To begin playing enter 'y', press anything else to see the directions again.");
		//startGame
		if(s.next().equals("y")){
			playGame();
		}
		else{
			System.out.println(welcomeMessage());
		}
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
			//Displays the game board
			displayGameGrid();

			//Take in user input
			try{
				//Propt user for first tile
				System.out.println("Please enter the number of first tile you would like to flip:");
				choice1 = s.nextInt();
				//Propt user for second tile
				System.out.println("Please enter the number of second tile you would like to flip:");
				choice2 = s.nextInt();
				if(choice1 == choice2){
					System.out.println("Please enter two different integers");
					goodInput = false;
				}
				if(!validSelection(choice1, choice2)){
					System.out.println("Please enter a value between 1 and " + GridSize*GridSize);
					goodInput = false;
				}
			}
			catch(InputMismatchException e){
				//incorrect input
				System.out.println("Please enter a valid integer.");
				goodInput = false;
			}
			if(goodInput && (choice1 != -1 && choice2 != -1)){
				if(!logicClass.evaluateMatch(getTile(choice1), getTile(choice2))){
					dsplyWrongGuessLtrs(choice1, choice2);
					delayGame();
					clearScreen();
				}
				gameFinished = logicClass.gameFinished(gameGrid);
			}
		
		}while(!gameFinished);
		
	}
	
	private boolean validSelection(int choice1, int choice2) {
		boolean c1Valid = false;
		boolean c2Valid = false;
		boolean valid = false;
		if(choice1 != choice2){
		for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary){
				if(t.ID == choice1){
					c1Valid = true;
					}
				if(t.ID == choice2){
					c2Valid = true;
				}
				}
			}
			valid = c1Valid && c2Valid;
		}
		return valid;
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
	
	public String welcomeMessage(){
		return "Welcome to the Concentration game! \n "
				+ "The rules are as follows: \n"
				+ "The screen will display a grid of Letters for a short period of time \n"
				+ "and then the screen will clear and the letters of the grid will be replaced with numbers. \n"
				+ "You must remeber where the matching numbers are and enter the corresponding numbers, one pair at a time. \n"
				+ "Enter the two numbers on the grid you would like to flip seperated by a space I.E.: 2 4 \n"
				+ "If the two places on the grid match the spots will display the letters you found. \n"
				+ "If the two places on the grid you selected do not match the letters will be shown briefly and then the \n"
				+ "grid will be redrawn.";
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
		for(int i=0; i< 50; i++)
			System.out.println("");
	}
	
	public void delayGame(){
		//Waits for 5 seconds
		try {
			Thread.sleep(5000);
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
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

