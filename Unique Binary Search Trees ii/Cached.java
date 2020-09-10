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
class Cached {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n == 0) {
            return ans;
        } 
        return generateTrees(1, n, new HashMap<>());
    }
    
     private List<TreeNode> generateTrees(int start, int end, Map<StringBuilder, List<TreeNode>> cache) {
         List<TreeNode> ans = new ArrayList<>();
         if(start > end) {
             ans.add(null);
             return ans;
         }
         
         if(start == end) {
             ans.add(new TreeNode(start));
             return ans;
         }
         
         StringBuilder sb = new StringBuilder();
         sb.append(start);
         sb.append(" ");
         sb.append(end);
         
         if(cache.containsKey(sb)) {
             return cache.get(sb);
         }
         
         for(int i = start; i <= end; i++) {
         List<TreeNode> leftSubtree = generateTrees(start, i - 1, cache);
         List<TreeNode> rightSubtree = generateTrees(i + 1, end, cache);
         
         for(TreeNode leftC : leftSubtree) {
             for(TreeNode rightC : rightSubtree) {
                 TreeNode root = new TreeNode(i);
                 root.left = leftC;
                 root.right = rightC;
                 
                 ans.add(root);
             }
         }
         }
         cache.put(sb,ans);
         return ans;
     }
}
