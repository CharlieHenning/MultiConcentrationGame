import java.util.ArrayList;

public class MultiConcentrationTester {

	//Auto increment test case number
	public static int testCaseNumber = 1;
	
	public static boolean ClassTest(){
		boolean allTestsPassed = true;
		//Perform tests here
		
		// Test Case 1
//		try{
//				String[] args = {"-t", "1"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//
//		}
//		testCaseNumber++;
//		// Test Case 2
//		try{
//				String[] args = {"-t", "2"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//
//		}
//		testCaseNumber++;
//		// Test Case 3
//		try{
//				String[] args = {"-t", "3"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//
//		}
//		testCaseNumber++;
//		// Test Case 4
//		try{
//				String[] args = {"-t", "4"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//
//		}
//		testCaseNumber++;
//		// Test Case 5
//		try{
//				String[] args = {"-t", "5"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//
//		}
//		testCaseNumber++;
//		// Test Case 6
//		try{
//				String[] args = {"-t", "6"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//
//		}
//		testCaseNumber++;
//		// Test Case 7
//		try{
//				String[] args = {"-t", "7"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//
//		}
//		testCaseNumber++;
//		// Test Case 8
//		try{
//				String[] args = {"-t", "8"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//		
//		}
//		testCaseNumber++;
//		// Test Case 8
//		try{
//				String[] args = {"-t", "8"};
//			MultiConcentration.main(args);
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		}
//		catch(Exception e){
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//		
//		}
//		testCaseNumber++;
//		
//		
//		
		
		//Example of how to enter args into the main method of the "Main" class.
//		String[] args = {"-t", "2"};
//		Main.main(args);
		return allTestsPassed;
	}
	
	public static boolean CLILogicClassTest(){
		boolean testsPass = true;
		int testCaseNumber = 1;
		ArrayList<ArrayList<Tile>> testGrid1 = new Logic().generateGrid(2);
		//Coverage Tests
		{
		// Test Case 1
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize);
				System.out.println("Test Case " + testCaseNumber + " Passed");
	
			}catch (Exception e){
				System.out.println("Test Case " + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;

			// Test Case 2
			try{
				int _gridSize = 2;
				if(new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).validSelection(2, 3))
				System.out.println("Test Case " + testCaseNumber + " Passed");
				else
					System.out.println("Test Case " + testCaseNumber + " Failed");	
			}catch (Exception e){
				System.out.println("Test Case " + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
				
			// Test Case 3
			try{
				int _gridSize = 2;
				if(new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).getTile(_gridSize) != null)
				System.out.println("Test Case " + testCaseNumber + " Passed");
				else
					System.out.println("Test Case " + testCaseNumber + " Failed");
			}catch (Exception e){
				System.out.println("Test Case " + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			
			// Test Case 4
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).displayGameGrid();
				System.out.println("Test Case " + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("Test Case " + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			// Test Case 5
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).displayLetterGrid();
				System.out.println("Test Case " + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("Test Case " + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			// Test Case 6
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).clearScreen();
				System.out.println("Test Case " + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("Test Case " + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			// Test Case 7
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).delayGame();
				System.out.println("Test Case " + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("Test Case " + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			// Test Case 8
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).dsplyWrongGuessLtrs(_gridSize, _gridSize+1);
				System.out.println("Test Case " + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("Test Case " + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
		
		
		}
		
		//Bounds Tests
		{
			
			
			
		}
		
		return testsPass;
	}

	public static void main(String[] args) {
		boolean allTestsPassed = false;
		if(CLILogicClassTest())
			allTestsPassed= true; 

		if (allTestsPassed) {
			System.out.println("All tests successfully passed");
		} else {
			System.out.println("Some Test(s) failed");
		}
	}

}