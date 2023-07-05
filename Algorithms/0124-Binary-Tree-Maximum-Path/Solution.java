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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[] {Integer.MIN_VALUE};

        height(root, maxSum);

        return maxSum[0];
    }

    private int height(TreeNode node, int[] max) {
        if (node == null)
            return 0;

        int l = Math.max(0, height(node.left, max)), r = Math.max(0, height(node.right, max));

        max[0] = Math.max(max[0], l + r + node.val);

        return Math.max(l, r) + node.val;
    }
}
