package dope.nathan.algorithms.data_structures.module1.task2;

import java.util.*;

public class Solution {

    private Map<Integer, List<Integer>> tree;

    private int run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
            return 1;
        }

        tree = new HashMap<>();
        int root = 0;

        // считываем массив, заполняя "список смежности" ("список детей")
        // в виде карты, и попутно определяем корень дерева
        for (int i = 0; i < n; i++) {
            int next = scanner.nextInt();
            if (next == -1) {
                root = i;
                continue;
            }

            if (!tree.containsKey(next)) {
                tree.put(next, new ArrayList<>());
            }
            tree.get(next).add(i);
        }
        scanner.close();
        return root;
    }

    // рекурсивный алгоритм определения высоты дерева
    private int height(int root) {
        int height = 1;
        if (tree.containsKey(root)) {
            for (Integer i : tree.get(root)) {
                height = Math.max(height, height(i) + 1);
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.height(solution.run()));
    }
}
