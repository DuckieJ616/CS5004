import java.util.Scanner;

public class AddFromKbd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int a = sc.nextInt();
        System.out.print("Enter second integer: ");
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println("Sum is: " + sum);
        sc.close();
    }
}