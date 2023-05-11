### [View](https://leetcode.com/problems/matrix-diagonal-sum/solutions/3502477/java-well-detailed-iteration-runtime-beats-100-0ms-memory-beats-45-40-42-8mb/) discussion on leetcode

<h2><a href="https://leetcode.com/problems/matrix-diagonal-sum/">1572. Matrix Diagonal Sum</a></h2><h3>Easy</h3><hr><div><p>
Given a square matrix <code>mat</code>, return the sum of the matrix diagonals.

  Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
</p>
<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/14/sample_1911.png" width="auto" />
<pre>
<strong>Input:</strong> mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
<strong>Output:</strong> 25
<strong>Explanation:</strong> Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
<strong>Output:</strong> 8
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> mat = [[5]]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>n == mat.length == mat[i].length</code></li>
  <li><code>1 &lt;= n &lt;= 100</code></li>
  <li><code>1 &lt;= mat[i][j] &lt;= 100</code></li>
</ul>
</div>
