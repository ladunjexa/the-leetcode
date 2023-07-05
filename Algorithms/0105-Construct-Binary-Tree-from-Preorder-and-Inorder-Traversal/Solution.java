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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, inorder, 0, 0, preorder.length - 1, inorder.length - 1, inMap);

        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pos, int ios, int poe, int ioe, HashMap<Integer, Integer> map) {
        if(ios > ioe || pos > poe)
            return null;

        TreeNode root = new TreeNode(preorder[pos]);
        int ri = map.get(preorder[pos]);
        int diff = ri - ios;

        root.left = buildTree(preorder, inorder, pos + 1, ios, pos + diff, ri - 1, map);
        root.right = buildTree(preorder, inorder, pos + 1 + diff, ri + 1, poe, ioe, map);

        return root;
    }
}
