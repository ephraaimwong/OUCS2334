/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
public class Java1Review {
	
	public static double divide(double a, double b) {
		return a / b;
	}
	
	public static int divide(int a, int b) {
		return a / b;
	}
	
	public static boolean isDivisibleBy7(int a) {
		int tempVar = a % 7;
		if (tempVar == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String main(String a) {
		return("Overloaded main method was passed \"" + a + "\".");
	}
	
	public static int findMin(int a, int b, int c) {
		int tempVar = a;
//		int min = -1;
		int[] intList = {a, b, c};
		for (int i = 0 ; i < 3; i++) {
			if (intList[i] < tempVar) {
				tempVar = intList[i];
			}
		}
		return tempVar;	
	}
	
	public static int findMin(int[] array) {
		int tempVar = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < tempVar) {
				tempVar = array[i];
			}
		}
		return tempVar;
	}
	
	public static double average(int[] array) {
		double sum = 0;
		for (int i : array) {
			sum += i;
		}
		sum = sum / array.length;
		return sum;
	}
	
	public static String[] toLowerCase(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			strings[i]= strings[i].toLowerCase();
		}
		return strings;
	}
	
	public static String[] toLowerCaseCopy(String[] strings) {
		String[] stringsCopy = new String[strings.length];
		for (int i = 0; i < strings.length; i++) {
			stringsCopy[i]= strings[i].toLowerCase();
		}
		return stringsCopy;
	}
	
	public static void removeDuplicates(int[] array) {
		int[] arrayCopy = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		for (int idx = 0; idx < arrayCopy.length; idx++) {
			for (int j = 0; j < array.length;j++) {
				if (arrayCopy[idx] == array[j] && idx != j) {
					//idx != j so val in same index dont get compared
					array[j] = 0;
				}
				else {continue;}
			}
		}
		//printing to see if code works
//		for(int i = 0; i < arrayCopy.length; i++) {
//			System.out.println(i + " " + arrayCopy[i]);
//		}
	}
	

	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
	}

}
