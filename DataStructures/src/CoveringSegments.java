import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
    	Arrays.sort(segments);
        List<Integer> points = new ArrayList<Integer>();
        int endPoint = segments[0].end;
        points.add(endPoint);
        // Check all end points; if current endpoint can be moved then add new endpoint
        for(int i = 0; i < segments.length; i++) {
        	if(endPoint < segments[i].start || endPoint > segments[i].end) {
        		endPoint = segments[i].end;
        		points.add(endPoint);
        	}
        }
        int[] res = new int[points.size()];
        for(int j = 0; j < res.length; j++) {
        	res[j] = points.get(j);
        }
        return res;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        // Returns if end is greater than seg.end (ascending order)
		public int compareTo(Segment seg) {
			int num = ((Segment) seg).end;
        	return this.end - num;
		}
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
