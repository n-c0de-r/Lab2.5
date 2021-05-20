
public class primeNumber {

	public static void main(String[] args) {
		checkPrime();
	}

	private static void checkPrime() {

		for (int i = 1; i < 1000000; i++) {
			if (isPrime(i)) {
				System.out.println(i + " is a prime.");
			}
		}
	}

	public static boolean isPrime(int p) { // worst case if n is a prime number - running time would be n long
		for (int n = 2; n <= p/2; n++) {
			if (p % n == 0) {
				return false;
			}
		}
		return true;
	}
}
