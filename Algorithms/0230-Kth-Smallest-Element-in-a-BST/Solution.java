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
    int out = Integer.MIN_VALUE, f = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        f = k;

        DFS(root);

        return out;
    }

    private void DFS(TreeNode root) {
        if(root == null)
            return;
        
        if(f > 0) {
            DFS(root.left);
            if(f > 0) {
                f--;
                out = root.val;
            }
            DFS(root.right);
        }
    }

}
