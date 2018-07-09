package dope.nathan.algorithms.methods.p2_greedy_algorithms.module4_homework.Priority_queue.task1;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] req = reader.readLine().split(" ");
            switch (req[0]) {
                case "Insert":
                    priorityQueue.add(Integer.valueOf(req[1]));
                    break;
                case "ExtractMax":
                    if (!priorityQueue.isEmpty()) result.append(priorityQueue.poll()).append("\n");
                    break;
            }
        }
        reader.close();
        System.out.print(result);
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
