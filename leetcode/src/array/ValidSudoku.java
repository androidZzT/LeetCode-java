package array;

import java.util.HashMap;

public class ValidSudoku {
	public static void main(String[] args) {
		char[][] sudoku = new char[][] { 
				    { '5', '3', '3', '.', '7', '.', '.', '.', '.' },
					{ '6', '8', '.', '1', '9', '5', '.', '.', '.' }, 
					{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
					{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
					{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
					{ '8', '.', '.', '.', '2', '.', '.', '.', '6' },
					{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
					{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
					{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
				};
		System.out.println(isValidSudoku(sudoku));
	}

	public static boolean isValidSudoku(char[][]sudoku){
		//init
		HashMap<Character, Integer>[] rows = new HashMap[9]; 
		HashMap<Character, Integer>[] columns = new HashMap[9]; 
		HashMap<Character, Integer>[] matrixs = new HashMap[9]; 
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashMap<>();
			columns[i] = new HashMap<>();
			matrixs[i] = new HashMap<>();
		}
		
		for (int c = 0; c < 9; c++) { //逐行遍历
			for (int r = 0; r < 9 ;r++) {
				char n = sudoku[c][r];
				if (n != '.') {
					int matrixIndex = r/3 + (c/3) * 3;
					rows[r].put(n, rows[r].getOrDefault(n, 0) + 1);
					columns[c].put(n, columns[c].getOrDefault(n, 0) + 1);
					matrixs[matrixIndex].put(n, matrixs[matrixIndex].getOrDefault(n, 0) + 1);
					
					if (rows[r].get(n) > 1 || columns[c].get(n) > 1 || matrixs[matrixIndex].get(n) > 1) {
						System.out.println("duplicate number is " + n);
						System.out.println("row" + r);
						System.out.println("column" + c);
						return false;
					}
				}
			}
		}
		return true;
	}
}
