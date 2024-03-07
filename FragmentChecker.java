import java.io.IOException;
import java.util.Arrays;

/**
 * This class checks the execution times of pre-defined code fragments.
 * The fragments loop a set amount of numbers and count each pass-through.
 * This is used to demonstrate the Big-Oh analysis in numbers.
 * 
 * @author Lab Partner D.
 * @author n-0de-r
 * @version 19.15.2021
 */

public class FragmentChecker {
    /**
     * Task 1.3:
     * loops through all fragment methods and runs them for a specific
     * set of times, returned values are sums of number of loop-throughs.
     */
    public static void main(String[] args) throws IOException {
        // Create a list of numbers to sum up, a million skipped for time saving!
        int[] numbers = { 10, 100, 1000, 10000, 100000 /*,1000000*/ };
        long[] frag1 = new long[numbers.length]; 
        long[] frag2 = new long[numbers.length]; //create empty lists
        long[] frag3 = new long[numbers.length]; 
        long[] frag4 = new long[numbers.length]; // for each fragment
        long[] frag5 = new long[numbers.length];
        long[] frag6 = new long[numbers.length]; // Here the sums of the
        long[] frag7 = new long[numbers.length];
        long[] frag8 = new long[numbers.length]; // respective runs get stored.
        
        Fragments fragments = new Fragments();
        
        //Run fragment one to eight, except 5 and 7
        for (int i = 0; i < numbers.length; i++) {
            frag1[i] = fragments.fragmentOne(numbers[i]);
            frag2[i] = fragments.fragmentTwo(numbers[i]);
            frag3[i] = fragments.fragmentThree(numbers[i]);
            frag4[i] = fragments.fragmentFour(numbers[i]);
            // 5 Takes like forever!
            frag6[i] = fragments.fragmentSix(numbers[i]);
            // 7 Takes like forever squared to finish!
            frag8[i] = fragments.fragmentEight(numbers[i]);
        }

        /**
         * Run fragment five and seven only a few of the designated times,
         * as it runs almost "endlessly", so to save time and estimate
         * our guesses, runs are limited, then print the results
         */
        for (int i = 0; i < 3; i++) {
            frag5[i] = fragments.fragmentFive(numbers[i]);
            frag7[i] = fragments.fragmentSeven(numbers[i]);
        }
        
        //Print all the sums in order. Takes time, be patient!
        System.out.println("The sums of nr 1 are: " + Arrays.toString(frag1));
        System.out.println("The sums of nr 2 are: " + Arrays.toString(frag2));
        System.out.println("The sums of nr 3 are: " + Arrays.toString(frag3));
        System.out.println("The sums of nr 4 are: " + Arrays.toString(frag4));
        System.out.println("The sums of nr 5 are: " + Arrays.toString(frag5));
        System.out.println("The sums of nr 6 are: " + Arrays.toString(frag6));
        System.out.println("The sums of nr 7 are: " + Arrays.toString(frag7));
        System.out.println("The sums of nr 8 are: " + Arrays.toString(frag8));
    }
}
