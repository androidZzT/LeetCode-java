package array.heap;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, 16, 8, 10 ,2, 1, 12};
        Heap maxHeap = Heap.buildMaxHeap(arr);
        maxHeap.heapSort();
        System.out.println(maxHeap.toString());     
    }

    //        16
    //     10    3
    //   12  9  2  1
    //  8
    //         |
    //         |
    //         8
    //      10    3
    //   12   9  2  1
    // 16

}
