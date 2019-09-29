package array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int nums[] = {-1, -2, -4, -3, -5};
		int target = -7;
		System.out.println(Arrays.toString(best(nums, target)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int i = 0, j = 0;
		while(i < nums.length) {
			j = i + 1;
			if (Math.abs(nums[i]) > Math.abs(target)) {
				i++;
			} else {
				while (j < nums.length) {
					if (nums[i] + nums[j] == target) {
						return new int[]{i, j};
					} else {
						j++;
					}
				}
				i++;
			}
		}
		return null;
	}
	
	public static int[] best(int nums[], int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[]{map.get(target - nums[i]), i};
			} else {
				map.put(nums[i], i);
			}
		}
		return null;
	}
}
