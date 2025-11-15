https://leetcode.com/problems/camelcase-matching/submissions/1830129024/?envType=problem-list-v2&envId=trie
class Solution {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
         List<Boolean> res = new ArrayList<>(queries.length);
        for (String q : queries) {
            res.add(matches(q, pattern));
        }
        return res;

    }

    private boolean matches(String query, String pattern) {
        int j = 0; // pointer on pattern
        for (int i = 0; i < query.length(); ++i) {
            char c = query.charAt(i);
            if (j < pattern.length() && c == pattern.charAt(j)) {
                j++;
            } else if (Character.isUpperCase(c)) {
                // uppercase letter that doesn't match next pattern char => fail
                return false;
            }
            // else lowercase and not matching pattern char -> just skip it
        }
        // pattern must be fully matched
        return j == pattern.length();
    }
}
