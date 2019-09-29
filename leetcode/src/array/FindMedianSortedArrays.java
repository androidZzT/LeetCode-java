package array;

public class FindMedianSortedArrays {
	public static void main(String[] args) {
		int nums1[] = { 1, 3 ,9};
		int nums2[] = { 2, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int nums1[], int nums2[]) {
		double median = 0;
		int merge[] = new int[nums1.length + nums2.length];
		int i = 0, j = 0;
		for (int k = 0; k < merge.length; k++) {
			if (i == nums1.length && j == nums2.length)
				break;

			if (i == nums1.length) {
				merge[k] = nums2[j];
				j++;
				continue;
			} else if (j == nums2.length) {
				merge[k] = nums1[i];
				i++;
				continue;
			}

			int left = nums1[i];
			int right = nums2[j];
			if (left < right) {
				merge[k] = left;
				i++;
			} else {
				merge[k] = right;
				j++;
			}
		}
		
		if (merge.length % 2 == 0) {
			median = (merge[merge.length / 2 - 1] + merge[merge.length / 2]) / 2.0d;
		} else {
			median = merge[(merge.length - 1) / 2];
		}
		return median;
	}
}
