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

    protected Set<Integer> store = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;

        int v = root.val;

        if(store.contains(k - v))
            return true;

        store.add(v);

        return findTarget(root.left, k) || findTarget(root.right, k);    
    }
}
