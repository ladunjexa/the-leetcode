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

    protected int max = 0;
    public int longestZigZag(TreeNode root) {
        return Math.max(Math.max(longestZigZag(root.left, true), longestZigZag(root.right, false)), max);
    }

    private int longestZigZag(TreeNode root, boolean isLeft) {
        if(root == null)
            return 0;
        
        max = Math.max(longestZigZag(isLeft ? root.left : root.right, isLeft), max);
        return longestZigZag(isLeft ? root.right : root.left, !isLeft) + 1;
    }
}
