package net.dmly.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class QuicksortMeasurement {
    private static final int ITEM_COUNT = 1000_000;
    private static final int ITERATION_COUNT = 5;

    public static void main(String[] args) {

        Stream.iterate(0, i -> i + 1)
                .limit(ITERATION_COUNT)
                .forEach(i -> {
                    System.out.println(">>>>>>>> Iteration: " + (i + 1));
                    Integer[] array = generateArray();

                    long start = System.currentTimeMillis();

                    Integer[] sorted = QuickSort.quickSort1(array);

                    System.out.println("quickSort1 duration: " + (System.currentTimeMillis() - start));

                    start = System.currentTimeMillis();

                    QuickSort.quickSort2(array, 0, array.length - 1);
                    System.out.println("quickSort2 duration: " + (System.currentTimeMillis() - start));

                    System.out.println("___________________________");
                });

    }

    private static Integer[] generateArray() {

        Integer[] array = new Integer[ITEM_COUNT];
        ThreadLocalRandom random = ThreadLocalRandom.current();

        Stream.iterate(0, i -> i + 1)
                .limit(ITEM_COUNT)
                .forEach(i -> array[i] = random.nextInt());

        return array;
    }

}
