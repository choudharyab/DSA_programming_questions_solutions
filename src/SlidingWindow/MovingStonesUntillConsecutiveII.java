//https://leetcode.com/problems/moving-stones-until-consecutive-ii/description/?envType=problem-list-v2&envId=sliding-window

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;

        int max1 = stones[n-2] - stones[0] - (n-2);
        int max2 = stones[n-1] - stones[1] - (n-2);
        int maxMoves = Math.max(max1,max2);

        int minMoves = n ;
        int j = 0;

        for(int i = 0 ; i < n ;i++){
            while(j+1 < n && stones[j+1] - stones[i] + 1 <= n){
                j++;
                int winSize = j-i +1;
                if(winSize == n-1 && stones[j]- stones[i] + 1 == n-1){
                    minMoves = Math.min(minMoves,2);
                }else{
                    minMoves = Math.min(minMoves,n-winSize);
                }
            }
        }


        return new int [] {minMoves,maxMoves};
        
    }
}

/*
= max(stones[n-2] - stones[0] - (n-2),
      stones[n-1] - stones[1] - (n-2))

= max(6 - 3 - 3, 10 - 4 - 3)
= max(0, 3)
= 3

We use a sliding window to find the smallest range of consecutive numbers that can include all stones except maybe 1 or 2 that we need to move.

Intuition:

If we can fit most stones into a small “consecutive segment”, the rest can be moved there with fewer steps.

Algorithm:

Sort stones.

Slide a window [i, j] where stones[j] - stones[i] < n.

Count how many stones fit inside.

The number of moves = n - (number of stones inside window).

There’s a small special case when only one gap remains but the stones are almost consecutive — you might need 2 moves instead of 1.



| Left  | Right     | Range               | Stones in window            | Moves |
| ----- | --------- | ------------------- | --------------------------- | ----- |
| 4 → 9 | (9-4+1=6) | 3 stones in 6 range | 3-3=0 moves (too big range) |       |
| 4 → 7 | (7-4+1=4) | 2 stones in 4 range | 3-2=1 move                  |       |


 */