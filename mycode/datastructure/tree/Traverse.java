package mycode.datastructure.tree;

import java.util.Stack;

/**
 * 二叉树的前中后遍历非递归实现
 *
 * @author pan
 * @create 2020-03-13-22:35
 */
public class Traverse {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(2);
        root.right = new Node(5);
        preOrderRecur(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        midOrderRecur(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        preOrderRecur(root);
        System.out.println();
        preOrder(root);
    }

    public static void preOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public static void midOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        midOrderRecur(root.left);
        System.out.print(root.value + " ");
        midOrderRecur(root.right);
    }

    public static void postOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.print(root.value + " ");
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        Node node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void midOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            //到达最左结点的左子空结点
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }
    }
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root.value);
            if(root.right!=null){
                stack1.push(root.right);
            }
            if(root.left!=null){
                stack1.push(root.left);
            }
        }
        for(int i :stack2){
            System.out.print(i+" ");
        }
    }
}
