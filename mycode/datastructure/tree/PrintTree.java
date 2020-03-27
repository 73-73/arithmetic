package mycode.datastructure.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层打印二叉树,如：
 *      * 1
 *      * / \
 *      * 2  4
 *      * / \  \
 *      * 5  6   8
 *      打印为：1
 *              2 4
 *              5 6 8
 * @author pan
 * @create 2020-03-07-11:43
 */
public class PrintTree {
    public static void main(String[] args) {
        print(MyTreeNode.createTree());
        int a = Integer.parseInt("A", 16);
        System.out.println(a);
    }

    /**
     * 就是图的广度优先遍历，但是额外准备了两个变量last和nextLast，用于标识当前层的最右节点和下一层的最右节点
     * @param root
     */
    public static void  print(MyTreeNode root){
        if(root == null){
            return ;
        }
        MyTreeNode last = root;//表示当前层的最后一个节点
        MyTreeNode nextLast = null;//表示下一层的最后一个节点
        MyTreeNode node = root;
        //DFS
        Queue<MyTreeNode> queue = new LinkedList();
        queue.offer(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            //操作当前节点
            System.out.print(node.val+" ");
            if(node.left != null){
                queue.offer(node.left);
                nextLast = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextLast = node.right;
            }
            if(node == last){
                System.out.println();
                last = nextLast;
            }
        }
    }
}
