package sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String args[]) {
		int A[] = {5,2,4,7,1,3,2,6};
		mergeSort(A);
	}
	
	private static void mergeSort(int nums[]) {
		int start = 0;
		int end = nums.length - 1;
		mergeRecurse(nums, start, end);
		System.out.println(Arrays.toString(nums));
	}
	
	private static void mergeRecurse(int nums[], int start, int end) {
		System.out.println("start:" + start + " end:" + end);
		
		if (start < end) {
			int q = (start + end) / 2;
			mergeRecurse(nums, start, q);
			mergeRecurse(nums, q + 1, end);
			merge(nums, start, q , end);
		}
	}
	
	private static void merge(int nums[], int start, int q, int end) {
		System.out.println("start:" + start + " q:"+ q + " end:" + end);

		int n1 = q - start + 1;
		int n2 = end - q;
		int left[] = new int[n1]; //+1 留出哨兵位置
		int right[] = new int[n2];
		
		for (int i = 0; i < n1 ;i++) {
			left[i] = nums[start + i];
		}
		
		for (int j = 0; j < n2; j++) {
			right[j] = nums[q + j];
		}
		
		left[n1 - 1] = Integer.MAX_VALUE; //哨兵应为正无穷大
		right[n2 - 1] = Integer.MAX_VALUE;
		
		System.out.println("left: "+Arrays.toString(left));
		System.out.println("right: "+Arrays.toString(right));
		
		int i = 0, j = 0;
		for (int k = start; k < end; k++) {
			if (left[i] <= right[j]) {
				nums[k] = left[i];
				i++;
			} else {
				nums[k] = right[j];
				j++;
			}
		}
	}
}
