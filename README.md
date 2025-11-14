REPORT

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

3.1 Short String
	•	Text: abcabc
	•	Pattern: abc
	•	Output: matches at [0, 3]
The algorithm processes short inputs almost instantly and behaves similarly to the naive approach, but without redundant checks.

3.2 Medium String
	•	Text: ABABDABACDABABCABAB
	•	Pattern: ABABCABAB
	•	Output: match at [10]
Here, the advantage of KMP becomes visible: the LPS array avoids repeated scanning of the same prefix, unlike the naive O(n·m) method.

3.3 Long String
	•	Text: "a" repeated 10,000 times + "b"
	•	Pattern: aab
	•	Output: match at [9998]
This case demonstrates the algorithm’s efficiency on repetitive data.
A naive approach would make ~30,000 comparisons; KMP completes in roughly ~10,003 operations (strictly linear).




4. Complexity Analysis
<img width="716" height="117" alt="image" src="https://github.com/user-attachments/assets/a21a13ba-2786-4791-9a48-8778661c94fe" />

Performance Summary

<img width="206" height="133" alt="image" src="https://github.com/user-attachments/assets/15ffee3d-1f1f-48e4-9ea7-3faa751c4039" />


5. Conclusion
The KMP algorithm is efficient, lightweight, and reliable for pattern searching in large texts. Its use of the LPS array eliminates redundant comparisons and ensures O(n + m) time complexity. Testing on short, medium, and long strings confirms stable and optimal behavior, making KMP a strong choice for large-scale string processing.

