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
	public static void main(String[] args) {
		boolean allTestsPassed = ClassTest();

		if (allTestsPassed) {
			System.out.println("All tests successfully passed");
		} else {
			System.out.println("Some Test(s) failed");
		}
	}

}
