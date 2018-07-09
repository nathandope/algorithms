package dope.nathan.algorithms.methods.p2_greedy_algorithms.module4_homework.Introdaction.task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int res = 0;
        for (int i = 1; res < n; i++) {
            res += i;
            arrayList.add(i);
        }

        if (res > n) {
            arrayList.remove(arrayList.indexOf(res-n));
        }

        System.out.println(arrayList.size());
        System.out.println(arrayList.toString().replaceAll("[\\[\\],]", ""));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Solution().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
