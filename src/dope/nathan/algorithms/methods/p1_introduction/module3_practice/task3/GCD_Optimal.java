package dope.nathan.algorithms.methods.p1_introduction.module3_practice.task3;

import java.math.BigInteger;

/*
Основные шаги реализации оптимального алгоритма вычисления чисел Фибоначчи:
- алгоритм Евклида, используя остаток от деления (max(a, b) / min(a, b), min(a, b));
- замена рекурсивного хвостового вызова на присвоение переменным новых значений;
- использование BigInteger для огромных чисел (существует встроенный метод BigInteger: a.gcd(b));
*/
public class GCD_Optimal {
    private BigInteger gcd(BigInteger a, BigInteger b) {
        while (true) {
            System.out.println(a + " " + b);
            if (a.equals(BigInteger.ZERO)) return b;
            if (b.equals(BigInteger.ZERO)) return a;
            if (a.compareTo(b) >= 0) {
                // a, b <- a % b, b
                a = a.mod(b);
            } else {
                // a, b <- a, b % a
                b = b.mod(a);
            }
        }
    }


    private void run() {
        // ввод данных
        BigInteger a = new BigInteger("21324345213643213832445236879987875346781");
        BigInteger b = new BigInteger("545643214399768465434654654");
        System.out.println(gcd(a,b));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new GCD_Optimal().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
