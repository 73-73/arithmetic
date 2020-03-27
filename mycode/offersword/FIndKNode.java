package mycode.offersword;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4。
 *
 * @author pan
 * @create 2020-03-01-9:42
 */
public class FIndKNode {

    /**
     * 由二叉搜搜树的性质得到：
     * 左节点一定比根节点小，右节点一定比根节点大，所以它的中序遍历就是一个有序的队列，直接找出这个队列第K位数就可以得到答案
     *
     * @param pRoot
     * @param k
     * @return
     */
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = pRoot;
        while (node != null || !stack.isEmpty()) {
            //如果当前节点不为空，则说明没有到达最左下角
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //此时到达最左下角的左空子树，需要从栈中返回左子树
            if (!stack.isEmpty()) {
                node = stack.pop();
                count++;
                if (count == k) {
                    return node;
                }
                node = node.right;
            }
        }
        return null;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}