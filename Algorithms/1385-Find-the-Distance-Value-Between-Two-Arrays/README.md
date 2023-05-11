## [1385. Find the Distance Value Between Two Arrays](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/)
### Easy
<hr/>
Given two integer arrays <code>arr1</code> and <code>arr2</code>, and the integer <code>d</code>, return <em>the distance value between the two arrays</em>.

The distance value is defined as the number of elements <code>arr1[i]</code> such that there is not any element <code>arr2[j]</code> where <code>|arr1[i] - arr2[j]| &lt;= d</code>.

#### Example 1:
<pre>
<strong>Input:</strong> arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
<strong>Output:</strong> 2
<strong>Explanations:</strong>
For arr1[0]=4 we have: 
|4-10|=6 > d=2 
|4-9|=5 > d=2 
|4-1|=3 > d=2 
|4-8|=4 > d=2 
For arr1[1]=5 we have: 
|5-10|=5 > d=2 
|5-9|=4 > d=2 
|5-1|=4 > d=2 
|5-8|=3 > d=2
For arr1[2]=8 we have:
|8-10|=2 <= d=2
|8-9|=1 <= d=2
|8-1|=7 > d=2
|8-8|=0 <= d=2
</pre>

#### Example 2:
<pre>
<strong>Input:</strong> arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
<strong>Output:</strong> 2
</pre>

#### Example 3:
<pre>
<strong>Input:</strong> arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
<strong>Output:</strong> 1
</pre>

### Constraints:
* <code>1 &lt;= arr1.length, arr2.length &lt;= 500</code>
* <code>-1000 &lt;= arr1[i], arr2[j] &lt;= 1000</code>
* <code>0 &lt;= d &lt;= 100</code>
