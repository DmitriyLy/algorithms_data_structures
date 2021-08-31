package net.dmly.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] sourceArray = {3, 4, 1, 5, 2, 8, 9, 7, 6};
        System.out.println(String.format("Initial array: %s", Arrays.toString(sourceArray)));

        System.out.println(String.format("Sorted 1:      %s", Arrays.toString(quickSort1(sourceArray))));

        quickSort2(sourceArray, 0, sourceArray.length - 1);
        System.out.println(String.format("Sorted 1:      %s", Arrays.toString(sourceArray)));
    }

    public static Integer[] quickSort1(Integer[] input) {
        if (input.length <= 1) {
            return input;
        }

        Integer[] sorted = new Integer[input.length];

        Integer[] leftArr = new Integer[input.length];
        int leftSize = 0;

        Integer[] rightArr = new Integer[input.length];
        int rightSize = 0;

        Integer pivotItem = input[input.length - 1];

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] < pivotItem) {
                leftArr[leftSize++] = input[i];
            } else {
                rightArr[rightSize++] = input[i];
            }
        }

        leftArr = quickSort1(removeEmptyItems(leftArr, leftSize));
        rightArr = quickSort1(removeEmptyItems(rightArr, rightSize));

        for (int i = 0; i < leftSize; i++) {
            sorted[i] = leftArr[i];
        }

        sorted[leftSize] = pivotItem;

        for (int i = 0; i < rightSize; i++) {
            sorted[i + leftSize + 1] = rightArr[i];
        }

        return sorted;
    }

    private static Integer[] removeEmptyItems(Integer[] array, int actualSize) {
        if (array.length == actualSize) {
            return array;
        }

        Integer[] shortened = new Integer[actualSize];
        System.arraycopy(array, 0, shortened, 0, actualSize);
        return shortened;
    }

    public static void quickSort2(Integer[] elements, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotPos = partition(elements, left, right);
        quickSort2(elements, left, pivotPos - 1);
        quickSort2(elements, pivotPos + 1, right);
    }

    private static int partition(Integer[] elements, int left, int right) {
        Integer pivot = elements[right];

        int i = left;
        int j = right - 1;

        while (i < j) {
            while (elements[i] < pivot) {
                i++;
            }

            while (j > left && elements[j] >= pivot) {
                j--;
            }

            if (i < j) {
                ArrayUtils.swap(elements, i, j);
                i++;
                j--;
            }
        }

        if (i == j && elements[i] < pivot) {
            i++;
        }

        if (!elements[i].equals(pivot)) {
            ArrayUtils.swap(elements, i, right);
        }

        return i;
    }

}
