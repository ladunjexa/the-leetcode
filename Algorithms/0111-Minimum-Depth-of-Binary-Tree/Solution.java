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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int rightDepth = minDepth(root.right);
        int leftDepth = minDepth(root.left);

        if(rightDepth == 0)
            return leftDepth + 1;

        else if(leftDepth == 0)
            return rightDepth + 1;

        else return Math.min(rightDepth, leftDepth) + 1;
    }
}