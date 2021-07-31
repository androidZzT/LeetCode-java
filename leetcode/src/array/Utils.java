package array;

public class Utils {
    
    public static void swap(int[] nums, int i, int j) {
        System.out.println("swap i="+i + ",j="+j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
