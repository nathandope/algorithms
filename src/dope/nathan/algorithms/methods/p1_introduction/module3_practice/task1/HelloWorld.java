package dope.nathan.algorithms.methods.p1_introduction.module3_practice.task1;

// пример правильного вычесления скорости работы функции
public class HelloWorld {

    private void run() {
        int j = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            j += i;
        }
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
	    long startTime = System.currentTimeMillis();
        new HelloWorld().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
