package array;

import java.util.ArrayList;
import java.util.Iterator;

public class PrintMatrix {
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		int p = matrix.length - 1, q = matrix.length - 1;
		while (j <= q) {
			list.add(matrix[i][j]);
			j++;
		}
		while (i < p) {
			i++;
			list.add(matrix[i][j]);
		}
		while (j >= 0) {
			j--;
			list.add(matrix[i][j]);
		}
		while (i > 0) {
			i--;
			list.add(matrix[i][j]);
		}
		return list;
	}
	
	static int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	public static void main(String[] args) {
		System.out.println(printMatrix(matrix));
	}
}
