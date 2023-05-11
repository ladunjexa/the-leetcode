## [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
### Medium
<hr/>
You are given an <code>m x n</code> binary matrix <code>grid</code>. An island is a group of <code>1</code>'s (representing land) connected <strong>4-directionally</strong> (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The <strong>area</strong> of an island is the number of cells with a value <code>1</code> in the island.

<em>Return the maximum area of an island in </em><code>grid</code>. If there is no island, return <code>0</code>.

#### Example 1:
<img src="https://assets.leetcode.com/uploads/2021/05/01/maxarea1-grid.jpg" width="auto" />
<pre>
<strong>Input:</strong> grid = [
  [0,0,1,0,0,0,0,1,0,0,0,0,0],
  [0,0,0,0,0,0,0,1,1,1,0,0,0],
  [0,1,1,0,1,0,0,0,0,0,0,0,0],
  [0,1,0,0,1,1,0,0,1,0,1,0,0],
  [0,1,0,0,1,1,0,0,1,1,1,0,0],
  [0,0,0,0,0,0,0,0,0,0,1,0,0],
  [0,0,0,0,0,0,0,1,1,1,0,0,0],
  [0,0,0,0,0,0,0,1,1,0,0,0,0]
]
<strong>Output:</strong> 6
<strong>Explanations:</strong> The answer is not 11, because the island must be connected 4-directionally.
</pre>

#### Example 2:
<pre>
<strong>Input:</strong> grid = [[0,0,0,0,0,0,0,0]]
<strong>Output:</strong> 0
</pre>

### Constraints:
<ul>
  <li><code>m == grid.length</code></li>
  <li><code>n == grid[i].length</code></li>
  <li><code>1 &lt;= m, n &lt;= 50</code></li>
  <li><code>grid[i][j]</code> is either 0 or 1.</li>
</ul>
</div>
