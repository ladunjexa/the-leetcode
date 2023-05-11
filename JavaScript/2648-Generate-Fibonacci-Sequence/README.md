<h2><a href="https://leetcode.com/problems/generate-fibonacci-sequence/">2648. Generate Fibonacci Sequence</a></h2><h3>Easy</h3><hr><div><p>Write a generator function that returns a generator object which yields the <strong>fibonacci sequence</strong>.

The fibonacci sequence is defined by the relation <code>Xn = Xn-1 + Xn-2</code>.

The first few numbers of the series are <code>0, 1, 1, 2, 3, 5, 8, 13</code>.
</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> callCount = 5
<strong>Output:</strong> [0,1,1,2,3]
<strong>Explanation:</strong>
const gen = fibGenerator();
gen.next().value; // 0
gen.next().value; // 1
gen.next().value; // 1
gen.next().value; // 2
gen.next().value; // 3
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> callCount = 0
<strong>Output:</strong> []
<strong>Explanation:</strong> gen.next() is never called so nothing is outputted
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>


<ul>
	<li><code>0 <= callCount <= 50</code></li>
</ul>
</div>