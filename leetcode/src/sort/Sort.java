package sort;

import java.util.Arrays;

public class Sort {
	double i = 1.0;
	/** 
     * 冒泡排序 
     *  
     * @param data 
     *            目标数组 
     */  
    public static void bubbleSort(int[] data) {  
    	if (data == null) return;
    	boolean flag = true;
        for (int i = 0; i < data.length && flag; i++) {// 控制趟数
        	flag = false;
            for (int j = data.length - 1; j > i; j--) {  
                if (data[j] > data[j - 1]) {  
                    int tmp = data[j];  
                    data[j] = data[j - 1];  
                    data[j - 1] = tmp; 
                    flag = true;
                }  
            }  
            System.out.println(Arrays.toString(data));
        }  
    }
    
    /** 
     * 选择排序 
     *  
     * @param data 
     *            目标数组 
     */  
    public static void selectSort(int[] data) {  
        if (data == null || data.length == 0) {  
            return;  
        }  
  
        for (int i = 0; i < data.length - 1; i++) {  
            int min = i;// 将当前下标定为最小值下标  
            for (int j = i + 1; j < data.length; j++) {  
                if (data[j] < data[min]) {  
                    min = j;  
                }  
            }  
  
            if (i != min) {  
                int tmp = data[i];  
                data[i] = data[min];  
                data[min] = tmp;  
            }  
            System.out.println(Arrays.toString(data));
        }  
    }  
    
    /**
     * 插入排序
     * @param nums
     */
    public static void insertionSort(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return;
    	}
    	for (int i = 1; i < nums.length; i++) {
    		int key = nums[i];
    		int j = i - 1;
    		while(j >= 0 && nums[j] < key) {
    			nums[j + 1] = nums[j];
    			j = j - 1;
    		}
    		nums[j + 1] = key;
    	}
    	System.out.println(Arrays.toString(nums));
    }
    
    public static void main(String[] args) {
		int[] a = {34,5,21,98,77,45,32,1,87};
//		bubbleSort(a);
		insertionSort(a);
	}
}
