
public class Main {

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

