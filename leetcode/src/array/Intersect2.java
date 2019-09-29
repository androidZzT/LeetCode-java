package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Intersect2 {
	public static void main(String args[]) {
		int A[] = {1 , 3, 2, 2, 4, 1};
		int B[] = {3, 6, 5, 4};
		System.out.println(Arrays.toString(intersect(A, B)));
	}
	
	public static int[] intersect(int A[], int B[]) {
		Arrays.sort(A);
		Arrays.sort(B);
		HashSet<Integer> set = new HashSet<>();
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				i++;
			} else if (A[i] > B[j]) {
				j++;
			} else {
				set.add(A[i]);
				i++;
				j++;
			}
		}
		int result[] = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		for (int k = 0; k < set.size(); k++) {
			if (it.hasNext()) {
				result[k] = it.next();
			}
		}
		return result;
	}
}
