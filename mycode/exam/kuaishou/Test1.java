package mycode.exam.kuaishou;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = {175, 173, 174, 163, 182, 177};
        int[] ints = DistanceToHigher(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] DistanceToHigher(int[] height) {
        // write code here
        int[] result = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            int j = i-1;
            int dis = 1;
            while(j>=0){
                if(height[j]>height[i]){
                    result[i] = dis;
                    break;
                }
                j--;dis++;
            }
        }
        return result;
    }
}
