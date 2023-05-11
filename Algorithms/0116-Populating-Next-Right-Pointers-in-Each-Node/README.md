## [116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
### Medium
<hr/>
You are given a <strong>perfect binary tree</strong> where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

```c
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to <code>NULL</code>.

Initially, all next pointers are set to <code>NULL</code>.

#### Example 1:
<img src="https://assets.leetcode.com/uploads/2019/02/14/116_sample.png" width="auto" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6,7]
<strong>Output:</strong> [1,#,2,3,#,4,5,6,7,#]
<strong>Explanations:</strong> Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
</pre>

#### Example 2:
<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

### Constraints:
* The number of nodes in the tree is in the range <code>[0, 2<sup>21</sup> - 1]</code>
* <code>-1000 &lt;= Node.val &lt;= 1000</code>
