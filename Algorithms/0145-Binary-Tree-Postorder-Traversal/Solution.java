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
    private List<Integer> postOrderTraversal = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorderTraversalRecursive(root);
        return postOrderTraversal;
    }
    
    private void postorderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;
        
        postorderTraversalRecursive(root.left);
        postorderTraversalRecursive(root.right);
        postOrderTraversal.add(root.val);
    }
}