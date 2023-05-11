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
    // left, root, right
    private List<Integer> inOrderTraversal = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversel(root);
        return inOrderTraversal;
    }

    private void inorderTraversel(TreeNode root) {
        if(root == null)
            return;
    
        inorderTraversal(root.left);
        inOrderTraversal.add(root.val);
        inorderTraversal(root.right);
    }
}