public class CheckSymmetricTree {
    // as we know, a tree is symmetric if the left and right subtrees are mirror images of each other.so I am using this concept
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
    
}
