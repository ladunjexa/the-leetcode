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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaf = new ArrayList<Integer>(),
                      root2Leaf = new ArrayList<Integer>();
    
        getLeafNodes(root1, root1Leaf);
        getLeafNodes(root2, root2Leaf);

        return root1Leaf.equals(root2Leaf);
    }

    private void getLeafNodes(TreeNode node, List<Integer> leaf) {
        if(node == null)
            return;
        
        if(node.left == null && node.right == null)
            leaf.add(node.val);

        getLeafNodes(node.left, leaf);
        getLeafNodes(node.right, leaf);
    }
}
