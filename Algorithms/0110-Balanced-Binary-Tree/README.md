## [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)
### Easy
<hr/>

Given a binary tree, determine if it is **height-balanced**.
> A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

#### Example 1:
<img src="https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg" width="auto" />
<pre>
<strong>Input:</strong>  root = [3,9,20,null,null,15,7]
<strong>Output:</strong> true
</pre>

#### Example 2:
<img src="https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg" width="auto" />
<pre>
<strong>Input:</strong> root = [1,2,2,3,3,null,null,4,4]
<strong>Output:</strong> false
</pre>

#### Example 3:
<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> true
</pre>

### Constraints:

* The number of nodes in the trees is in the range <code>[0, 5000]</code>.
* <code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code>
