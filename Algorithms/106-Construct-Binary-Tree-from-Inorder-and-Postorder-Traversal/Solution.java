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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        TreeNode root = buildTree(postorder, inorder, postorder.length - 1, 0, inorder.length - 1, inMap);
        
        return root;
    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int postEnd, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd || postEnd < 0)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = map.get(postorder[postEnd]);
        int rightSubtreeSize = inEnd - rootIndex;

        root.left = buildTree(postorder, inorder, postEnd - rightSubtreeSize - 1, inStart, rootIndex - 1, map);
        root.right = buildTree(postorder, inorder, postEnd - 1, rootIndex + 1, inEnd, map);

        return root;
    }
}
