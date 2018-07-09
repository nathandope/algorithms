package dope.nathan.algorithms.methods.p2_greedy_algorithms.module4_homework.Huffman_coding.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// наивная реализация Декодирования Хаффмана
public class HuffmanDecoding {

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextInt();

        Map<String, String> dict = new HashMap<>();
        for ( ; k > 0; k--) {
            dict.put(
                    scanner.next().replace(":", ""),
                    scanner.next());
        }

        String code = scanner.next();
        scanner.close();
        System.out.println(deCoding(code, dict));
    }

    private String deCoding(String s, Map<String, String> dict) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < s.length();) {
            for (Map.Entry<String, String> entry : dict.entrySet()) {
                if (s.startsWith(entry.getValue(), j)) {
                    j += entry.getValue().length();
                    result.append(entry.getKey());
                }
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new HuffmanDecoding().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
