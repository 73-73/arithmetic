package mycode.sort;

/**
 * 荷兰国旗：
 * 给定一个数组arr，一个数num
 * 小于num的放数组左边，大于num的放数组右边，等于num的放数组中间,不需要排序
 * [5,2,7,4,5] num= 5
 * [2,4,5,5,7]
 *
 * @author pan
 * @create 2020-02-17-19:51
 */
public class NetherlandFlag {
    /**
     * while(cur<more)
     * 定义三个指针，less，more，cur
     * 初始less为数组最左边往左一位，more为数组最右边往右一位，cur=0
     * cur>num,cur不动，将arr[more-1]与arr[cur]交换,more-1;
     * cur=num,cur++
     * cur<num,arr[less+1]与arr[cur++]交换,cur++
     */
    public static void netherlandFlag() {

    }
}
