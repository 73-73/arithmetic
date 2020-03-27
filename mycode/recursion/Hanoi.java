package mycode.recursion;

/**
 * @author pan
 * @create 2020-03-15-12:12
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi(2);
        hanoi(3);
    }
    public static void hanoi(int n ){
        hanoiRecur(n,"A","B","C");
        System.out.println("done");
    }

    public static void hanoiRecur(int n, String from, String help, String to) {
        if (n == 1) {
            System.out.println("move " + n +" form "+from+ " to " + to);
            return ;
        }
        //把除n层外移到help杆上
        hanoiRecur(n-1,from,to,help);
        System.out.println("move " + n +" form "+from+ " to " + to);
        //此时to杆为第n层圆盘，把位于help杆的所有圆盘按照新的一轮汉诺塔问题，移到to杆上，以from杆作为辅助杆
        hanoiRecur(n-1,help,from,to);
    }
}
