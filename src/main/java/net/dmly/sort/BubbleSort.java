package net.dmly.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        Integer[] array = {6, 2, 4, 9, 3 ,7};
        System.out.println(String.format("Initial array: %s", Arrays.toString(array)));

        System.out.println(String.format("sorted1:       %s", Arrays.toString(bubbleSort1(array))));
        System.out.println(String.format("sorted2:       %s", Arrays.toString(bubbleSort2(array))));
    }

    private static Integer[] bubbleSort1(Integer[] input) {
        Integer[] sourceArray = Arrays.copyOf(input, input.length);

        for (int i = 0; i < sourceArray.length; i++) {
            boolean sorted = false;

            for (int j = 0; j < sourceArray.length - 1 - i; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    int buffer = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = buffer;
                    sorted = true;
                }
            }

            if (!sorted) {
                break;
            }
        }

        return sourceArray;
    }

    private static Integer[] bubbleSort2(Integer[] input) {
        Integer[] sourceArray = Arrays.copyOf(input, input.length);

        for (int max = sourceArray.length - 1; max > 0; max--) {
            boolean swapped = false;
            for (int i = 0; i < max; i++) {
                int left = sourceArray[i];
                int right = sourceArray[i + 1];
                if (left > right) {
                    sourceArray[i + 1] = left;
                    sourceArray[i] = right;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        return sourceArray;
    }
}
