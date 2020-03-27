package mycode.recurion;

/**
 * 八皇后问题
 *
 * @author pan
 * @create 2019-12-03-16:30
 */
public class Queue8 {
    int max = 8;
    /**
     * 这个数组用来记录皇后的排放位置，数组下标i+1代表第i个皇后，数组第i个元素arr[i]代表第i个皇后摆放在第几列
     */
    int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    public void print() {
        for (int i = 0; i < max; i++) {
            System.out.printf("%d" + " ", arr[i]);
        }
        System.out.println();
    }

    //放置第i个皇后
    public void check(int i) {
        if (i == max) {
            count++;
            print();
            return;
        }
        //从第一个位置开始放
        for (int j = 0; j < max; j++) {
            arr[i] = j;
            if (judge(i)) {
                check(i + 1);
            }
        }
    }

    //判断第n个皇后放置位置是否符合游戏规则
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //认为在对角线上或者直线上
            if (arr[i] == arr[n] || Math.abs(arr[n] - arr[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }
}
