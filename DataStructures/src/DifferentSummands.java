import java.util.*;

public class DifferentSummands {
	
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int counter = 1;
        while(n > 0) {
        	if(n < counter) {
        		break;
        	}
        	if((n - counter ) <= counter) {
        		summands.add(n);
        	} else {
        		summands.add(counter);
        	}
        	n -= counter;
        	counter++;
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

