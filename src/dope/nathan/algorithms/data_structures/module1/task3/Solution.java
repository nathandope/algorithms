package dope.nathan.algorithms.data_structures.module1.task3;

import java.util.*;

public class Solution {

    private void run() {
        Scanner scanner = new Scanner(System.in);
        Buffer buffer = new Buffer(scanner.nextInt());
        int n = scanner.nextInt();
        // заполнение буфера пакетами
        for (int i = 0; i < n; i++) {
            buffer.addPackage(scanner.nextInt(), scanner.nextInt());
        }
        for (int i : buffer.log ) {
            System.out.println(i);
        }
    }

    class Buffer {
        private final int size; // фиксированный размер буфера
        private int processor; // время освобождения процессора
        private List<Integer> log;
        private ArrayDeque<Integer> buff;

        Buffer(int size) {
            this.size = size;
            buff = new ArrayDeque<>();
            log = new ArrayList<>();
            processor = 0;
        }

        void addPackage(int arrival, int duration) {
            if (check(arrival)) {
                log.add(push(arrival, duration));
            } else {
                log.add(-1);
            }
        }

        /*
        Пошаговый алгоритм проверки возможности передачи текущего пакета в буфер:
        размер буфера size >= 1.
        Тогда, если буфер пустой,
        то в буфер всегда можно передать текущий пакет,
        иначе, если буфер не пустой и не перереполнен,
        то в буфер можно передать текущий пакет,
        иначе, если буфер переполнен,
        и, если текущий пакет поступил раньше,
        чем обработается первый пакет из буфера,
        то в буфер невозможно передать текущий пакет,
        иначе, если текущий пакет поступил позже или
        одновременно с обработкой первого пакета из буфера,
        то, пока это условие соблюдается
        извлекать первый пакет из буфера
        если буфер пустой, то выйти из while
        то теперь в буфер можно передать текущий пакет,
        иначе, передать в буфер текущий пакет невозможно,
        т.к. размер буфер size ограничен входными параметрами
        */
        private boolean check(int arrival) {
            if (buff.isEmpty()) {
                return true;
            } else if (buff.size() < size) {
                return true;
            } else if (buff.size() == size) {
                if (arrival < buff.peek()) {
                   return false;
                } else {
                    while (arrival > buff.peek() ||
                            arrival == buff.peek()) {
                            buff.poll();
                            if (buff.isEmpty()) break;
                    }
                    return true;
                }
            } else {
                return false;
            }
        }

        /*
        Пошаговый алгоритм передачи текущего пакета в буфер:
        время начала обработки текущего пакета
        если текущий пакет поступил позже,
        чем обработается последний пакет в буфере,
        то передать для логирования время поступления текущего пакета
        обновить время освобождения процессора
        иначе, если текущий пакет поступил раньше или
        одновременно с обработкой последнего пакета в буфере,
        то передать для логирования время обработки последнего пакета в буфере
        (т.е. время начала обработки текущего пакета)
        обновить время освобождения процессора
        добавить в буфер текущий пакет (время начала обработки текущего пакета)
        передать значение для логирования
        */
        private int push (int arrival, int duration) {
            int forLog;
            if (arrival > processor) {
                forLog = arrival;
                processor = arrival + duration;
            } else {
                forLog = processor;
                processor += duration;
            }
            buff.add(processor);
            return forLog;
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
