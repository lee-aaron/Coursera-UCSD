import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    
    private static int getLastDigit(int n) {
    	if(n <= 1) return n;
    	int dig[] = new int[n+1];
    	dig[0] = 0;
    	dig[1] = 1;
    	int lastNum = 1;
    	for(int i = 2; i <= n; i++) {
    		dig[i] = (dig[i-1] + dig[i-2])%10;
    		lastNum = dig[i];
    	}
    	return lastNum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int c = getFibonacciLastDigitNaive(n);
        //System.out.println(c);
        System.out.println(getLastDigit(n));
    }
}

