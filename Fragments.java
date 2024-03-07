/**
 * Class holding the actual code fragments
 *
 * @author Lab Partner D.
 * @author n-c0de-r
 * @version 19.15.2021
 */
public class Fragments
{
    // Task 1.1: Methods of code fragments to be checked for Big-Ohs
    /**
     * Fragment to check for loop efficiency and execution times.
     * @param n Times of loops
     * @return  sum of all loop times as a long
     */
    public long fragmentOne(int n) {
        // Our guess O(n)
        // ChatGPT got it right - asked for Task 1.2
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
    public long fragmentTwo(int n) {
        // Our guess O(n*n)
        // ChatGPT got it right
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
    public long fragmentThree(int n) {
        /**
         * Our guess: O(n*n)/2 - j starts always at "i", so runs n/2
         * i runs to n always and multiplies the one before
         * ChatGPT says: (n * (n + 1)) / 2
         * Effectively it is O(n*n) or O(n^2)
         */
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
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
    public long fragmentFour(int n) {
        /**
         * Our guess: O(n*n)
         * ChatGPT: O(n) as the brackets are missing!
         * After informing it about that, it got O(n^2)
         */
        long sum = 0;
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
    public long fragmentFive(int n) {
        // Our guess O(n^3)
        // ChatGPT got it right

        long sum = 0;
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
    public long fragmentSix(int n) {
        // Same as Fragment 3 O(n*n)/2 -> O(n^2)
        // ChatGPT got it right
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
    public long fragmentSeven(int n) {
        // Our guess: O(n^3), even a bit more
        // ChatGPT got O(n^2)
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
    public long fragmentEight(int n) {
        // Our guess: O(log n)
        // ChatGPT got it right
        long sum = 0;
        int i = n;
        while (i > 1) {
            i = i / 2;
            sum++;
        }
        return sum;
    }

    /**
     * For the bored task: This is the so called Colltz Number.
     * Studets of Prof Zhang know this from Semester 1!
     */
    private int sequence (int n)
    {
        int sum = 0;
        int i = n;
        while (i > 1) {
            if (i%2 == 0) {  
                i = i/2;
            } else {  
                i = 3*i + 1;
            }
            sum++;
        }
        return sum;
    } 
}
