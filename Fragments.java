import java.io.IOException;
import java.util.Arrays;

/**
 * This class checks the execution times of pre-defined code fragments.
 * The fragments loop a set amount of numbers and count each pass-through.
 * This is used to demonstrate the Big-Oh analysis in numbers.
 * 
 * @author Lab Partner D.
 * @author n-cßde-r
 * @version 19.15.2021
 *
 */

public class Fragments {

	public static void main(String[] args) throws IOException {
		checkFragments();
	}

	/**
	 * loops through all fragment methods and runs them for a specific set of times,
	 * returned values are sums of number of loop-throughs.
	 */
	private static void checkFragments() {
		int[] numbers = { 10, 100, 1000, 10000, 100000 }; // Create a list of numbers to sum up
		long[] frag1 = new long[5]; 
		long[] frag2 = new long[5]; //create empty lists
		long[] frag3 = new long[5]; 
		long[] frag4 = new long[5]; // for each fragment
		long[] frag5 = new long[5];
		long[] frag6 = new long[5]; // Here the sums of the
		long[] frag7 = new long[5];
		long[] frag8 = new long[5]; // respective runs get stored.
		
		//Run fragment one to eight, except 5 and 7
		for (int i = 0; i < numbers.length; i++) {
			frag1[i] = fragmentOne(numbers[i]);
			frag2[i] = fragmentTwo(numbers[i]);
			frag3[i] = fragmentThree(numbers[i]);
			frag4[i] = fragmentFour(numbers[i]);
			frag6[i] = fragmentSix(numbers[i]);
			frag8[i] = fragmentEight(numbers[i]);
		}

		//Run fragment five and seven only a few of the designated times, as it runs almost
		// "endlessly", so to save time and estimate our guesses, runs are limited, and print the results
		for (int i = 0; i < 3; i++) {
			frag5[i] = fragmentFive(numbers[i]);
			frag7[i] = fragmentSeven(numbers[i]);
		}
		
		//Print all the sums in order. Takes time, be patient!
		System.out.println("The sums of fragment nr 1 are: " + Arrays.toString(frag1));
		System.out.println("The sums of fragment nr 2 are: " + Arrays.toString(frag2));
		System.out.println("The sums of fragment nr 3 are: " + Arrays.toString(frag3));
		System.out.println("The sums of fragment nr 4 are: " + Arrays.toString(frag4));
		System.out.println("The sums of fragment nr 5 are: " + Arrays.toString(frag5));
		System.out.println("The sums of fragment nr 6 are: " + Arrays.toString(frag6));
		System.out.println("The sums of fragment nr 7 are: " + Arrays.toString(frag7));
		System.out.println("The sums of fragment nr 8 are: " + Arrays.toString(frag8));
		
	}

	//Methods of code fragments to be checked for Big-Ohs
	/**
	 * Fragment to check for loop efficiency and execution times.
	 * @param n Times of loops
	 * @return  sum of all loop times as a long
	 */
	private static long fragmentOne(int n) { // O(n)
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum++;
		}
		return sum;
	}

	/**
	 * Fragment to check for loop efficiency and execution times.
	 * @param n Times of loops
	 * @return  sum of all loop times as a long
	 */
	private static long fragmentTwo(int n) { // O(n*n)
		long sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * Fragment to check for loop efficiency and execution times.
	 * @param n Times of loops
	 * @return  sum of all loop times as a long
	 */
	private static long fragmentThree(int n) { // (n*n)/2 + n/2 - j startet immer bei it, dadurch geht er nur n/2 mal
		long sum = 0; 							// durch (Im Prinzip wird immer jede Zahl < i Ã¼bersprungen in der 2.
		for (int i = 0; i < n; i++) { 			// Schleife) // und durch die erste Schleife n mal, also n*n/2
			for (int j = i; j < n; j++) {		// Dabei geht der Code aber noch
				sum++;							
			}
		}
		return sum;
	}

	/**
	 * Fragment to check for loop efficiency and execution times.
	 * @param n Times of loops
	 * @return  sum of all loop times as a long
	 */
	private static long fragmentFour(int n) { // (n*n) + n, da der Code wie bei fragmentTwo quadratisch ist, aber dabei
		long sum = 0;						  // noch die Iteration zÃ¤hlt, bei der Sie n mal durch die erste Schleife geht
		for (int i = 0; i < n; i++) {
			sum++;
			for (int j = 0; j < n; j++) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * Fragment to check for loop efficiency and execution times.
	 * @param n Times of loops
	 * @return  sum of all loop times as a long
	 */
	private static long fragmentFive(int n) { // (n*n*n) da der Code durch die erste Schleife n mal geht,
		long sum = 0;						  // durch die zweite aben n*n Mal
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * n; j++) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * Fragment to check for loop efficiency and execution times.
	 * @param n Times of loops
	 * @return  sum of all loop times as a long
	 */
	private static long fragmentSix(int n) { // idk iwas in richtung n*n/2
		long sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * Fragment to check for loop efficiency and execution times.
	 * @param n Times of loops
	 * @return  sum of all loop times as a long
	 */
	private static long fragmentSeven(int n) { // idk iwas richtung n*n*n
		long sum = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n * n; j++) {
				if (j % i == 0) {
					for (int k = 0; k < j; k++) {
						sum++;
					}
				}
			}
		}
		return sum;
	}

	/**
	 * Fragment to check for loop efficiency and execution times.
	 * @param n Times of loops
	 * @return  sum of all loop times as a long
	 */
	private static long fragmentEight(int n) { // n/2^x = 1 -> n = 2^x -> x = log 2 zu n (dabei wird immer abgerundet)
		long sum = 0;
		int i = n;
		while (i > 1) {
			i = i / 2;
			sum++;
		}
		return sum;
	}
}
