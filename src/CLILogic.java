import java.util.ArrayList;

/*
 * Logic class that serves only the CLI interface.
 */
public class CLILogic {
	private ArrayList<ArrayList<Tile>> gameGrid;
	private int gridSize;
	public CLILogic(){}
	public CLILogic(ArrayList<ArrayList<Tile>> gameGrid, int gridSize){
		this.gameGrid = gameGrid;
		this.gridSize = gridSize;
	}
	/*
	 * Valid selection inspects the two integers passed to it
	 * returns true if the two integers are within the bounds of the grid and false if they are not.
	 */
	public boolean validSelection(int choice1, int choice2) {
		return (choice1>= 1 && choice1 <= gridSize*gridSize) && (choice2 >= 1 && choice2 <= gridSize*gridSize);
	}
	/*
	 * Searches for a tile object based on its integer ID in relation to the int passed in.
	 * returns the tile object if one that matches is found.
	 */
	public Tile getTile(int tileID){
		Tile tempTile = null;
		for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary){
				if(t.ID == tileID){
					tempTile = t;
					break;
				}
			}
		}
		return tempTile;
	}
	/*
	 * Prints the game grid based on the current state of the "MatchFound" boolean
	 * if a match has been found the method prints the letter, if no match has been
	 * found the ID number will be printed.
	 */
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
	/*
	 * Displays all of the letters for the tiles in the game grid on the console.
	 */
	public void displayLetterGrid(){
		if(gameGrid != null){
			for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary)
				System.out.print(t.Letter + "  ");
			
			System.out.println("");
			}
		}
	}
	/*
	 * prints 25 new lines to clear the command line.
	 */
	public void clearScreen(){
		for(int i=0; i< 25; i++)
			System.out.println("");
	}
	/*
	 * Halts the program from executing for 10 seconds per the game instructions
	 */
	public void delayGame(){
		//Waits for 10 seconds
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/*
	 * If the user does not correctly select two tiles this function will display the incorrectly
	 * guessed tile's letter value.
	 * Should be used in conjunction with delayGame() so the answer is not continually displayed
	 */
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
	/*
	 *Creates a new instance on the CLI class to restart the game. 
	 */
	public void newGame(){
		CLI newGame = new CLI(gridSize);
	}
	/*
	 * Class that tests all of the methods in this CLILogic.java file.
	 */
}
