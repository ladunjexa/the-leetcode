## [852. Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)
### Medium
<hr/>

An array <code>arr</code> a mountain if the following properties hold:

* <code>arr.length >= 3</code>
* There exists some <code>i</code> with <code>0 < i < arr.length - 1</code> such that:
  * <code>arr[0] < arr[1] < ... < arr[i - 1] < arr[i]</code>
  * <code>arr[i] > arr[i + 1] > ... > arr[arr.length - 1]</code>

Given a mountain array <code>arr</code>, return the index <code>i</code> such that <code>arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]</code>.

You must solve it in <code>O(log(arr.length))</code> time complexity.

#### Example 1:
<pre>
<strong>Input:</strong> arr = [0,1,0]
<strong>Output:</strong> 1
</pre>

#### Example 2:
<pre>
<strong>Input:</strong> arr = [0,2,1,0]
<strong>Output:</strong> 1
</pre>

#### Example 3:
<pre>
<strong>Input:</strong> arr = [0,10,5,2]
<strong>Output:</strong> 1
</pre>

### Constraints:

<ul>
  <li><code>3 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
  <li><code>0 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
  <li><code>arr</code> is guaranteed to be a mountain array.</li>
</ul>
</div>
