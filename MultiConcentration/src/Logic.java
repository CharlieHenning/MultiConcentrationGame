import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Logic {

	//Grid will have to be an even number of tiles, otherwise one tile will either be already visible, or un-solvable. 
	public List<Integer> ALLOWED_VALUES = Collections.unmodifiableList(Arrays.asList(2,4,6));
	
	
	//Ideas for the methods that will be required for a multi-concentation game:
	
	//Generate game board
		//Create a series of "tile" objects.
		//Tiles can be easily randomized by using ascii code to generate the letters used.
		// The loop may go as follows:
			//Create new Tile, 
			//Assign new number based on loop iterator
			//Assign a Char based on RNG set to iterate between 65 - 90 (inclusive) make sure the number can't be reused after 2 uses
	
	public Logic(int gridSize){
		
	}
	
	public static void main(String[] args) {
		boolean CLI = false;
		boolean GUI = false;
		int gridSize= -1;
	
		if(args.length > 1){
		
			if(args[0] != null){
				String s = args[0];
				if(s.equalsIgnoreCase("-ea")){
					//Enable Assertions
				}
				if(s.equalsIgnoreCase("-g") && CLI == false){
					GUI = true;
				}
				if(s.equalsIgnoreCase("-t") && GUI == false){
					CLI = true;
				}
			}
			else{
				System.out.println("Please enter at minimum: [-g|-t] and a size for the grid (2, 4, or 6)");
			}
			
			if(args[1] != null){
				String s = args[1];
				if(s.equalsIgnoreCase("-g") && CLI == false ){
					GUI = true;
				}
				else if(s.equalsIgnoreCase("-t") && GUI == false){
					CLI = true;
				}
				//If we have a good decision on the GUI or CLI we can evaluate the size as our second parameter (in the case that -ea is not enabled)
				else if((CLI == true||GUI == true)){
					if(s.equals("2")|| s.equals("4") || s.equals("6")){
						gridSize = Integer.parseInt(s);
					}
				}
			}
		}
		else{
			System.out.println("Please enter at minimum: [-g|-t] and a size for the grid (2, 4, or 6)");
		}
				
		if(args.length > 2){
		
			//If this arg is used we should only ever have a size int here.
			if(args[2] != null){
				String s = args[2];
				if((CLI == true||GUI == true) && (s.equals("2")|| s.equals("4") || s.equals("6"))){
					if(s.equals("2")|| s.equals("4") || s.equals("6")){
						gridSize = Integer.parseInt(s);
					}
				}
			}
				
			}
			if(CLI == false && GUI == false){
				System.out.println("Please enter a valid selection of either -g or -t in your command");
			}
			if(gridSize == -1){
				System.out.println("Please enter a valid grid size of 2, 4, or 6");
			}
			
			if((CLI == true ||GUI == true) && gridSize != -1){
				//Create the selected GUI or CLI with the specified valid grid size.
				if (CLI == true){
					CLI userInterface = new CLI(gridSize);
				}
				else if(GUI == true){
					GUI userInterface = new GUI(gridSize);
				}
					
			}

		
	}
}
