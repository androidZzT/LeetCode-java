package array;

import java.util.Arrays;

/**
 * [1,2,3,1,2,2,1,3,3] -> [1,1,1,2,2,2,3,3,3]
 */
public class _1to3Sort {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,1,2,2,1,3,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right && arr[right] == 3) right--;
        while (left < right && arr[left] == 1) left++;

        for (int i = left; i < right; i++) {
            int cur = arr[i];

            if (cur == 1) {
                int temp = arr[left];
                arr[left] = cur;
                arr[i] = temp;
                left++;
            } else if (cur == 3) {
                int temp = arr[right];
                arr[right] = cur;
                arr[i] = temp;
                right--;
            }
        }
    }
}
