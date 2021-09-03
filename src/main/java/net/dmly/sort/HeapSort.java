package net.dmly.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {3, 7, 1, 8, 2, 5, 9, 4, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] elements) {
        buildHeap(elements);

        for (int swapToPos = elements.length - 1; swapToPos > 0; swapToPos--) {
            //Move root to end
            ArrayUtils.swap(elements, 0, swapToPos);

            //Fix remaining heap
            heapify(elements, swapToPos, 0);
        }
    }

    public static void buildHeap(int[] elements) {
        // Find the last parent node
        int lastParentNode = elements.length / 2 - 1;

        //Heapify from last parent on backwards
        for (int i = lastParentNode; i >= 0; i--) {
            heapify(elements, elements.length, i);
        }
    }

    public static void heapify(int[] heap, int length, int parentPos) {
        while (true) {
            int leftChildPos = parentPos * 2 + 1;
            int rightChildPos = parentPos * 2 + 2;

            //Find the largest element
            int largestPos = parentPos;

            if (leftChildPos < length && heap[leftChildPos] > heap[largestPos]) {
                largestPos = leftChildPos;
            }

            if (rightChildPos < length && heap[rightChildPos] > heap[largestPos]) {
                largestPos = rightChildPos;
            }

            //largestPos is now either parentPos, leftChildPos or rightChildPos
            //If it's the parent - break
            if (largestPos == parentPos) {
                break;
            }

            //Switch parent and largest
            ArrayUtils.swap(heap, parentPos, largestPos);

            //store new parentPos
            parentPos = largestPos;
        }

    }

}


