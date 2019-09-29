package array;

import java.util.Arrays;

public class RotateMatrix {
	public static void main(String[] args) {
		int matrix[][]  = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		rotateMatrix(matrix);
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static void rotateMatrix(int matrix[][]) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) { //翻转列
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
	}
}
