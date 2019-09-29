package array;

import java.util.Arrays;

public class SingleNumber {
	public static void main(String args[]) {
		int a[] = {2,2,5,5,3,4,4};
		System.out.println(singleNumber(a));
	}
	
	public static int singleNumber(int nums[]) {
		if (nums.length < 3) return nums[0];
		int result = nums[0] ^ nums[1];
        for (int i = 2; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
	}
}
