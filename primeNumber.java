import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * This class deals with prime numbers from Task 2.
 *
 * @author Lab Partner D.
 * @author n-c0de-r
 * @version 19.15.2021
 */
public class primeNumber {

    static long[] nums20 = new long[100]; 
    static long[] nums40 = new long[100];
    
    public static void main(String[] args) {
        
        generateRandom20bit();
        generateRandom40bit();

        long startNano = System.nanoTime();
        for (long i : nums20) {
            checkPrime(i);
        }
        System.out.println("It takes " + ((System.nanoTime()-startNano)/1000000000.0) + "s. to check the 20bit numbers." );
        
        startNano = System.nanoTime();
        for (long i : nums40) {
            checkPrime(i);
        }
        System.out.println("It takes " + ((System.nanoTime()-startNano)/1000000000.0) + "s. to check the 40bit numbers." );
        // checkPrime();
    }

    private static void checkPrime(long i) {
        //for (int i = 1; i < 100; i++) {
            //bitShift(i);
            if (isPrime(i)) {
                System.out.println(i + " is a prime.");
            }
        //}
    }

    /**
     * Task 2.a: Naive prime check
     * Worst case if n is a prime number: O(n)
     */
    private static boolean isPrime(long i) { 
        // Checks all numbers until n ( O(n) )
        for (long n = 2; n <= i / 2; n++) {
            // 1 can be skipped, it IS the quintessential prime.
            if (i % n == 0) {
                return false; // If a division succeeds = not prime
            }
        }
        return true; // All went through? Must be a prime!
    }
    
    /**
     * // Exercise 2-1 a) A bit better, not the best!
     */
    
    public boolean isPrimeBetter(long n) {
        if(n < 0) return false; // Just in case!
        
        // Only uneven may be prime, if n is even, why bother?
        if(n%2 == 0) return false;
        
        // No need to check below 3, they are all primes anyway
        // Also skip the evens (+=2), we checked them before
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            // Divisors repeat in mirrored order after the root!
            // So why check the same numbers again? Time waste!
            // Time complexity: O(sqrt(n)) - faster! - Task b)
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Task 2.c: Shifting bits and display the relation.
     * Task 2.d: O(log n) as every step halfs execution.
     */
    public static void bitShift(int n) {
        int b = 0;
        System.out.print("n is " + n + " | ");
        for (int i = 0; 0 < n; i++) {
            n = n >> 1; // shifts the lowest bit out, which is of value 1
                        // halfing the number that way, until its gone.
                        System.out.print("n is " + n + " | ");
            b++; // Every erased lowest bit stands for one position needed
                    // to represent that specific number n
        }
        System.out.println("b is " + b + "bits");
    }
    
    // For Task 2.e
    private static void generateRandom20bit() {
        for (int i = 0; i < 100; i++) {
            nums20[i] = (long) (524288 + (Math.random() * 1048575));
        }
    }
    
    private static void generateRandom40bit() {
        for (int i = 0; i < 100; i++) {
            nums40[i] = (long) (549755813888L + (Math.random() * 1099511627775L));
        }
    }
    
    /**
     * For the vored: The Sieve of Eratosthenes 
     */
    public static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n+1];

        // Initialize all numbers as prime
        for (int i = 1; i <= n; i++) {
            isPrime[i] = true;
        }

        // Mark the multiples of each prime number as non-prime
        // Divisors repeat in mirrored order after the root!
        // So why check the same numbers again? Time waste!
        for (int p = 3; p <= Math.sqrt(n); p+=2) {
            // We start at 3 and skip even numbers, as
            // only uneven can be prime, reduce time!
            if (isPrime[p]) { // Possible prime found
                // Eliminate its multiples
                for (int j = p * p; j <= n; j += p) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect the prime numbers
        List<Integer> primes = new ArrayList<>();
        primes.add(2); // Add 2 manually, as we skipped it
        // Also, that way we can skip evens again, which are
        // Technically still set to "true"!!!
        for (int i = 3; i <= n; i+=2) {
            // If they are still true, they are primes
            if (isPrime[i])  primes.add(i);
        }

        return primes;
        // Do a runtime calculation to see its speed!
    }
}
