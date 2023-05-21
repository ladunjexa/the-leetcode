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
    protected List<List<Integer>> levelOrderTraversal;
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderTraversal = new ArrayList<>();
        if(root == null)
            return levelOrderTraversal;
        
        DFS(root, 0);

        return levelOrderTraversal;
    }

    private void DFS(TreeNode currentNode, int currentLevel) {
        if(levelOrderTraversal.size() == currentLevel)
            levelOrderTraversal.add(new ArrayList<Integer>());

        List<Integer> levelNode = levelOrderTraversal.get(currentLevel);
        levelNode.add(currentNode.val);

        if(currentNode.left != null)
            DFS(currentNode.left, currentLevel + 1);
        if(currentNode.right != null)
            DFS(currentNode.right, currentLevel + 1);
    }
}
