package mycode.offersword;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author pan
 * @create 2019-11-20-12:05
 */
public class FindArr {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        FindArr findArr = new FindArr();
        boolean arr1 = findArr.findArr(arr, 2);
        System.out.println(arr1);
    }

    /**
     * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * 要查找数字比左下角数字小时，上移。这样找的速度最快。
     *
     * @param arr
     * @param n
     * @return
     */
    public boolean findArr(int[][] arr, int n) {
        //构造左下角坐标
        int row = arr.length - 1;//行
        int column = 0;//列
        while (row >= 0 && column < arr[row].length) {
            if (arr[row][column] > n) {
                row--;
            } else if (arr[row][column] < n) {
                column++;
            } else if (arr[row][column] == n) {
                return true;
            }
        }
        return false;
    }
}
