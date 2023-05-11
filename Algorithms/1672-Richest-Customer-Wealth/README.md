## [1672. Richest Customer Wealth](https://leetcode.com/problems/richest-customer-wealth/)
### Easy
<hr/>

You are given an <code>m x n</code> integer grid <code>accounts</code> where <code>accounts[i][j]</code> is the amount of money the i<sup>th</sup> customer has in the j<sup>th</sup> bank. Return <em>the <strong>wealth</strong> that the richest customer has</em>.
<br/>

A customer's <strong>wealth</strong> is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum <strong>wealth</strong>.

#### Example 1:
<pre>
<strong>Input:</strong> accounts = [[1,2,3],[3,2,1]]
<strong>Output:</strong> 6
<strong>Explanations:</strong>
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
</pre>

#### Example 2:
<pre>
<strong>Input:</strong> accounts = [[1,5],[7,3],[3,5]]
<strong>Output:</strong> 10
<strong>Explanations:</strong>
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
</pre>

#### Example 3:
<pre>
<strong>Input:</strong> accounts = [[2,8,7],[7,1,3],[1,9,5]]
<strong>Output:</strong> 17
</pre>

### Constraints:

<ul>
  <li><code>m == accounts.length</code></li>
  <li><code>n == accounts[i].length</code></li>
  <li><code>1 &lt;= m, n &lt;= 50</code></li>
  <li><code>1 &lt;= accounts[i][j] &lt;= 100</code></li>
</ul>
</div>
