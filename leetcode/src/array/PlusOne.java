package array;

import java.util.Arrays;

public class PlusOne {
	
	public static void main(String[] args) {
		int A[] = {0};
		System.out.println(Arrays.toString(plusOne(A)));
	}
	
	public static int[] plusOne(int A[]) {
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] < 9) {
				A[i] += 1;
				return A;
			}
			A[i] = 0;
		}
		int over[] = new int[A.length + 1];
		over[0] = 1;
		return over;
	}
}
