package net.dmly.sort;

import java.util.*;

public class CountingSort {

    public static void main(String[] args) {

        int[] sourceArray = {3, 7, 4, 6, 6, 3, 0, 3, 8, 6, 6, 9, 6, 2, 8};
        System.out.println(String.format("Original:   %s", Arrays.toString(sourceArray)));
        System.out.println(String.format("countSort1: %s", Arrays.toString(countSort1(sourceArray))));

    }

    public static int[] countSort1(int[] input) {
        Map<Integer, Integer> counterMap = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            var element = input[i];
            if (counterMap.containsKey(element)) {
                var counterValue = counterMap.get(element);
                counterMap.put(element, counterValue + 1);
            } else {
                counterMap.put(element, 1);
            }
        }

        int[] copy = Arrays.copyOf(input, input.length);

        int copyIndex = 0;
        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                copy[copyIndex] = entry.getKey();
                copyIndex++;
            }
        }

        return copy;
    }

}
