package mycode.datastructure.tree;

import java.util.Stack;

/**
 * 树的前中后序遍历、递归和非递归
 * 1 2 5 6 4 8
 *
 * @author pan
 * @create 2020-02-17-16:40
 */
public class TraverseTree {

    public static void main(String[] args) {
        MyTreeNode tree = createTree();
        System.out.println("先序遍历:");
        preOrderWithRecursion(tree);
        System.out.println();
        preOrderWithStack(tree);
        System.out.println();
        System.out.println();
        System.out.println("\n" + "中序遍历:");
        midOrderWithRecursion(tree);
        System.out.println();
        midOrderWithStack2(tree);
//        System.out.println();
//        midOrderWithStack(mycode.datastructure.tree);
//        System.out.println("\n" + "后序遍历:");
//        postOrderWithRecursion(mycode.datastructure.tree);
//        System.out.println();
//        postOrderWithStack(mycode.datastructure.tree);
    }

    /**
     * 生成一个测试树：
     * 1
     * / \
     * 2  4
     * / \  \
     * 5  6   8
     *
     * @return
     */
    public static MyTreeNode createTree() {
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.left.left = new MyTreeNode(5);
        root.left.right = new MyTreeNode(6);
        root.right = new MyTreeNode(4);
        root.right.right = new MyTreeNode(8);
        return root;
    }

    /**
     * 先序遍历，使用递归
     */
    public static void preOrderWithRecursion(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        /**
         * 这里可以对遍历的节点进行操作
         */
        System.out.print(treeNode.val + " ");
        preOrderWithRecursion(treeNode.left);
        preOrderWithRecursion(treeNode.right);
    }

    /**
     * 利用栈实现先序遍历
     *
     * @param treeNode
     */
    public static void preOrderWithStack(MyTreeNode treeNode) {
        Stack<MyTreeNode> stack = new Stack<>();
        MyTreeNode node = treeNode;
        //根左右
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 递归中序遍历
     *
     * @param treeNode
     */
    public static void midOrderWithRecursion(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midOrderWithRecursion(treeNode.left);
        System.out.print(treeNode.val + " ");
        /**
         * 这里可以处理遍历到的节点
         */
        midOrderWithRecursion(treeNode.right);
    }

    /**
     * 非递归中序遍历
     *
     * @param treeNode
     */
    public static void midOrderWithStack(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<MyTreeNode> stack = new Stack<>();
        MyTreeNode node = treeNode;
        //到达最左节点
        while (node != null || !stack.isEmpty()) {
            //如果当前节点不为空，则说明没有到达最左下角
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //此时到达最左下角的左空子树，需要从栈中返回左子树
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                /**
                 * 对取出的节点进行操作
                 */
                node = node.right;
            }
        }
    }

    public static void midOrderWithStack2(MyTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<MyTreeNode> stack = new Stack<>();
        MyTreeNode cur = treeNode;
        //到达最左节点
        while(cur!=null||!stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                if(cur == null){
                    cur = stack.pop();
                }
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }


    /**
     * 递归后序遍历
     *
     * @param treeNode
     */
    public static void postOrderWithRecursion(MyTreeNode treeNode) {
        if (treeNode != null) {
            postOrderWithRecursion(treeNode.left);
            postOrderWithRecursion(treeNode.right);
            System.out.print(treeNode.val + " ");
        }
    }

    /**
     * 非递归后序遍历
     *
     * @param treeNode
     */
    public static void postOrderWithStack(MyTreeNode treeNode) {
        Stack<MyTreeNode> s1 = new Stack<>();
        Stack<MyTreeNode> s2 = new Stack<>();//定义这个栈用于存储后序遍历的节点
        MyTreeNode node = treeNode;
        s1.push(node);
        while (!s1.isEmpty()) {
            node = s1.pop();
            s2.push(node);//将先序遍历中要打印的点存入栈中
            //注意先左后右打印
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
        }
        while (!s2.isEmpty()) {
            node = s2.pop();
            System.out.print(node.val + " ");
        }
    }
}

