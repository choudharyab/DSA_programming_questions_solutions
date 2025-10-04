//https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/
import java.util.*;

class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int i = 0;
        int minCard = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for (int j = 0; j < n; j++) {
            // If duplicate found, shrink window from left until duplicate is removed
            while (set.contains(cards[j])) {
                minCard = Math.min(minCard, j - i + 1);
                set.remove(cards[i]);
                i++;
            }

            set.add(cards[j]);
        }

        return minCard == Integer.MAX_VALUE ? -1 : minCard;
    }
}
