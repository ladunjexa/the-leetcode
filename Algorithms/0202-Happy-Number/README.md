<h2><a href="https://leetcode.com/problems/happy-number/">202. Happy Number</a></h2><h3>Easy</h3><hr><div><p>
Write an algorithm to determine if a number <code>n</code> is happy.

A <strong>happy number</strong> is a number defined by the following process:
<ul>
<li>Starting with any positive integer, replace the number by the sum of the squares of its digits.</li>
<li>Repeat the process until the number equals 1 (where it will stay), or it <code>loops endlessly in a cycle</code> which does not include 1.</li>
<li>Those numbers for which this process <code>ends in 1</code> are happy.</li>
</ul>
Return <code>true</code> if <code>n</code> is a happy number, and <code>false</code> if not.
</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 19
<strong>Output:</strong> true
<strong>Explaination:</strong>
1<sup>2</sup> + 9<sup>2</sup> = 82
8<sup>2</sup> + 2<sup>2</sup> = 68
6<sup>2</sup> + 8<sup>2</sup> = 100
1<sup>2</sup> + 0<sup>2</sup> + 02 = 1
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
</ul>
</div>