package mycode.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author pan
 * @create 2019-11-25-18:24
 */
public class IsPalindrome {

    public static void main(String[] args) {

    }

    /**
     * 1，借用头尾指针，从两边扫到中间
     * 2，忽略大小写
     * 3，判断是否相等
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s == "") {
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            //如果不是数字或者字母，跳过
            if (!Character.isLetterOrDigit(chars[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(chars[right])) {
                right++;
            } else {
                if (chars[left] == chars[right]) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /*    *//**
     * 1、将字符串转为小写并转化为字符数组
     * 2、遍历字符数组
     * 3、如果没有在集合中，则加入集合
     * 4、如果在集合中，则将元素移出数组
     * 5、遍历完毕后判断集合是否为空或者只包含一个元素
     * @param s
     * @return
     *//*
    public static boolean isPalindrome(String s){
        if(s==null||s==""){
            return true;
        }
        //题中忽略了字母的大小写，一律当作小写来做
        s = s.toLowerCase();
        char[] chars=s.toCharArray();
        HashSet<Character> set=new HashSet<>();
        for(char ch:chars){
            if(set.contains(ch)){
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }
        return set.size()<2?true:false;
    }*/
}
