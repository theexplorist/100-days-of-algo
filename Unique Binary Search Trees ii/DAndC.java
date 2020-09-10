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
class DAndC {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n == 0) {
            return ans;
        }
        return generateTrees(1, n);
    }
    
     private List<TreeNode> generateTrees(int start, int end) {
         List<TreeNode> ans = new ArrayList<>();
         if(start > end) {
             ans.add(null);
             return ans;
         }
         
         if(start == end) {
             ans.add(new TreeNode(start));
             return ans;
         }
         
         for(int i = start; i <= end; i++) {
         List<TreeNode> leftSubtree = generateTrees(start, i - 1);
         List<TreeNode> rightSubtree = generateTrees(i + 1, end);
         
         for(TreeNode leftC : leftSubtree) {
             for(TreeNode rightC : rightSubtree) {
                 TreeNode root = new TreeNode(i);
                 root.left = leftC;
                 root.right = rightC;
                 
                 ans.add(root);
             }
         }
         }
         return ans;
     }
}
