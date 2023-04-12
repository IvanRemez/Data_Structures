package day05_Stacks;

public class RecursiveFibonacci {

    public static void main(String[] args) {

        System.out.println(fib(2)); // 1
        System.out.println(fib(5)); // 5

    }

    public static int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        // ^^ base conditions (to exit recursion)

        return fib(n-1) + fib(n-2);
    }
}
