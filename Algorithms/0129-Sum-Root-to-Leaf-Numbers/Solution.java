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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, "");
    }

    private int sumNumbers(TreeNode root, String expr) {
        if(root.left == null && root.right == null) 
            return Integer.parseInt(expr + root.val);

        int l = 0, r = 0;

        expr += "" + root.val;
        if(root.left != null)
            l = sumNumbers(root.left, expr);
        if(root.right != null)
            r = sumNumbers(root.right, expr);
        
        return l + r;
    }
}
