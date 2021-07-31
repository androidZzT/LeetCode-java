package array.heap;

import java.util.*;
import array.Utils;

public class Heap {

    private int[] array;
    private int heapSize;

    private Heap() {}

    public static Heap buildMaxHeap(int[] arr) {
        Heap heap = new Heap();
        heap.array = arr;
        heap.heapSize = arr.length;
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            heap._maxHeapify(i);
        }
        return heap;
    }

    public int size() {
        return heapSize;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void maxHeapify(int[]arr, int i) {
        System.out.println("_maxHeapify i="+ i + ", size=" + arr.length);
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < arr.length && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < arr.length && arr[r] > arr[largest]) {
            largest = r;
        }
        System.out.println("_maxHeapify l="+ l + ", r="+r +", largest="+ largest + ", val=" + arr[largest]);
        if (largest != i) {
            Utils.swap(arr, i, largest);
            maxHeapify(arr, largest);
        }
    }

    public void _maxHeapify(int i) {
        System.out.println("_maxHeapify i="+ i + ", size=" + size());
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size() && array[l] > array[largest]) {
            largest = l;
        }
        if (r < size() && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i) {
            Utils.swap(array, i, largest);
            _maxHeapify(largest);
        }
    }

    public void heapSort() {
        int size = array.length;
        for (int i = size - 1; i > 0; i--) {
            Utils.swap(array, i, 0);
            heapSize --;
            _maxHeapify(0);
        }
    }

    private static int left(int i) {
        return (i << 1) + 1;
    }

    private static int right(int i) {
        return (i << 1) + 2;
    }

    private static int parent(int i) {
        return i >> 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 16, 8, 10 ,2, 1, 12};
        Heap max = Heap.buildMaxHeap(arr);
        System.out.print(max.toString());
    }

    //         3
    //      9    16
    //    8  10 2  1
    //  12  
    //
    //         |
    //         |
    //
    //        16
    //     10    3
    //   12  9  2  1
    //  8
}
