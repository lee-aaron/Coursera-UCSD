import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
    	int count = 0;
    	while(m > 0) {
    		if(m >= 10) {
    			m -= 10;
    			count++;
    		} else if(m >= 5) {
    			m -= 5;
    			count++;
    		} else {
    			m--;
    			count++;
    		}
    	}
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

