package dope.nathan.algorithms.methods.p1_introduction.module3_practice.task3;

// пример наивного алгоритма с перебором всех значений от 1 до max(a, b)
public class GCD_Naive {
    private long gcd(long a, long b) {
        int result = 0;
        for (int i = 1; i < Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }

    private void run() {
        // ввод данных
        System.out.println(gcd(1142158,5454566));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new GCD_Naive().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
