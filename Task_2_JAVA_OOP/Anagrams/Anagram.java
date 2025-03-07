// Finding All Anagrams in a String
// Objective: Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
// Details: The goal is to develop a function that, given a string s and a non-empty string p, returns all the starting indices of the substrings in s that are anagrams of p. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, "abc" is an anagram of "bca".
// Functions to Implement:
// List<Integer> findAnagrams(String s, String p): Returns a list of starting indices of the anagrams of p in s.

import java.util.ArrayList;
import java.util.List;

public class Anagram {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (i >= p.length() - 1 && areArraysEqual(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private static boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
