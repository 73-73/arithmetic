package mycode;

/**
 * 给定一个数组代表一个容器，
 * 比如[3,1,2,4]，
 * 代表0位置是一个宽度为1，高度为3的直方图。
 * 代表1位置是一个宽度为1，高度为1的直方图。
 * 代表2位置是一个宽度为1，高度为2的直方图。
 * 代表3位置是一个宽度为1，高度为4的直方图。
 * 所有直方图的底部都在一条水平线上，且紧靠着。
 * 把这个图想象成一个容器，这个容器可以装3格的水。
 * 给定一个没有负数的数组arr，返回能装几格水？
 *
 * @author pan
 * @create 2020-03-15-20:56
 */
public class WaterProblem {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            int[] arr = generateRandomArray();
            int r1 = getCapacity1(arr);
            int r2 = getWater1(arr);
            if (r1 != r2) {
                System.out.println("What a fucking day! fuck that! man!");
            }
        }
//        int[] arr = {3,1,2,4};
//        int capacity1 = getCapacity1(arr);
//        System.out.println(capacity1);
    }
    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 98) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200) + 2;
        }
        return arr;
    }

    /**
     * 准备两个数组，分别存放当前点左边最大值和右边最大值
     *
     * @param arr
     */
    public static int getCapacity1(int[] arr) {
        //左右两边不储水
        if (arr.length <= 2) {
            return 0;
        }
        int sum = 0;
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            leftMax[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            max = Math.max(arr[i],max);
            rightMax[i] = max;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            int min = Math.min(leftMax[i - 1], rightMax[i + 1]);
            if (arr[i] < min) {
                sum += min - arr[i];
            }
        }
        return sum;
    }
    public static int getWater1(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int value = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(arr[l], leftMax);
            }
            for (int r = i + 1; r < arr.length; r++) {
                rightMax = Math.max(arr[r], rightMax);
            }
            value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
        }
        return value;
    }
}
