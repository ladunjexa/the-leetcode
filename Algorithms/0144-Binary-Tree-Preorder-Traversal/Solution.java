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
    private List<Integer> preOrderTraversal = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversalRecursive(root);
        return preOrderTraversal;
    }
    
    private void preorderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;
        
        preOrderTraversal.add(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
    }
}