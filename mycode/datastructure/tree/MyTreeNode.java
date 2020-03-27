package mycode.datastructure.tree;

/**
 * @author pan
 * @create 2020-03-07-11:42
 */
class MyTreeNode {
    MyTreeNode left;
    MyTreeNode right;
    int val;

    public MyTreeNode(int val) {
        this.val = val;
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
}
