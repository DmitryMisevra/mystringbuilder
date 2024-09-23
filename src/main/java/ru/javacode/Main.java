package ru.javacode;

public class Main {

    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();

        sb.append("Hello");
        System.out.println(sb); // Hello

        sb.append(", World!");
        System.out.println(sb); // Hello, World!

        sb.delete(5, 7);
        System.out.println(sb); // HelloWorld!

        sb.undo();
        System.out.println(sb); // Hello, World!

        sb.undo();
        System.out.println(sb); // Hello

        sb.undo();
        System.out.println(sb); // Output: (empty string)

        sb.undo(); // No actions to undo.
    }
}
