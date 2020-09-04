/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Naive {
    public int rob(TreeNode root) {
        return Math.max(rob(root, false), rob(root, true));
    }
    
    private int rob(TreeNode root, boolean canRob) {
        
        if(root == null) {
            return 0;
        }
        
        if(canRob) {
            return root.val + rob(root.left, false) + rob(root.right, false);
        } else {
            return Math.max(rob(root.left, false), rob(root.left, true)) + Math.max(rob(root.right, false), rob(root.right, true));
        }
    }
}
