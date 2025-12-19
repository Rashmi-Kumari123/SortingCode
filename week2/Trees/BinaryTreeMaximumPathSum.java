class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTreeMaximumPathSum {
    int maxSum; // declaring class-level variable
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
    int solve(TreeNode root) {
        if (root == null) return 0;
        
        int l = Math.max(0, solve(root.left));
        int r = Math.max(0, solve(root.right));
        
        int neeche_hi_milgaya_answer = l + r + root.val;
        int koi_ek_acha = Math.max(l, r) + root.val;
        int only_root_acha = root.val;
        
        maxSum = Math.max(
            Math.max(maxSum, neeche_hi_milgaya_answer),
            Math.max(koi_ek_acha, only_root_acha)
        );
        return Math.max(koi_ek_acha, only_root_acha);
    }
    
    
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        // Case 1: Simple tree
        //        1
        //       / \
        //      2   3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root1));
        System.out.println("Expected: 6 (2 + 1 + 3)");
        
        // case 2: Tree with negative values
        //       -10
        //       /  \
        //      9   20
        //         /  \
        //        15   7
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root2));
        System.out.println("Expected: 42 (15 + 20 + 7)");
       
        
    }
}