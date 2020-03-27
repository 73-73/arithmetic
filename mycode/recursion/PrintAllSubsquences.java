package mycode.recursion;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 * @author pan
 * @create 2020-03-15-13:19
 */
public class PrintAllSubsquences {
    public static void main(String[] args) {
        String s = "ab";
        printAll(s);
    }
    public static void printAll(String s ){
        char[] chars = s.toCharArray();
        System.out.println("");
        printRecur(chars,0,"");
    }

    /**
     *
     * @param chars 字符数组
     * @param i 下标
     * @param pre 在此下标之前形成的字符串
     */
    public static void printRecur(char[] chars,int i ,String pre){
        if(i == chars.length){
            if(!pre.equals("")){
                System.out.println(pre);
            }
            return ;
        }
        printRecur(chars,i+1,new String(pre+chars[i]));
        printRecur(chars,i+1,pre);
    }
}
