package mycode.exam.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
 * 答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，
 * 用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，
 * 喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 *
 * @author pan
 * @create 2020-03-04-15:17
 */
public class EmptyBottle {
    /**
     * 输入描述：输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），
     * 表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
     * 输出描述:对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
     * 例：  3
     * 10
     * 81
     * 0
     * 输出：1
     * 5
     * 10
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            if (x == 0) {
                break;
            }
            list.add(getNumber(x));
        }
        for (Integer result : list) {
            System.out.println(result);
        }
    }

    public static int getNumber(int x) {
        if (x == 1) {
            return 0;
        }
        if (x == 2) {
            return 1;
        }
        if (x == 3) {
            return 1;
        }
        //y为以三个为一组可兑换空瓶的数量
        int y = x / 3;
        //z为x对3取模
        int z = x % 3;
        return y + getNumber(y + z);
    }
}
