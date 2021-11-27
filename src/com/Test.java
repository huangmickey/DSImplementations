package com;

public class Test {
    // 4! = 4 x 3 x 2 x 1
    // 3! = 3 x 2 x 1

    public static int factorial(int n) {
        int factorial = 1;
        for (int i = n; i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }
    // 4! = 4 * 3!
    // n! = n x (n - 1)!

    // f(3)
    //   3 * f(2)
    //         2 x (f1)
    //                1 x f(0)

    public static int factorialRecursive(int n ) {
        // base condition
        if (n == 0) return 1;
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        int factorial = factorialRecursive(3);
        System.out.println(factorial);
    }
}
