## [1342. Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)
### Easy
<hr/>

Given an integer <code>num</code>, return <em>the number of steps to reduce it to zero</em>.
<br/>

In one step, if the current number is even, you have to divide it by <code>2</code>, otherwise, you have to subtract <code>1</code> from it.

#### Example 1:
<pre>
<strong>Input:</strong> num = 14
<strong>Output:</strong> 6
<strong>Explanations:</strong>
Step 1) 14 is even; divide by 2 and obtain 7. 
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3. 
Step 4) 3 is odd; subtract 1 and obtain 2. 
Step 5) 2 is even; divide by 2 and obtain 1. 
Step 6) 1 is odd; subtract 1 and obtain 0.
</pre>

#### Example 2:
<pre>
<strong>Input:</strong> num = 8
<strong>Output:</strong> 4
<strong>Explanations:</strong>
Step 1) 8 is even; divide by 2 and obtain 4. 
Step 2) 4 is even; divide by 2 and obtain 2. 
Step 3) 2 is even; divide by 2 and obtain 1. 
Step 4) 1 is odd; subtract 1 and obtain 0.
</pre>

#### Example 3:
<pre>
<strong>Input:</strong> num = 123
<strong>Output:</strong> 12
</pre>

### Constraints:

<ul>
  <li><code>0 &lt;= num &lt;= 10<sup>6</sup></code></li>
</ul>
</div>
