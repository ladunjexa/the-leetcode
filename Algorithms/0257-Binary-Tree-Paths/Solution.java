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
    ArrayList<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, "");
        return paths;
    }

    private void binaryTreePaths(TreeNode root, String current) {
        if(root == null) 
            return;
        
        current += root.val;

        if(root.left == null && root.right == null) {
            paths.add(current);
            return;
        }

        current += "->";

        binaryTreePaths(root.left, current);
        binaryTreePaths(root.right, current);
    }
}
