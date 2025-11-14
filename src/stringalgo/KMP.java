package stringalgo;

import java.util.*;

public class KMP {

    /**
     * Builds the LPS (Longest Prefix Suffix) array for the pattern.
     * lps[i] = longest proper prefix of pattern[0..i]
     *          which is also a suffix of pattern[0..i]
     *
     * Time: O(m)
     */
    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;      // length of current longest prefix
        int i = 1;        // lps[0] = 0 by definition

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    /**
     * Searches for all occurrences of pattern inside text using the KMP algorithm.
     *
     * @return List of starting indices where pattern appears in text.
     * Time: O(n + m)
     */
    public static List<Integer> search(String text, String pattern) {

        List<Integer> result = new ArrayList<>();

        if (pattern.isEmpty() || text.isEmpty())
            return result;

        int[] lps = buildLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    result.add(i - j);     // FULL MATCH FOUND
                    j = lps[j - 1];       // continue searching
                }

            } else {
                if (j != 0) {
                    j = lps[j - 1];        // fallback using LPS
                } else {
                    i++;                   // move in text
                }
            }
        }

        return result;
    }

    //Testing

    public static void main(String[] args) {

        // SHORT STRING
        test("abcabc", "abc");

        // MEDIUM STRING
        test("ABABDABACDABABCABAB", "ABABCABAB");

        // LONG STRING
        test("a".repeat(10000) + "b", "aab");

    }

    private static void test(String text, String pattern) {
        System.out.println("TEXT (length=" + text.length() + "): ");

        if (text.length() <= 100)
            System.out.println(text);
        else
            System.out.println(text.substring(0, 60) + "...");

        System.out.println("PATTERN: " + pattern);

        List<Integer> matches = search(text, pattern);

        System.out.println("Matches found at indices: " + matches);
        System.out.println("-------------------------------------------");
    }
}
