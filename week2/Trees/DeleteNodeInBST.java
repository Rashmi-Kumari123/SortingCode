public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node found, apply deletion rules

            // Case 1: No child or only one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 2: Two children
            TreeNode successor = findMin(root.right);  // Find successor (smallest in right subtree)
            root.val = successor.val;  // Copy successor's value
            root.right = deleteNode(root.right, successor.val);  // Delete successor
        }
        return root;
    }

    // Helper function to find the smallest value in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
}
