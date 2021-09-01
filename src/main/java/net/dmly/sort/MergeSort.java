package net.dmly.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] sourceArray = {3, 7, 1, 8, 2, 5, 9, 4, 6};
        System.out.println(String.format("Source array: %s", Arrays.toString(sourceArray)));
        System.out.println(String.format("mergeSort1:   %s", Arrays.toString(mergeSort1(sourceArray))));
        System.out.println(String.format("mergeSort2:   %s", Arrays.toString(mergeSort2Wrapper(sourceArray))));
    }

    public static Integer[] mergeSort1(Integer[] input) {

        if (input.length <= 1) {
            return input;
        }

        int middleIndex = (input.length - 1) / 2;

        int leftArraySize = middleIndex + 1;
        Integer[] leftArray = new Integer[leftArraySize];
        System.arraycopy(input, 0, leftArray, 0, leftArraySize);

        int rightArraySize = input.length - middleIndex - 1;
        Integer[] rightArray = new Integer[rightArraySize];
        System.arraycopy(input, middleIndex + 1, rightArray, 0, rightArraySize);

        return merge1(mergeSort1(leftArray), mergeSort1(rightArray));

    }

    public static Integer[] merge1(Integer[] leftArray, Integer[] rightArray) {

        Integer[] result = new Integer[leftArray.length + rightArray.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                result[resultIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < leftArray.length) {
            result[resultIndex] = leftArray[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < rightArray.length) {
            result[resultIndex] = rightArray[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return result;
    }

    public static Integer[] mergeSort2Wrapper(Integer[] input) {
        return mergeSort2(input, 0, input.length - 1);
    }

    public static Integer[] mergeSort2(Integer[] input, int left, int right) {
        if (left == right) {
            return new Integer[]{input[left]};
        }

        int middle = left + (right - left) / 2;

        Integer[] leftArray = mergeSort2(input, left, middle);
        Integer[] rightArray = mergeSort2(input, middle + 1, right);

        return merge2(leftArray, rightArray);
    }

    public static Integer[] merge2(Integer[] leftArray, Integer[] rightArray) {
        int leftLen = leftArray.length;;
        int rightLen = rightArray.length;

        Integer[] target = new Integer[leftLen + rightLen];

        int targetPos = 0;
        int leftPos = 0;
        int rightPos = 0;

        while (leftPos < leftLen && rightPos < rightLen) {
            int leftValue = leftArray[leftPos];
            int rightValue = rightArray[rightPos];

            if (leftValue <= rightValue) {
                target[targetPos++] = leftValue;
                leftPos++;
            } else {
                target[targetPos++] = rightValue;
                rightPos++;
            }
        }

        while (leftPos < leftLen) {
            target[targetPos++] = leftArray[leftPos++];
        }

        while (rightPos < rightLen) {
            target[targetPos++] = rightArray[rightPos++];
        }

        return target;
    }

}
