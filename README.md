Report
1. Algorithm Overview
KMP avoids redundant comparisons by preprocessing the pattern.
LPS Array
The LPS (Longest Prefix Suffix) array stores, for each index i, the length of the longest proper prefix of P[0..i] that is also a suffix.
Example:
Pattern: AAACAAAA
LPS: 0 1 2 0 1 2 3 3
This enables the algorithm to fall back efficiently instead of restarting after mismatches.
Complexity
•	Preprocessing: O(m)
•	Searching: O(n)
Total: O(n + m)
Space: O(m)
2. Testing on Three Inputs
To evaluate performance, the algorithm was tested on:
	1.	Short string
	2.	Medium string
	3.	Long string
Short Input
Text: abcabc
Pattern: abc
Result: matches at indices 0, 3
KMP performs linear scanning with no backtracking.
Medium Input
Text: ABABDABACDABABCABAB
Pattern: ABABCABAB
Result: match at 10
The LPS array significantly reduces unnecessary comparisons.
Long Input
Text: "a" repeated 10000 times + "b"
Pattern: aab
Result: match at 9998
Even on highly repetitive input, KMP remains strictly linear and avoids O(n·m) behavior seen in naive algorithms.
3. Complexity Analysis
Time Complexity
•	Preprocessing (LPS): O(m)
•	Searching: O(n)
•	Total: O(n + m)
Space Complexity
•	LPS array: O(m)
•	No additional buffers or recursion are required.
Across all tests:
•	Short input → linear time, minimal overhead
•	Medium input → visible benefit from prefix reuse
•	Long input → large performance advantage; no re-scanning
KMP consistently demonstrates deterministic linear performance.
4. Conclusion
The KMP algorithm is efficient, lightweight, and reliable for pattern searching in large texts. Its use of the LPS array eliminates redundant comparisons and ensures O(n + m) time complexity. Testing on short, medium, and long strings confirms stable and optimal behavior, making KMP a strong choice for large-scale string processing.

<img width="716" height="117" alt="image" src="https://github.com/user-attachments/assets/a21a13ba-2786-4791-9a48-8778661c94fe" />

