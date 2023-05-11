## [744. Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)
### Easy
<hr/>
You are given an array of characters <code>letters</code> that is sorted in <strong>non-decreasing order</strong>, and a character <code>target</code>. There are <strong>at least two different</strong> characters in letters.

Return <em>the smallest character in <code>letters</code> that is lexicographically greater than <code>target</code></em>. If such a character does not exist, return the first character in <code>letters</code>.

#### Example 1:
<img src="https://assets.leetcode.com/uploads/2019/02/14/116_sample.png" width="auto" />
<pre>
<strong>Input:</strong> letters = ["c","f","j"], target = "a"
<strong>Output:</strong> "c"
<strong>Explanations:</strong> The smallest character that is lexicographically greater than 'a' in letters is 'c'.
</pre>

#### Example 2:
<pre>
<strong>Input:</strong> letters = ["c","f","j"], target = "c"
<strong>Output:</strong> "f"
<strong>Explanations:</strong> The smallest character that is lexicographically greater than 'c' in letters is 'f'.
</pre>

#### Example 3:
<pre>
<strong>Input:</strong> letters = ["x","x","y","y"], target = "z"
<strong>Output:</strong> "x"
<strong>Explanations:</strong> There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
</pre>

### Constraints:
* <code>2 &lt;= letters.length &lt;= 10<sup>4</sup></code>
* <code>letters[i]</code> is a lowercase English letter.
* <code>letters</code> is sorted in <strong>non-decreasing order</strong>.
* <code>letters</code> contains at least two different characters.
* <code>target</code> is a lowercase English letter.
