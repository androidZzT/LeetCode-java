package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int nums[] = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 10, 3, 5, 4, 9};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int pivot = nums[left];

        while (i != j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i];
        nums[i] = pivot;
        nums[left] = temp;

        quickSort(nums, left, i);
        quickSort(nums, i + 1, right);
    }
}
