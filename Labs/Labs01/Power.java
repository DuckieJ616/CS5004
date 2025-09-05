/*
1. Java requires a class and a main method, while Python can execute statements directly.
2. Java is strongly typed and variables must have explicit types; Python is dynamically typed.
3. Java uses System.out.println to print output, while Python uses print().
*/

public class Power {
    public static void main(String[] args) {
        long result = (long) Math.pow(2, 31);
        System.out.println(result);
    }
}