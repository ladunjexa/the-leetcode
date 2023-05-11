### [View](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solutions/3490974/java-well-detailed-two-pointers-runtime-beats-98-80-1ms-memory-beats-81-31-45-1mb/) discussion on leetcode

<h2><a href="[https://leetcode.com/problems/move-zeroes/](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solutions/)">167. Two Sum II - Input Array Is Sorted</a></h2><h3>Medium</h3><hr><div><p>
  Given a <strong>1-indexed</strong> array of integers numbers that is already <strong>sorted in non-decreasing order</strong>, find two numbers such that they add up to a specific <code>target</code> number. Let these two numbers be <code>numbers[index<sub>1</sub>]</code> and <code>numbers[index<sub>2</sub>]</code> where <code>1 &lt;= index1 &lt; index2 &lt;= numbers.length</code>.

  <em>Return the indices of the two numbers, <code>index<sub>1</sub></code> and <code>index<sub>2</sub></code>, <strong>added by one</strong> as an integer array <code>[index<sub>1</sub>, index<sub>2</sub>]</code> of length 2.</em>
  
  The tests are generated such that there is exactly <strong>one solution</strong>. You <strong>may not</strong> use the same element twice.

Your solution must use only constant extra space.
</p>
  
<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> numbers = [2,7,11,15], target = 9
<strong>Output:</strong> [1,2]
<strong>Explanations:</strong> The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> numbers = [2,3,4], target = 6
<strong>Output:</strong> [1,3]
<strong>Explanations:</strong> The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> numbers = [-1,0], target = -1
<strong>Output:</strong> [1,2]
<strong>Explanations:</strong> The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
</pre>
  
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
    <li><code>2 &lt;= nums.length &lt;= 3*10<sup>4</sup></code></li>
    <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
    <li><code>numbers</code> is sorted in <strong>non-decreasing order</strong>.</li>
  <li>The tests are generated such that there is <strong>exactly one solution</strong>.</li>
</ul>
