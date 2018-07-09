package dope.nathan.algorithms.data_structures.module2.task2;

import java.util.*;

public class Solution {

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Processor> processors = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            processors.add(new Processor(i));
        }

        StringBuilder log = new StringBuilder();
        int m = scanner.nextInt();
        for ( ;m > 0; m--) {
            Processor processor = processors.poll();
            log.append(processor.addTask(scanner.nextLong()));
            processors.add(processor);
        }
        scanner.close();
        System.out.println(log);
    }

    class Processor implements Comparable<Processor>{
        private final int number;
        private long releaseTime;

        Processor(int number) {
            this.number = number;
            releaseTime = 0;
        }

        String addTask(long taskDuration) {
            String shortLog = number + " " + releaseTime + "\n";
            releaseTime += taskDuration;
            return shortLog;
        }

        @Override
        public int compareTo(Processor p) {
            int result;
            result = Long.compare(releaseTime, p.releaseTime);
            if(result != 0) return result;
            result = Integer.compare(number, p.number);
            return result;
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
