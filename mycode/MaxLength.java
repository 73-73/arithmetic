package mycode;

/**
 * 给定一个数组，返回累加和为给定的k值的最长子数组长度
 *
 * @author pan
 * @create 2020-03-01-16:43
 */
public class MaxLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 7, 1};

        System.out.println(maxLength1(arr, 8));
        System.out.println(maxLength1(arr, 2));
    }

    /**
     * 给定一个正数数组，返回累加和为给定的k值的最长子数组长度
     * 例如： 1 2 3 1 1 7 1
     * k = 8 时 最长子数组为：1 2 3 1 1 max = 5
     * k = 2 时 最长子数组为： 1 1 max = 2
     * 思路：利用滑动窗口双指针做，定义两个指针l、r，定义一个sum，sum表示l-r这段子数组的数的和
     * 关于sum和k的情况：
     * 1、sum<k：r++右移
     * 2、sum>k：l++右移，窗口滑动，继续判断sum和k的大小
     * 3、sum==k：更新max r++右移
     * 边界条件：r>=arr.length
     * <p>
     * 代码写的很乱，思路是正确的
     *
     * @param arr 给定的一个正数数组
     * @param k   和
     * @return
     */
    public static int maxLength1(int[] arr, int k) {
        int left = 0, right = -1;//左右窗口
        int sum = 0;//当前窗口下数组元素的和
        int max = 0;//最长数组长度
        for (; right < arr.length; ) {
            if (sum < k) {
                right++;
                if (right < arr.length) {
                    sum += arr[right];
                }
                continue;
            }
            if (sum > k) {
                left++;
                sum -= arr[left - 1];
                continue;
            }
            if (sum == k) {
                max = Math.max(max, right - left + 1);
                right++;
                if (right < arr.length) {
                    sum += arr[right];
                }
            }
        }
        return max;
    }
}
