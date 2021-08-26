package net.dmly.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class ParallelArraySort {

    private static final int ELEMENTS_NUMBER = 100_000_000;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(">>> iter " + (i + 1));
            sortTest("sort", Arrays::sort);
            sortTest("parallelSort", Arrays::parallelSort);
            System.out.println("\n");
        }
    }

    private static void sortTest(String methodName, Consumer<double[]> sortMethod) {
        double[] array = createRandomArray(ELEMENTS_NUMBER);
        long startTime = System.currentTimeMillis();
        sortMethod.accept(array);
        long endTime = System.currentTimeMillis();
        System.out.println(methodName + "() took " + (endTime - startTime) + " ms");
    }

    private static double[] createRandomArray(int arrSize) {
        ThreadLocalRandom current = ThreadLocalRandom.current();

        double[] array = new double[arrSize];

        for (int i = 0; i < arrSize; i++) {
            array[i] = current.nextDouble();
        }

        return array;
    }
}
