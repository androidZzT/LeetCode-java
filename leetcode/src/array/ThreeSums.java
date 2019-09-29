package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

    public static void main(String[] args) {
        int nums[] = new int[]{-2,0,0,2,2};
        System.out.println(threeSums(nums));
    }

    private static List<List<Integer>> threeSums(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) break; //当前数字大于0，退出循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重，与上次循环比
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left ++; //一次循环内去重
                    while (left < right && nums[right] == nums[right - 1]) right --;
                    left ++;
                    right --;
                }
                else if (sum > 0) right --;
                else if (sum < 0) left ++;
            }
        }
        return ans;
    }
}
