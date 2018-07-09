package dope.nathan.algorithms.methods.p2_greedy_algorithms.module4_homework.Introdaction.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
// todo
public class NoSolution {

    StringBuilder result;

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();

        TreeSet<Segment> segments = new TreeSet<>();
        Stack<Segment> segmentStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            segments.add(new Segment(scanner.nextInt(), scanner.nextInt()));
        }

        result = new StringBuilder();
        for (Segment segment : segments) {
            if (segmentStack.isEmpty()) {
                segmentStack.push(segment);
//                System.out.println("1 :" + segmentStack.toString());
            } else {
                if ((segmentStack.peek().right > segment.left || segmentStack.peek().right == segment.left) &&
                        (segmentStack.peek().right < segment.right || segmentStack.peek().right == segment.right)) {
//                segmentStack.peek().marker = true;
//                segmentStack.push(segment).marker = true;
                    result.append(segmentStack.pop().right).append(" ");
//                    System.out.println("2 :" + Arrays.toString(segmentStack.toArray()));
                } else {
                    segmentStack.push(segment);
//                    System.out.println("3 :" + Arrays.toString(segmentStack.toArray()));
                }
            }
        }

//        for (Segment segment : segments) {
//            System.out.println(segment.left + " " + segment.right);
//        }

        System.out.println(result);
    }

    class Segment implements Comparable<Segment>{
        private int left;
        private int right;
        private boolean marker;

        Segment(int left, int right) {
            this.left = left;
            this.right = right;
            marker = false;
        }

        @Override
        public int compareTo(Segment s) {
            int result;
//            result = Integer.compare(left, s.left);
//            if(result != 0) return result;
            result = Integer.compare(right, s.right);
            return result;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new NoSolution().run();
    }
}
