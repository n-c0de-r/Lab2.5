import java.util.Arrays;

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

	private static boolean isPrime(long i) { // worst case if n is a prime number - running time would be n long
		for (long n = 2; n <= i / 2; n++) {
			if (i % n == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void bitShift(int n) {
		int b = 0;
		System.out.print("n is " + n + " | ");
		for (int i = 0; 0 < n; i++) {
			n = n >> 1; // shifts the lowest bit out, which is of value 1
						// decreasing the number by 1 that way, until its gone.
			b++; // Every erased lowest bit stands for one position needed
					// to represent that specific number n
		}
		System.out.println("b is " + b + "bits");
	}
	
	private static void generateRandom20bit() {
		for (int i=0; i<100; i++) {
			nums20[i] = (long) (524288 + (Math.random() * 1048575));
		}
	}
	
	private static void generateRandom40bit() {
		for (int i=0; i<100; i++) {
			nums40[i] = (long) (549755813888L + (Math.random() * 1099511627775L));
		}
	}
}
