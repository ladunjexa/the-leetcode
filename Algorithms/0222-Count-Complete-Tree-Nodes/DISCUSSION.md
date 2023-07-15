# Intuition & Approach
`countNodes` method checks whether the current node is null or not. If it is null, it returns `0` because there are no nodes to count. Otherwise, it recursively counts the nodes in the left subtree and right subtree and adds 1 to account for the current node.
<!-- Describe your first thoughts on how to solve this problem. -->

##### Main Concepts
**Recursion:** The code uses a recursive approach to count the nodes in the binary tree. It breaks down the problem into smaller subproblems by recursively calling the countNodes function on the left and right subtrees.

**Binary Tree Traversal:** The code traverses the binary tree in a depth-first manner, visiting each node once.

# Complexity
- Time complexity: $$O(n)$$

The *time complexity* of this algorithm is `O(n)`, where `n` is the number of nodes in the binary tree. This is because the code **visits each node exactly once**, performing a constant amount of work at each node.

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The *space complexity* is determined by the recursive calls. In the worst case, when the tree is skewed and has a height of `n`, the space complexity becomes `O(n)` due to the recursion stack. This is because the recursive calls will be made for each node in the longest path from the root to a leaf. In the best case, when the tree is perfectly balanced, the space complexity is `O(log n)`, where `n` is the number of nodes.

# Code
``` Java []
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
    public int countNodes(TreeNode root) {
        return (root == null) ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```
``` java []
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
    public int countNodes(TreeNode root) {
        if(root = null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```
