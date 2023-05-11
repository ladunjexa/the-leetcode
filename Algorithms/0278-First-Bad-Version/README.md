<h2><a href="https://leetcode.com/problems/first-bad-version/">278. First Bad Version</a></h2><h3>Easy</h3><hr><div><p>
Given an integer array <code>nums</code> sorted in <strong>non-decreasing</strong> order, return <em>an array of the <strong>squares of each number</strong> sorted in non-decreasing order.</em>
</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 5, bad = 4
<strong>Output:</strong> 4
<strong>Explanation:</strong>
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1, bad = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
    <li><code>1 &lt;= bad &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
</ul>

</div>
