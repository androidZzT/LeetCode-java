package array;

import java.util.HashSet;

public class ConsistantNumber {
	public static void main(String args[]) {
		int A[] = {1,2,3,4,222,334,55,1233,45};
		System.out.println(containsDuplicate(A));
	}
	
	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return set.size() != nums.length;
    }
}
