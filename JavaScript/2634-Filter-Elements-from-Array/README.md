<h2><a href="https://leetcode.com/problems/filter-elements-from-array/">2634. Filter Elements from Array</a></h2><h3>Easy</h3><hr><div><p>Given an integer array <code>arr</code> and a filtering function <code>fn</code>, return a new array with a fewer or equal number of elements.

The returned array should only contain elements where <code>fn(arr[i], i)</code> evaluated to a truthy value.

Please solve it without the built-in <code>Array.filter</code> method.
</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [0,10,20,30], fn = function greaterThan10(n) { return n > 10; }
<strong>Output:</strong> [20,30]
<strong>Explanation:</strong>
const newArray = filter(arr, fn); // [20, 30]
The function filters out values that are not greater than 10
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,3], fn = function firstIndex(n, i) { return i === 0; }
<strong>Output:</strong> [1]
<strong>Explanation:</strong>
fn can also accept the index of each element
In this case, the function removes elements not at index 0
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [-2,-1,0,1,2], fn = function plusOne(n) { return n + 1 }
<strong>Output:</strong> [-2,0,1,2]
<strong>Explanation:</strong>
Falsey values such as 0 should be filtered out
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>


<ul>
	<li><code>0 <= arr.length <= 1000</code></li>
    <li><code>-10<sup>9</sup> <= arr[i] <= 10<Sup>9</sup></code></li>
</ul>
</div>