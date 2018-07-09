package dope.nathan.algorithms.data_structures.module1.task5;

import java.util.*;

public class Solution {

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        scanner.close();
        
        QueueOfStacks queue = new QueueOfStacks(); // очередь из 2х стеков
        StringBuilder result = new StringBuilder();

        /*
        Пошаговый алгоритм ч1:
        добавим в очередь первые m элементов массива
        найдём в сформированной очереди максимум,
        добавим его к результату
         */
        for (int i = 0; i < m; i++) { queue.pushBack(ints[i]); }
        result.append(queue.getMax()).append(" ");

        /*
        Пошаговый алгоритм ч2:
        добавим в очередь следующий элемент массива,
        извлечём из очереди первый элемент массива,
        найдем максимум и добавим его к результату
         */
        for (int i = m; i < ints.length; i++) {
            queue.pushBack(ints[i]);
            queue.popFront();
            result.append(queue.getMax()).append(" ");
        }
        System.out.println(result);
    }

    private class QueueOfStacks {
        private Stack<Pair> pushStack = new Stack<>();
        private Stack<Pair> popStack = new Stack<>();

        // положить во "правый" стек пару (значение : максимум)
        private void pushBack(int element) {
            int max = pushStack.isEmpty() ? element : Math.max(element, pushStack.peek().max);
            pushStack.push(new Pair(element, max));
        }

        /*
        достать из "левого" стека пару (значение : максимум), если стек не пуст
        в противном случае из "правого" стека перенести все значения в "левый"
        и достать из него пару
        */
        private void popFront() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    int element = pushStack.pop().value;
                    int max = popStack.isEmpty() ? element : Math.max(element, popStack.peek().max);
                    popStack.push(new Pair(element, max));
                }
            }
            popStack.pop();
        }

        /*
        если "правый" стек пуст, то получить максимум из левого стека
        если "левый" стек пуст, то получить максимум из правого стека
        в противном случае найти наибольшие значение максимума в двух стеков
        */
        private int getMax() {
            if (pushStack.isEmpty() || popStack.isEmpty()) {
                return pushStack.isEmpty() ? popStack.peek().max : pushStack.peek().max;
            } else {
                return Math.max(pushStack.peek().max, popStack.peek().max);
            }
        }

        private class Pair {
            private final int value;
            private int max;

            Pair(int value, int max) {
                this.value = value;
                this.max = max;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
