package net.dmly.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        Integer[] sourceArray = {6, 2, 4, 9, 3, 7, 0, -2, 100, 18};
        System.out.println(String.format("Source array: %s", Arrays.toString(sourceArray)));

        Integer[] sorted1 = insertionSort1(sourceArray);
        System.out.println(String.format("Sorted array 1 : %s", Arrays.toString(sorted1)));

        Integer[] sorted2 = insertionSort2(sourceArray);
        System.out.println(String.format("Sorted array 2 : %s", Arrays.toString(sorted2)));
    }

    private static Integer[] insertionSort1(Integer[] input) {

        Integer[] sourceArray = Arrays.copyOf(input, input.length);

        for ( int notSortedIndex = 1; notSortedIndex < sourceArray.length; notSortedIndex++) {

            Integer notSortedItem = sourceArray[notSortedIndex];

            for (int i = notSortedIndex - 1; i >= 0; i--) {
                Integer sortedItem = sourceArray[i];

                if (sortedItem > notSortedItem && (i == 0 || sourceArray[i-1] < notSortedItem)) {
                    Integer[] buffer = new Integer[sourceArray.length];

                    int buffIndex = 0;
                    for (int j = 0; j < sourceArray.length; j++) {
                        if (j == i) {
                            buffIndex++;
                        }

                        if (j != notSortedIndex) {
                            buffer[buffIndex] = sourceArray[j];
                        } else {
                            buffIndex--;
                        }

                        buffIndex++;
                    }

                    buffer[i] = notSortedItem;

                    sourceArray = buffer;

                    break;
                }

            }

        }

        return sourceArray;
    }

    private static Integer[] insertionSort2(Integer[] input) {
        Integer[] sourceArray = Arrays.copyOf(input, input.length);

        for (int i = 1; i < sourceArray.length; i++) {
            int elementToSort = sourceArray[i];
            int j = i;

            while (j > 0 && elementToSort < sourceArray[j - 1]) {
                sourceArray[j] = sourceArray[j - 1];
                j--;
            }
            sourceArray[j] = elementToSort;
            boolean flag = true;
        }

        return sourceArray;
    }
}
