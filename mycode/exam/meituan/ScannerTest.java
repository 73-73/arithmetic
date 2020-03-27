package mycode.exam.meituan;

import java.util.Scanner;

/**
 * @author pan
 * @create 2020-03-12-21:32
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNext("0")){
            System.out.println(scanner.nextLine());
        }
        System.out.println("1");
    }
}
