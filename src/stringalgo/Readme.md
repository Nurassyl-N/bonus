1. Introduction

This report presents the implementation, testing, and analysis of the Knuth–Morris–Pratt (KMP) string matching algorithm.
KMP is a classic linear-time pattern-searching algorithm that avoids redundant character comparisons by preprocessing the pattern and constructing the LPS (Longest Prefix Suffix) array.

The purpose of this bonus task is to demonstrate correct implementation, evaluate its behavior on different input sizes, and analyze complexity and performance.


2. Algorithm Overview

The string matching problem is defined as:
Given a text T of length n and a pattern P of length m, find all occurrences of P inside T.


2.1 KMP Core Idea

KMP improves searching by:
1.	Preprocessing the pattern and calculating the LPS array, where
LPS[i] = longest proper prefix of P[0..i] that is also a suffix
2.	Using LPS during mismatches to avoid rechecking characters that already matched.
3.	Achieving linear complexity O(n + m) for search.


2.2 LPS Array Example

Pattern: AAACAAAA
LPS: 0 1 2 0 1 2 3 3

This table allows the algorithm to “jump back” to the longest valid border instead of restarting from zero.


3. Testing on Three Inputs

To evaluate performance, the algorithm was tested on:
1.	Short string
2.	Medium string
3.	Long string

⸻

3.1 Test 1 — Short String

Text:  abcabc
Pattern:  abc

Step-by-step Explanation
1.	LPS for “abc”: [0,0,0]
2.	KMP scans текст:
•	text[0..2] = "abc" → match
•	continue
•	text[3..5] = "abc" → match

Output
Matches found at indices: [0, 3]
Why KMP is efficient here?
• No rechecks
• After mismatch it uses LPS and makes minimal shift
• Linear work on short text


Test 2 — Medium-Length String

Input

Text:   ABABDABACDABABCABAB
Pattern:   ABABCABAB

Explanation
1.	LPS is built for pattern →
Pattern: A B A B C A B A B
LPS:     0 0 1 2 0 1 2 3 4
2.	KMP processing text:
•	Matching starts around index 10
•	All 9 characters match (j == pattern length)

Output

Matches found at indices: [10]

Interpretation
• KMP avoids rewriting the first 4 characters every time (as it would be in a naive O(n*m) algorithm)
• LPS causes fast fallback j lps[j-1]


Test 3 — Long String

Input

Text:   "a" repeated 10000 times + "b"
Pattern:   aab

Why this particular test?

It shows the difference between:
• Naive O(n*m)   10000 3 = 30000 comparisons
• KMP O(n+m)   ~10003 comparisons and no rechecks

Explanation
1.  10,000 characters "a"   many false prefixes
2.  LPS for "aab" = [0.1.0]
3.  The algorithm works as follows:
• Every "aa" match goes to LPS-1
• Next character is being checked
• The only match is at the end:
"aa" ends with the last "b"

Output

Matches found at indices: [9998]

Behavior under long input
• The algorithm is strictly linear
• No cycle restarts
• Almost constant number of iteration transactions


Global Analysis of KMP Based on These Tests

Time Complexity
![img.png](img.png)

Space Complexity
O(m)
Only the LPS array is required additionally.

KMP Behavior
• On the short line works quickly, but the difference with naive is minimal.
• At the middle - you can see acceleration due to LPS folbecka.
• The long - huge time savings:
Not a single "restart".


4. Complexity Analysis
![img_1.png](img_1.png)

