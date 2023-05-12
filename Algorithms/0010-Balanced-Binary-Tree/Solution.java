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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        if(depth(root) == -1)
            return false;
        
        return true;
    }

    private int depth(TreeNode root) {
        if(root == null)
            return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if(leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
