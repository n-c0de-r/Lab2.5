public class primeNumber {
    public static boolean isPrime(int p){                  // worst case if n is a prime number - running time would be n long
        for(int n = 0; n <= p-1; n++){
            if(p%n == 0){
                return false;
            }
        } return true;
    }
}
