import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        numberOfInversions += merge(a, b, left, ave - 1, ave, right - 1);
        return numberOfInversions;
    }

    private static long merge(int[] a, int[] b, int l1, int h1, int l2, int h2) {
        int count = 0;
        int i = l1, j = l2, index = l1;
        while (i <= h1 && j <= h2) {  // ensure neither half is exhausted
            if (a[i] <= a[j])
                b[index++] = a[i++];  // BZ: must increase pointer once chosen
            else {
                count += h1 - i + 1;
                b[index++] = a[j++];
            }
        }
        // append the rest of non-empty entries to merged space
        for (int idx = i; idx <= h1; idx++) b[index++] = a[idx];
        for (int idx = j; idx <= h2; idx++) b[index++] = a[idx];
        // replace original array a by merged space b
        for (int idx = l1; idx <= h2; idx++) {
            a[idx] = b[idx];
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

