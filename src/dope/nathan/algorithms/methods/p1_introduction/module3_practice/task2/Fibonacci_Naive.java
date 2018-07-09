package dope.nathan.algorithms.methods.p1_introduction.module3_practice.task2;

// пример экспоненциального роста количества рекурсивных вызовов
// функции вычесления чисел Фибоначчи
public class Fibonacci_Naive {

    private int cnt;

    private int fibonacci(int n) {
        cnt++;
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private void run(int n) {
        System.out.println(n + ": " + fibonacci(n));
        System.out.println(cnt + " calls");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            new Fibonacci_Naive().run(i);
            long finishTime = System.currentTimeMillis();
            System.out.println(finishTime - startTime + " ms");
        }
    }
}
