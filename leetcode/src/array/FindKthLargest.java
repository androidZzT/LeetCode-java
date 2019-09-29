package array;

import sort.QuickSort;

import java.util.Arrays;

public class FindKthLargest {

    public static void main(String[] args) {
        int nums[] = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }

    private static int findKthLargest(int[] nums, int k) {
        QuickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }
}
