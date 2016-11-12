import java.util.ArrayList;

public class MultiConcentrationTester {

	
	public static boolean ClassTest(){
		boolean allTestsPassed = true;
		//Perform tests here
		GUI gui = new GUI(2);
		//Auto increment test case number
		int testCaseNumber = 1;

		//Example test case
		
		// Test Case 1
//		if (new BasicTokenizer("", " ", true).countTokens() == 0) {
//			System.out.println("Test Case " + testCaseNumber + " Passed");
//		} else {
//			allTestsPassed = false;
//			System.out.println("Test Case " + testCaseNumber + " Failed");
//		}
//		testCaseNumber++;
		
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
