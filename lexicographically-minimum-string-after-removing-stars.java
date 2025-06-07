// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/?envType=daily-question&envId=2025-06-07



class Solution {
    public String clearStars(String s) {
        int n = s.length();
        boolean[] keep = new boolean[n];
        TreeMap<Integer, Stack<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                int key = map.firstKey();
                Stack<Integer> st = map.get(key);
                int idx = st.pop();
                keep[idx] = false;

                if (st.isEmpty()) {
                    map.remove(key);
                }
                continue;
            }

            int v = ch - 'a';
            keep[i] = true;

            if (!map.containsKey(v)) {
                map.put(v, new Stack<>());
            }
            map.get(v).push(i);
        }

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (keep[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)