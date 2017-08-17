import java.io.*;
import java.util.*;

public class Sorting {
	private static Random random = new Random();

	private static int[] partition3(int[] a, int l, int r) {
		// write your code here
		/*
		 * Key Idea: 
		 * for all l ≤ k ≤ m1 − 1, A[k] < x 
		 * for all m1 ≤ k ≤ m2 , A[k] = x 
		 * for all m2 + 1 ≤ k ≤ r , A[k] > x
		 */
		int x = a[l], m1 = l, m2 = l;
		for (int j = l + 1; j <= r; j++) {
			if (a[j] > x) continue;
			if (a[j] < x) {
				swap(a, m1, j);
				m1++;
			}
			swap(a, m2 + 1, j);
			m2++;
		}
		return new int[] { m1, m2 };
	}

	private static void swap(int[] a, int indexOne, int indexTwo) {
		int temp = a[indexOne];
		a[indexOne] = a[indexTwo];
		a[indexTwo] = temp;
	}

	private static int partition2(int[] a, int l, int r) {
		int x = a[l];
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] <= x) {
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[l];
		a[l] = a[j];
		a[j] = t;
		return j;
	}

	private static void randomizedQuickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int k = random.nextInt(r - l + 1) + l;
		int t = a[l];
		a[l] = a[k];
		a[k] = t;
		// use partition3
		int m[] = partition3(a, l, r);
		randomizedQuickSort(a, l, m[0] - 1);
		randomizedQuickSort(a, m[1] + 1, r);
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		randomizedQuickSort(a, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
