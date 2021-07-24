package array;

import java.util.*;
/**
 * 获取下一个排列
 * 输入：nums = [1,2,3] 输出：[1,3,2]
 * 
 * 找到下一个比 1,2,3 大的数即 1,3,2
 * 
 * 输入：nums = [3,2,1] 输出：[1,2,3]
 * 如果当前已经最大，则输出排列中最小的数
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 2, 6, 3, 1};
        nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {
        //1. 找到第一个不是降序的数（从后向前找到第一个不是升序的数）
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i --;
        }
        //2. 找到第一个比 nums[i] 大的数 nums[j]，并交换
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j --;
            }
            Utils.swap(nums, i, j);
        }
        //3. 反转后面的序列（降序变升序，保证数字最小）
        reverse(nums, i + 1);
    }

    private static void reverse(int nums[], int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            Utils.swap(nums, left, right);
            left ++;
            right --;
        }
    }
}
