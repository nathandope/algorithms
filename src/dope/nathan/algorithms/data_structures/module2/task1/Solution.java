package dope.nathan.algorithms.data_structures.module2.task1;

import java.util.Scanner;

public class Solution {

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        scanner.close();

        HeapBuilder heapBuilder = new HeapBuilder(ints);
        System.out.println(heapBuilder.count);
        if (heapBuilder.count > 0) System.out.println(heapBuilder.result);
    }

    private class HeapBuilder {
        private final int size;
        private int count;
        private StringBuilder result;
        private int[] heap;

        HeapBuilder(int[] ints) {
            size = ints.length - 1;
            count = 0;
            result = new StringBuilder();
            heap = buildHeap(ints);
        }

        // чиним свойство кучи с помощью просеивания вниз
        private int[] buildHeap(int[] ints) {
            for (int i = (size) / 2; i >= 0; i--) {
                siftDown(ints, i);
            }
            return ints;
        }

        // рекурсивное просеивание элемента вниз
        // (еще можно реализовать через цикл while)
        //
        private void siftDown(int[] ints, int i) {
            int minIndex = i;
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;

            if (((leftChild < size) ||
                    (leftChild == size)) &&
                    (ints[minIndex] > ints[leftChild])) {
                minIndex = leftChild;
            }

            if (((rightChild < size) ||
                    (rightChild == size)) &&
                    (ints[minIndex] > ints[rightChild])) {
                minIndex = rightChild;
            }

            if (i != minIndex) {
                // для выходного значения (см. условие)
                count++;
                result.append(i)
                        .append(" ").
                        append(minIndex).
                        append("\n");

                swap(ints, i, minIndex);
                siftDown(ints, minIndex); // рекурсия
            }
        }

        // меняем местами значения внутри массива
        private void swap(int[] ints, int i, int minIndex) {
            ints[i] = ints[i] + ints[minIndex];
            ints[minIndex] = ints[i] - ints[minIndex];
            ints[i] =  ints[i] - ints[minIndex];
        }

        int[] toArray() { return heap; }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}