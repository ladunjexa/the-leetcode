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

    private int minNode = Integer.MAX_VALUE, prevNode = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return minNode;
        
        getMinimumDifference(root.left);

        minNode = Math.min(minNode, Math.abs(root.val - prevNode));
        prevNode = root.val;

        getMinimumDifference(root.right);

        return minNode;
    }
}
