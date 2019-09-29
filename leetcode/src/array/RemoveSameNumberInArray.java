package array;

public class RemoveSameNumberInArray {
	public static void main(String args[]) {
		int[] a = {1,1,2,2,2,2,3};
		int result = removeDuplicates(a);
		System.out.println(result);
	}
	
	 public static int removeDuplicates(int[] nums) {
	        int start = 0;
	        for(int j = start + 1; j < nums.length; j++) {
	            if (nums[start] == nums[j]) continue;
	            nums[start+1] = nums[j]; 
	            start += 1;
	        }
	        if (start == 0) return 1;
	        return start + 1;
	 }
}

