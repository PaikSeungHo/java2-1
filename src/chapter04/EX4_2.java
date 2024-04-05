package chapter04;
import java.util.Scanner;
class Rectangle {
    int width;
    int height;
    public int getArea() {
        return width*height;
    }
}

public class EX4_2 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        rect.width = scanner.nextInt();
        rect.height = scanner.nextInt();
        System.out.println("사각형의 면적은" + rect.getArea());
        scanner.close();
    }
}