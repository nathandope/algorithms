package dope.nathan.algorithms.methods.p3_divide_and_conquer.module6_homework.Merge_sort.task1;

import java.util.*;

/*
Пример реализации алгоритма Итеративной сортировки слиянием.
PS: для корректного подсчета инверсий необходимо увеличить массив до размера 2^n
путем добавлениея в его конец или начало каких-нибудь больших или маленьких чисел соответственно
 */
public class IterativeMergeSort {
//    private static long inversion = 0; // для подсчета инверсий

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

        System.out.println(Arrays.toString(iterativeMergeSort(inputArray)) + "\n");
//        System.out.println(inversion); // для подсчета инверсий
    }

    private static long[] iterativeMergeSort(long[] inputArray) {
        Queue<long[]> queue = new LinkedList<>();
        for (long anInputArray : inputArray) {
            queue.add(new long[]{anInputArray});
        }

        while (queue.toArray().length > 1) {
            printStep(queue);
            queue.add(merge(queue.poll(), queue.poll()));
        }
        return queue.poll();
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
//                inversion += leftArray.length - l; // для подсчета инверсий
                resultArray[i] = rightArray[r++];
            } else {
                resultArray[i] = leftArray[l++];
            }
        }
        return resultArray;
    }

    // визуализация процесса
    private static void printStep(Queue<long[]> queue) {
        for (long[] arraysQueue : queue) {
            System.out.print(Arrays.toString(arraysQueue) + " ");
        }
        System.out.println("\n");
    }

     public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new IterativeMergeSort().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}

