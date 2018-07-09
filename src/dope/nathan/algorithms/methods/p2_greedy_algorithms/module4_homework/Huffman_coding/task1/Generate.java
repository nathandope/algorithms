package dope.nathan.algorithms.methods.p2_greedy_algorithms.module4_homework.Huffman_coding.task1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

// пример реализации генератора длинной строки
// для тестирования Кодирования Хаффмана
public class Generate {

    public static void main(String[] args) throws FileNotFoundException {
        new Generate().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(
                "src\\dope\\nathan\\algorithms\\" +
                        "methods\\" +
                        "p2_greedy_algorithms\\" +
                        "module4_homework\\" +
                        "Huffman_coding\\task1\\" +
                        "test.txt"
        );
        int n = 1000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            printWriter.print((char) ('a' + random.nextInt(26)));
        }
        printWriter.close();
    }
}
