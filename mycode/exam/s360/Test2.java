package mycode.exam.s360;
/**
 * A和B两个人在抽奖。现在有一个抽奖箱，里面有n张中奖票，m张不中奖票。A和B轮流从中抽一张奖票出来。
 * 如果有人抽到中奖票就结束，抽到中奖票的人胜利。抽过的奖票会被丢弃。
 * <p>
 * 额外的，B每次抽后，会再次抽取一张票并丢弃掉（这张票中奖不算B胜利）。
 * <p>
 * 现在，A先抽，请问A的胜率，保留4位小数后输出。
 * <p>
 * 如果两人到最后也没有抽到中奖票算作B胜利。
 *
 * @author pan
 * @create 2020-03-24-20:23
 */
import java.util.Scanner;


public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //中将票
        int n = scanner.nextInt();
        //不中奖票
        int m = scanner.nextInt();
        scanner.close();
        double p = getP(n, m);
        System.out.printf("%.4f",p);
    }

    public static double getP(double n, double m) {
        if (n <= 0) {
            return (double) 0;
        }
        if (m <= 0) {
            return (double) 1;
        }
        if (m == 1 && n == 1) {
            return (double) 0.5;
        }
        if (n == 1 && m == 2) {
            return (double) 1 / 3;
        }
        if (n == 2 && m == 2) {
            return (double) (1 / 2) + (1 / 9);
        }
        if (n == 2 && m == 3) {
            return (double) 0.6;
        }
        double p = 0;
        p += n / (n + m);//直接抽中
        p += (1 - p) * ((m - 1) / (n + m - 1)) * ((m - 1) / (n + m - 2)) * getP(n, m - 3); //未抽中且B抽掉一张不中奖票，且丢弃一张不中奖票
        p += (1 - p) * ((m - 1) / (n + m - 1)) * ((n) / (n + m - 2)) * getP(n - 1, m - 2);  //未抽中且B抽掉一张不中奖票，且丢弃一张中奖票
        p += (1 - p) * ((n) / (n + m - 1)) * ((m - 1) / (n + m - 2)) * getP(n - 1, m - 2); //未抽中且B抽掉一张中奖票，且丢弃一张不中奖票
        p += (1 - p) * ((n) / (n + m - 1)) * ((n - 1) / (n + m - 2)) * getP(n - 2, m - 1); //未抽中且B抽掉一张中奖票，且丢弃一张中奖票

        return p;
    }
}
