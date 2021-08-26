package net.dmly.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        Integer[] array = {6, 2, 4, 9, 3 ,7};
        System.out.println(String.format("Initial array: %s", Arrays.toString(array)));

        Integer[] sorted1 = selectionSort1(array);
        System.out.println(String.format("sorted1: %s", Arrays.toString(sorted1)));

    }

    private static Integer[] selectionSort1(Integer[] input) {
        Integer[] source = Arrays.copyOf(input, input.length);
        int minIndex;
        for (int i = 0; i < source.length; i++) {
            minIndex = i;
            for (int j = i; j < source.length; j++) {
                if (source[j] < source[minIndex]) {
                    minIndex = j;
                }
            }

            Integer buffer = source[i];
            source[i] = source[minIndex];
            source[minIndex] = buffer;
        }

        return source;
    }

}