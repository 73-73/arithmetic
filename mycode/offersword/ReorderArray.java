package mycode.offersword;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 统计奇数的个数假设为n,然后新建一个等长数组，然后通过循环判断原数组中的元素为偶数还是奇数。
 * 如果是则从数组下标0的元素开始，把该奇数添加到新数组；如果是偶数则从数组下标为n的元素开始把该
 * 偶数添加到新数组中。
 * [1,2,3,4,5]->[1,3,5,2,4]
 *
 * @author pan
 * @create 2019-11-20-13:45
 */
public class ReorderArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ReorderArray r = new ReorderArray();
        int[] ints = r.reorderArray(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] reorderArray(int[] arr) {
        if (arr.length < 2)
            return arr;
        int oddCount = 0;//奇数个数
        int[] order = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) != 0)
                oddCount++;
        }//算出数组arr中奇数的个数
        //对数组进行重排
        for (int i = 0, odd = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {//奇数
                order[odd] = arr[i];
                odd++;
            } else if ((arr[i] & 1) == 0) {//偶数
                order[oddCount] = arr[i];
                oddCount++;
            }
        }
        return order;
    }


}
