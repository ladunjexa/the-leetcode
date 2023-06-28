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
    public int maxLevelSum(TreeNode root) {
        int N = (int) (Math.floor(Math.log(10000) / Math.log(2)) + 21), max = 0;
        int[] levels = new int[N];

        for(int i = 0; i < N; i++)
            levels[i] = Integer.MIN_VALUE;

        maxLevelSum(root, 0, levels);

        for(int i = 0; i < N; i++)
            if(levels[i] > levels[max])
                max = i;

        return max + 1;
    }

    public void maxLevelSum(TreeNode root, int level, int[] levels) {
        if(root == null)
            return;
        
        if(levels[level] == Integer.MIN_VALUE)
            levels[level] = 0;

        levels[level] += root.val;

        maxLevelSum(root.right, level + 1, levels);
        maxLevelSum(root.left, level + 1, levels);
    }
}
