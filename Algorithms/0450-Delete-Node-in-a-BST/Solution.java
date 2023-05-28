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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val == key) {
            boolean right = (root.right == null), left = (root.left == null);
            
            if(right && left)
                return null;
            else if(!(right || left)) {
                TreeNode newNode = root.right;
                while(newNode.left != null)
                    newNode = newNode.left;
                
                root.val = newNode.val;
                root.right = deleteNode(root.right, root.val);
            } else
                return (left) ? root.right : root.left;
                
        } else if(root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);

        return root;
    }
}
