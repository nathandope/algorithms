package dope.nathan.algorithms.methods.p2_greedy_algorithms.module5_practice.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Пример реализации алгоритма Кодирования Хаффмана через поиск строго двоичного дерева:
Дерево состоит из узлов (Node).
Узлы дерева бывают двух типов:
- внутренние (InternalNode) и
- листья (LeafNode).
Надежный жадный шаг: выбрать две минимальные частоты fi, fj (количество раз повторения символа),
сделать их детьми новой вершины с пометкой fi+fj, выкинуть частоты fi, fj и добавить fi+fj;
 */

public class HuffmanCoding {

    class Node implements Comparable<Node> {
        final int sum;
        String code;

        Node(int sum) { this.sum = sum; }

        void buildCode(String code) { this.code = code; }

        @Override
        public int compareTo(Node o) { return Integer.compare(sum, o.sum); }
    }

    class InternalNode extends Node{
        Node left;
        Node right;

        InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class LeafNode extends Node {
        char symbol;

        LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File(
                "src\\dope\\nathan\\algorithms\\" +
                "methods\\" +
                "p2_greedy_algorithms\\" +
                "module4_homework\\" +
                "Huffman_coding\\task1\\" +
                "test.txt")
        );
        String s = input.next();

        // подсчет повторений символов в коде для оптимального построения кода,
        // т.е. самый часто повторяющийся, элемент будет иметь самый короткий код
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

        Map<Character, Node> charNodes = new HashMap<>();
        // очередь с приорететами по-умолчанию в начале хранит минимум
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        // перебирая элементы из count создаем новые узлы-листья через соответствующий конструктор
        // размещение элементов в очереди производится на основе метода compareTo() родительского класса Node
        for (Map.Entry<Character,Integer> entry : count.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }

        // сумма всех вершин, кроме корневой - длина кода в битах
        int sum = 0;
        // достовая из очереди два минимальных элемента (частоты) создаем внутренний узел
        // кладем созданный узел в очередь
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }

        // если в count всего одна пара, длина закодированной строки будет равна длине входной
        // т.к. сумма частот всех вершин, кроме корневой, это длина кода в битах
        // например: s: aaaaaa => a: 6 => s.length
        if (count.size() == 1){
            sum = s.length();
        }
        // выводим первую строку по условию, т.е.
        // число различных элементов и размер получившейся закодированной строки
        System.out.println(count.size() + " " + sum);

        // достаем очередной элемент из очереди, и, если ранее выполнился блок while,
        // то это будет корневой элемент => его код = ""
        // если же блок while был пропущен => в исходной строке только один символ, то его код = 0;
        Node root = priorityQueue.poll();
        if (count.size() == 1){
            root.buildCode("0");
        } else {
            root.buildCode("");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(charNodes.get(c).code);
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new HuffmanCoding().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
