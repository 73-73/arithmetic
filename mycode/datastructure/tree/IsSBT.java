package mycode.datastructure.tree;

import java.util.*;

/**
 * 判断一个树是否是搜索二叉树
 * 非递归实现二叉树的中序遍历，判断是否总是大于前一个数，否则返回false，
 *
 * @author pan
 * @create 2020-03-07-14:23
 */
public class IsSBT {
    public static void main(String[] args) {
//        MyTreeNode mycode.datastructure.tree = MyTreeNode.createTree();
        /**
         *     5
         *  2    6
         *    4
         *   3
         */
        MyTreeNode tree = new MyTreeNode(5);
        tree.left = new MyTreeNode(2);
        tree.left.right = new MyTreeNode(4);
        tree.left.right.left = new MyTreeNode(3);
        tree.right = new MyTreeNode(6);
        System.out.println(isSBT(tree));
    }
    /**
     * 利用搜索二叉树的性质，中序遍历的结果总是递增的，将遍历出来的结果存储到一个list集合中，
     * 每次都查看当前节点是否大于最后存入的节点，否则返回false，遍历完成都满足要求，则返回true
     *
     * @param root
     * @return
     */
    public static boolean isSBT(MyTreeNode root) {
        if (root == null) {
            return false;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<MyTreeNode> stack = new Stack<>();
        MyTreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //此时达到最左节点的左空节点
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (stack1.isEmpty() || cur.val > stack1.peek()){
                    stack1.push(cur.val);
                }else{
                    return false;
                }
                cur = cur.right;
            }
        }
        return true;
    }
}
