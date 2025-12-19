
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) return true;
        // Node value must lie strictly between left and right
        if (node.val <= left || node.val >= right) return false;
        
        return isValidBST(node.left, left, node.val) && 
               isValidBST(node.right, node.val, right);
    }
    
}