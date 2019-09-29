package array;

import java.util.Arrays;

public class RemoveZero {

	public static void main(String[] args) {
		int A[] = { 0, 1, 0, 3, 12 };
		moveZero(A);
	}

	public static void moveZero(int A[]) {
		int i = 0;
		int zeroCount = 0;
		while (i < A.length - zeroCount - 1) {
			int key = A[i];
			if (key == 0) {
				zeroCount++;
				for (int j = i + 1; j < A.length; j++) {
					A[j - 1] = A[j];
				}
				A[A.length - 1] = 0;
			} else {
				i++;
			}
		}
		System.out.println(Arrays.toString(A));
	}

	/**
	 * 当前指针所指数字为0，继续向后，如果不为0，和上一个0交换位置
	 * @param A
	 */
	public static void best(int A[]) {
		for (int i = 0, lastZeroIndex = 0; i < A.length; i++) {
			if (A[i] != 0) {
				int temp = A[i];
				A[i] = A[lastZeroIndex];
				A[lastZeroIndex] = temp;
				lastZeroIndex++;
			}
		}
	}
}
