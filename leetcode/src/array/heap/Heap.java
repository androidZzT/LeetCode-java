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
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
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

    private void _maxHeapify(int i) {
        System.out.println("_maxHeapify i="+ i);
        int l = left(i);
        int r = right(i);
        System.out.println("l="+ l + ", r="+r);
        int largest = i;
        if (l < size() && array[l] > array[i]) {
            largest = l;
        }
        if (r < size() && array[r] > array[i]) {
            largest = r;
        }
        System.out.println("largest="+ largest);
        if (largest != i) {
            Utils.swap(array, i, largest);
            _maxHeapify(largest);
        }
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {
        return (i << 1) + 2;
    }

    private int parent(int i) {
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
