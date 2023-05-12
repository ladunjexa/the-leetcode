## [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
### Easy
<hr/>
Given <code>head</code>, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the <code>next</code> pointer. Internally, <code>pos</code> is used to denote the index of the node that tail's <code>next</code> pointer is connected to. <strong>Note that <code>pos</code> is not passed as a parameter</strong>.

Return <code>true</code> <em>if there is a cycle in the linked list</em>. Otherwise, return <code>false</code>.

#### Example 1:
<img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" width="auto" />
<pre>
<strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> true
<strong>Explanations:</strong> There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
</pre>

#### Example 2:
<img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" width="auto" />
<pre>
<strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> true
<strong>Explanations:</strong> There is a cycle in the linked list, where the tail connects to the 0th node.
</pre>

#### Example 3:
<img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" width="auto" />
<pre>
<strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> false
<strong>Explanations:</strong> There is no cycle in the linked list.
</pre>

### Constraints:
* The number of the nodes in the list is in the range <code>[0, 104]</code>.
* <code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code>
* <code>pos</code> is -1 or a valid index in the linked-list.
