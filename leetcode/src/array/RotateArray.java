package array;

import java.util.Arrays;

/**
 *  输入: [-1,-100,3,99] 和 k = 2
	输出: [3,99,-1,-100]
	解释: 
	向右旋转 1 步: [99,-1,-100,3]
	向右旋转 2 步: [3,99,-1,-100]
 */
public class RotateArray {
	public static void main(String args[]) {
		int[] nums = {1,2,3,4,5}; 
//		embedLoop(nums, 2);
		reverse(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 *  时间复杂度 O（kn）
	 *  空间复杂度 O（1）
	 * @param nums
	 * @param k
	 */
	public static void embedLoop(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		for (int i = 0; i < k; i++) {
			int temp = nums[n - 1];
			for (int j = n - 1; j > 0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = temp;
		}
	}

	/**
	 * 时间复杂度 O（n）
	 * 空间复杂度 O（1）
	 * @param nums
	 * @param k
	 */
	public static void reverse(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}
	
	private static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp  = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
