import java.io.IOException;


public class main {

    public static void main(String[] args) throws IOException {
        System.out.println(fragmentOne(10));

    }

    public static int fragmentOne(int n){                   // O(n)
        int sum = 0;
        for ( int i = 0; i < n; i ++) {
            sum++;
        }
        return sum;
    }

    public static int fragmentTwo(int n){                  // O(n*n)
        int sum = 0;
        for ( int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragmentThree(int n){              // (n*n)/2 + n/2 - j startet immer bei it, dadurch geht er nur n/2 mal durch (Im Prinzip wird immer jede Zahl < i Ã¼bersprungen in der 2. Schleife)
        int sum = 0;                                    // und durch die erste Schleife n mal, also n*n/2
        for ( int i = 0; i < n; i ++) {                 // Dabei geht der Code aber noch
            for (int j = i; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragmentFour(int n){              // (n*n) + n, da der Code wie bei fragmentTwo quadratisch ist, aber dabei noch die Iteration zÃ¤hlt, bei der Sie n mal durch die erste Schleife geht
        int sum = 0;
        for ( int i = 0; i < n; i ++) {
            sum++;
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragmentFive(int n){              // (n*n*n) da der Code durch die erste Schleife n mal geht, durch die zweite aber n*n mal
        int sum = 0;
        for ( int i = 0; i < n; i ++) {
            for (int j = 0; j < n*n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragmentSix(int n){              // idk iwas in richtung n*n/2
        int sum = 0;
        for ( int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int fragmentSeven(int n){            // idk iwas richtung n*n*n
        int sum = 0;
        for ( int i = 1; i < n; i ++) {
            for(int j = 0; j < n*n; j++){
                if(j % i == 0){
                    for(int k = 0; k < j; k++){
                        sum ++;
                    }
                }
            }
        }
        return sum;
    }

    public static int fragmentEight(int n){            // n/2^x = 1 -> n = 2^x -> x = log 2 zu n (dabei wird immer abgerundet)
        int sum = 0;
        int i = n;
        while(i > 1){
            i = i/2;
            sum++;
        }
        return sum;
    }
}
