package dope.nathan.algorithms.methods.p3_divide_and_conquer.module6_homework.Merge_sort.task1;

import java.util.Scanner;

// Пример реализации рекурсивного алгоритма Сортировки слиянием
public class MergeSort {
    private static long inversion = 0;

    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 2) {
            System.out.println(0);
            return;
        }

        long[] inputArray = new long[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = input.nextLong();
        }
        input.close();

        mergeSort(inputArray, 0, n - 1);
        System.out.println(inversion);
    }

    private static long[] mergeSort(long[] inputArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            return merge(
                    mergeSort(inputArray, left, center),
                    mergeSort(inputArray, center + 1, right)
            );
        } else {
            return new long[]{inputArray[left]};
        }
    }

    private static long[] merge(long[] leftArray, long[] rightArray) {
        int length = leftArray.length + rightArray.length;
        long[] resultArray = new long[length];
        for (int i = 0, l = 0, r = 0; i < length; i++) {
            if (l == leftArray.length) {
                resultArray[i] = rightArray[r++];
                continue;
            }
            if (r == rightArray.length) {
                resultArray[i] = leftArray[l++];
                continue;
            }
            if (leftArray[l] > rightArray[r]) {
                inversion += leftArray.length - l;
                resultArray[i] = rightArray[r++];
            } else {
                resultArray[i] = leftArray[l++];
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new MergeSort().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
