package array;

/**
 * 在一个二维数组中，每一行都按照从左到右递增，每一列都按照从上到下递增。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author Android_ZzT
 *
 */
public class FindNumberInMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 8, 9},
				   		  {2, 4, 9, 12},
				   		  {4, 7, 10, 13},
				   		  {6, 8, 11, 15},
				         };
		boolean result = find(matrix, 17);
		System.out.println("二维数组是否包含该数字：" + result);
	}
	
	public static boolean find(int[][] matrix, int number) {
		if (matrix == null) return false;
		boolean found = false;
		int row = 0;
		int column = matrix[0].length - 1;
		int val;
		while(row <= matrix.length - 1 && column >= 0) {
			val = matrix[row][column];
			if (val > number) {
				column--;
			} else if (val < number) {
				row++;
			} else {
				found = true;
				break;
			}
		}
		return found;
	}
}
