# Intuition & Approach
This code is an implementation of the ***Lowest Common Ancestor of a Binary Search Tree*** problem. It find the lowest common ancestor of two nodes, `p`, and `q`, in a binary search tree (BST). The lowest common ancestor is *the deepest node in the tree that is an ancestor of both `p` and  `q`*.

**Here's step-by-step explanations of the code:**

1. The code begins by checking if the `root` node or either `p` or `q` is null. If any of them is `null`, it means we have *reached the end of a branch* or *one of the nodes is not present in the tree*, so we return the `root` itself. This is the base case for the recursive traversal of binary search tree.

2. Next, the code checks if both `p` and `q` are greater than the value of the `root` node. If so, it means *both nodes are located in the right subtree of the current `root`*. In this case, we recursively call the `lowestCommonAncestor` function, passing the right child of the `root` as the new `root`, `p`, and `q` as a parameters. This effectively moves the search to the right subtree.

3. Similary, if both `p` and `q` are smaller than the value of the `root` node. If so, it means *both nodes are located in the left subtree of the current `root`*. In this case, we recursively calls the `lowestCommonAncestor` function, passing the left child of the `root` as the new `root`, `p`, and `q` as a parameters. This effectively moves the search to the left subtree.

4. If neither of the above conditions is `true`, it means that `p` and `q` are located in different subtrees of the current `root`, or one of them is equal to the `root` node itself. In either case, the current `root` is the lowest common ancestor, so we return `root`.

The code utilizes the properties of a BST, *where all nodes in the left subtree are less than the root, and all nodes in the right subtree are greater than root*. By recursively traversing the BST and narrowing down the search based on the values of `p` and `q` relative to the current `root`, the code effectively finds and returns the lowest common ancestor of the two nodes.

The code follows the principles of recursion and leverages the BST structure to optimize the search process.

# Complexity
- Time complexity (BCS): $$O(logn)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity (BCS): $$O(logn)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

The space and time complexity of the `lowestCommonAncestor` is $$O(logn)$$ on average and $$O(n)$$ in the worst case, where `n` is the number of nodes in the binary search tree.

*In the best case scenario*, when the tree is perfectly balanaced, each recursive call of `lowestCommonAncestor` reduces the search space by half, similar to a binary search and due to the recursive calls, the space required for the recursive call stack grows with the height of the BST.

*In the worst case scenario*, when the tree is skewed and resembles a linked list, each recursive call traverses the entire height of the tree, resulting in `n` recursive calls. Therefore, the time and soace complexity becomes O(n) as the height of the tree can be equal to the number of nodes in the tree.

# Code
``` java []
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null | q == null)
            return root;
        
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        
        return root;
    }
}
```
