// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/?envType=daily-question&envId=2025-06-06


class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        StringBuilder t = new StringBuilder(); 
        StringBuilder paper = new StringBuilder(); 
        char[] smallestCharToRight = new char[n];
        smallestCharToRight[n - 1] = s.charAt(n - 1);

        
        for (int i = n - 2; i >= 0; i--) {
            smallestCharToRight[i] = (char) Math.min(s.charAt(i), smallestCharToRight[i + 1]);
        }

        int i = 0;
        while (i < n) {
            t.append(s.charAt(i));

           
            char minChar = (i + 1 < n) ? smallestCharToRight[i + 1] : s.charAt(i);

            
            while (t.length() > 0 && t.charAt(t.length() - 1) <= minChar) {
                paper.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1); 
            }

            i++;
        }

        
        while (t.length() > 0) {
            paper.append(t.charAt(t.length() - 1));
            t.deleteCharAt(t.length() - 1);
        }

        return paper.toString();
    }
}

// Time Complexity : O(N^2)
// Space Complexity : O(N)