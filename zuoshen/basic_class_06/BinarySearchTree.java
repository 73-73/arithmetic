package zuoshen.basic_class_06;

/**
 * Not implemented by zuochengyun
 * 
 * Binary mycode.search mycode.datastructure.tree implementation.
 * 
 * In computer science, a binary mycode.search mycode.datastructure.tree (BST), which may sometimes also be
 * called an ordered or sorted binary mycode.datastructure.tree, is a node-based binary mycode.datastructure.tree data
 * structure which has the following properties:
 * 
 * a) The left subtree of a node contains only nodes with keys less than the node's key. </br>
 * b) The right subtree of a node contains only nodes with keys greater than the node's key. </br>
 * c) Both the left and right subtrees must also be binary mycode.search trees. </br>
 * 
 * @author Ignas Lelys
 * @created May 6, 2011
 * 
 */
public class BinarySearchTree extends AbstractBinarySearchTree {

    @Override
    protected Node createNode(int value, Node parent, Node left, Node right) {
        return new Node(value, parent, left, right);
    }

}
