## [374. Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)
### Easy
<hr/>

We are playing the Guess Game. The game is as follows:

I pick a number from <code>1</code> to <code>n</code>. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API <code>int guess(int num)</code>, which returns three possible results:

* -1: Your guess is higher than the number I picked (i.e. num > pick).
* 1: Your guess is lower than the number I picked (i.e. num < pick).
* 0: your guess is equal to the number I picked (i.e. num == pick).

Return <em>the number that I picked</em>.

#### Example 1:
<pre>
<strong>Input:</strong> n = 10, pick = 6
<strong>Output:</strong> 6
</pre>

#### Example 2:
<pre>
<strong>Input:</strong> n = 1, pick = 1
<strong>Output:</strong> 1
</pre>

#### Example 3:
<pre>
<strong>Input:</strong> n = 2, pick = 1
<strong>Output:</strong> 1
</pre>

### Constraints:

<ul>
  <li><code>1 &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
  <li><code>1 &lt;= pick &lt;= n</code></li>
</ul>
</div>
