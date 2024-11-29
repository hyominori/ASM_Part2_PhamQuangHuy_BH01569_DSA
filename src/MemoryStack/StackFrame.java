package MemoryStack;
import java.util.Scanner;

public class StackFrame {
    public static int findProduct(int a, int b) {
        int product = a * b;
        return product;
    }

    public static int findSum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        int product = findProduct(a, b);
        System.out.println("Product is : " + product);

        int sum = findSum(a, b);
        System.out.println("Sum is : " + sum);

        scanner.close();
    }
}
