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
class NaiveCached {
    Map<TreeNode, Integer> cacheTaken = new HashMap<>();
    Map<TreeNode, Integer> cacheNotTaken = new HashMap<>();
    public int rob(TreeNode root) {
        
        return Math.max(rob(root, false), rob(root, true));
    }
    
    private int rob(TreeNode root, boolean canRob) {
        
        if(root == null) {
            return 0;
        }
        
        if(canRob && cacheTaken.containsKey(root)) {
            return cacheTaken.get(root);
        }
        
        if(!canRob && cacheNotTaken.containsKey(root)) {
            return cacheNotTaken.get(root);
        }
        
        int a1 = 0, a2 = 0;
        if(canRob) {
            a1 = root.val + rob(root.left, false) + rob(root.right, false);
            cacheTaken.put(root, a1);
            return a1;
        } else {
            a2 = Math.max(rob(root.left, false), rob(root.left, true)) + Math.max(rob(root.right, false), rob(root.right, true));
            cacheNotTaken.put(root, a2);
            return a2;
        }
    }
}
