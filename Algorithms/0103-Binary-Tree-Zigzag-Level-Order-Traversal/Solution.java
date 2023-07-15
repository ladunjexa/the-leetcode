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
class Solution {
    private List<List<Integer>> traversal = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return traversal;

        DFS(root, 0);
        
        for (int i = 1; i < traversal.size(); i += 2)
            Collections.reverse(traversal.get(i));
    
        return traversal;
    }

    private void DFS(TreeNode root, int level) {
        if(traversal.size() == level)
            traversal.add(level, new ArrayList<>());
        
        traversal.get(level).add(root.val);

        if(root.left != null)
            DFS(root.left, level + 1);
        if(root.right != null)
            DFS(root.right, level + 1);
    }
}
