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
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageOfLevels = new ArrayList<Double>();
        List<Integer> nodesOfLevel = new ArrayList<Integer>();

        averageOfLevels(root, 0, nodesOfLevel, averageOfLevels);
        
        for(int i = 0; i < averageOfLevels.size(); i++)
            averageOfLevels.set(i, averageOfLevels.get(i) / nodesOfLevel.get(i));
        
        return averageOfLevels;
    }

    private void averageOfLevels(TreeNode root, int level, List<Integer> nol, List<Double> aol) {
        if(root == null)
            return;
        
        if(aol.size() == level) {
            aol.add(level, (double) root.val);
            nol.add(level, 1);
        } else {
            aol.set(level, root.val + aol.get(level));
            nol.set(level, nol.get(level) + 1);
        }

        averageOfLevels(root.left, level + 1, nol, aol);
        averageOfLevels(root.right, level + 1, nol, aol);
    }
}
