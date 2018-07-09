package dope.nathan.algorithms.methods.p1_introduction.module3_practice.task2;

/*
Основные шаги реализации оптимального алгоритма вычисления чисел Фибоначчи:
- сохранение вычесленных ранее значений чисел Фибаначи;
- отказ от использования кэша (оптимизация для памяти);
- вычисление чисел от меньшего к большему;
- вывод константы для чисел по модулю (для работы с целыми числами);
 */
public class Fibonacci_Optimal {

    private static final int MOD = (int) (1e9+7);

    private int fibonacci(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int c = (a + b) % MOD;
            // a, b <- b, c
            a = b;
            b = c;
        }
        return a;
    }

    private void run(int n) {
        System.out.println(n + ": " + fibonacci(n));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // ввод данных
        new Fibonacci_Optimal().run(47);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
