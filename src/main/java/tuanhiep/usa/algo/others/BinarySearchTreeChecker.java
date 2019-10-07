package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;

public class BinarySearchTreeChecker extends abstractAlgo {
    @Override
    public void setUpDefault() {

    }

    @Override
    public void run() {

    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }

    /**
     * check validation of binary tree of integer number
     *
     * @param root
     * @return
     */
    public boolean checkBinaryTree(NodeTree root) {

        return checkBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    /**
     * Check validation of binary tree with range [min.max]
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean checkBinaryTree(NodeTree root, int min, int max) {

        if (root == null) {
            return true;
        }
        if (root.value > max && root.value < min) {
            return false;
        }


        return checkBinaryTree(root.left, min, root.value - 1) && checkBinaryTree(root.right, root.value + 1, max);

    }


}

/**
 * Class of node in data structure Tree
 */
class NodeTree {
    int value;
    NodeTree left;
    NodeTree right;

    public NodeTree(int value, NodeTree left, NodeTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
