package mycode.exam.s360;
/**
 * 有一种特殊的DNA，仅仅由核酸A和T组成，长度为n，顺次连接
 * <p>
 * 科学家有一种新的手段，可以改变这种DNA。每一次，科学家可以交换该DNA上两个核酸的位置，也可以将某个特定位置的核酸修改为另一种核酸。
 * <p>
 * 现在有一个DNA，科学家希望将其改造成另一种DNA，希望你计算最少的操作次数。
 *
 * @author pan
 * @create 2020-03-24-20:11
 */
import java.util.HashMap;
import java.util.Scanner;

/**
 * 通过率只有82，不知道哪里出问题
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        //ATA
        //TAT
        HashMap<Character,Integer> map = new HashMap<>();
        int count =0;
        for (int i = 0; i < s1.length(); i++) {
            //如果元素不相等
            if (s1.charAt(i) != s2.charAt(i)) {
                //ch为s2当前元素的配对，当前元素为A时，它为T
                Character ch = s1.charAt(i) == 'A' ? 'T' : 'A';
                //如果集合中没有当前元素的配对，则添加当前元素的配对，且count++
                if (!map.containsKey(s1.charAt(i))) {
                    map.put(ch,1);
                    count++;
                }
                //否则说明前一个不相等的元素可以交换，省去一步修改的操作,count也可以不+1
                else {
                    map.remove(ch);
                }
            }
        }
        if(count !=0)System.out.println(count);
    }
}
