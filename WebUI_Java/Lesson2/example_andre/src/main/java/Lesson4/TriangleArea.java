package Lesson4;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int c;

        System.out.println("Введите длину стороны А:");
        a = scanner.nextInt();
        System.out.println("Введите длину стороны Б:");
        b = scanner.nextInt();
        System.out.println("Введите длину стороны С:");
        c = scanner.nextInt();

        float s = formulaTriangleArea(a, b ,c);



        System.out.println("Площать треугольника со сторонами: " + a + (", ") + b + (", ") + c + (" , равна: ") + s);

    }

    public static float formulaTriangleArea (int a , int b , int c){
        int p = (( a + b + c ) / 2);
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
