package net.dmly.sort;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MergeSortMeasurement {
    private static final int ITERATION_COUNT = 5;
    private static final int ITEM_COUNT = 10_000_000;

    public static void main(String[] args) {

        Stream.iterate(0, i -> i + 1)
                .limit(ITERATION_COUNT)
                .forEach(i -> {

                    System.out.println(">>>>>>> Iteration " + (i + 1));

                    Integer[] testData = generateTestData();

                    measure(testData, MergeSort::mergeSort2Wrapper, "mergeSort2");
                    measure(testData, MergeSort::mergeSort1, "mergeSort1");

                    System.out.println("----------------------------\n");

                });
    }

    private static Integer[] generateTestData() {
        Integer[] result = new Integer[ITEM_COUNT];

        Stream.iterate(0, i -> i + 1)
                .limit(ITEM_COUNT)
                .forEach(i -> {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    result[i] = random.nextInt();
                });

        return result;
    }

    private static void measure(Integer[] testData, Consumer<Integer[]> consumer, String name) {
        long start = System.currentTimeMillis();

        consumer.accept(testData);

        System.out.println(name + " duration: " + (System.currentTimeMillis() - start));
    }

}
