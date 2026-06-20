//https://leetcode.com/problems/maximum-building-height/description/?envType=daily-question&envId=2026-06-20
/*
You want to build `n` new buildings in a city. The new buildings will be built in a line and are labeled from `1` to `n`.
However, there are city restrictions on the heights of the new buildings:

* The height of each building must be a non-negative integer.
* The height of the first building must be `0`.
* The height difference between any two adjacent buildings cannot exceed `1`.
Additionally, there are city restrictions on the maximum height of specific buildings. These restrictions are given as a 2D integer array `restrictions` where `restrictions[i] = [idi, maxHeighti]` indicates that building `idi` must have a height less than or equal to `maxHeighti`.
It is guaranteed that each building will appear at most once in `restrictions`, and building `1` will not be in `restrictions`.
Return the maximum possible height of the tallest building.

Logic

## The core idea

You want the tallest possible building somewhere in the line. The constraints are:
- Building 1 has height 0.
- Adjacent buildings differ by at most 1 (so height can climb or fall by at most 1 each step).
- Some buildings have a hard cap.

Think of it like water (or light) spreading out from fixed points. Every restriction is a "source" that can only let height grow by 1 per step as you move away from it. Building 1 is itself a restriction: height 0 at position 1.

So the **real question** at any position `i` is: *what's the smallest cap imposed on it by every restriction (including building 1), given that a restriction `k` steps away can allow at most `maxHeight + k`?*

The tallest possible height anywhere is bounded by the nearest constraints on both sides.

## Step 1: Normalize the restrictions

Add `[1, 0]` (the first building) and `[n, n-1]` (the last building has no explicit cap, so its theoretical max is `n-1`, since heights can rise by 1 per step from 0).

Sort all restrictions by building id. Now you have a sorted list of "checkpoints" with caps.

## Step 2: Make adjacent checkpoints consistent

Here's the key trick. Take two consecutive checkpoints `(id1, h1)` and `(id2, h2)`. The gap between them is `d = id2 - id1`.

Right now, `h2` might be "too generous" relative to `h1` — i.e., it might be impossible to actually reach `h2` from `h1` within `d` steps obeying the slope-1 rule. So we **tighten** both values:

- From the left: height at `id2` can be at most `h1 + d`.
- From the right: height at `id1` can be at most `h2 + d`.

So we update:
```
h1 = min(h1, h2 + d)
h2 = min(h2, h1 + d)   // using the OLD h1 before this line, careful with order
```

Doing a **left-to-right pass** propagates constraints forward, and a **right-to-left pass** propagates them backward. After both passes, every adjacent pair of checkpoints is mutually consistent (no checkpoint demands something impossible from its neighbor).

## Step 3: Find the peak between each pair

Once two adjacent checkpoints `(id1, h1)` and `(id2, h2)` are consistent, the **maximum height achievable strictly between them** is a classic "two mountains rising toward each other" problem:

```
peak = (h1 + h2 + d) / 2     // integer division
```

Why? Picture height rising from `h1` at rate 1, and height (going backward) rising from `h2` at rate 1. They meet somewhere in the middle, and that meeting point is the highest point you can reach without violating either side. This is exactly like the "candies" or "two ends climbing" pattern.

You compute this `peak` for every consecutive pair of checkpoints and take the overall max (also compare against each checkpoint's own height, in case the true peak is right at a checkpoint).

## Worked example

Say `n = 5`, `restrictions = [[2,1],[4,1]]`.

**Add boundary points:**
- `[1, 0]` (forced)
- `[2, 1]`
- `[4, 1]`
- `[5, 4]` (since `n-1 = 4`)

Sorted: `(1,0), (2,1), (4,1), (5,4)`

**Left-to-right pass** (tighten each next one based on previous):
- `(1,0)` stays `0`.
- `(2,1)`: `d=1`, so `h = min(1, 0+1) = 1`. Stays `(2,1)`.
- `(4,1)`: `d=2` from building 2, `h = min(1, 1+2) = 1`. Stays `(4,1)`.
- `(5,4)`: `d=1` from building 4, `h = min(4, 1+1) = 2`. Becomes `(5,2)`.

Now: `(1,0), (2,1), (4,1), (5,2)`

**Right-to-left pass** (tighten each previous one based on next):
- `(5,2)` stays.
- `(4,1)`: `d=1`, `h = min(1, 2+1) = 1`. Stays.
- `(2,1)`: `d=2`, `h = min(1, 1+2) = 1`. Stays.
- `(1,0)`: `d=1`, `h = min(0, 1+1) = 0`. Stays.

Final consistent checkpoints: `(1,0), (2,1), (4,1), (5,2)`

**Compute peaks between consecutive pairs:**
- Between `(1,0)` and `(2,1)`: `d=1`, peak `= (0+1+1)/2 = 1`
- Between `(2,1)` and `(4,1)`: `d=2`, peak `= (1+1+2)/2 = 2`
- Between `(4,1)` and `(5,2)`: `d=1`, peak `= (1+2+1)/2 = 2`

Max of all peaks and checkpoint heights = **2**.

So the answer is `2`. You could check this manually: heights `0,1,2,1,2` — adjacent diffs are all ≤1, building 2 is ≤1 ✓, building 4 is ≤1 ✓. Tallest is 2. 

Time complexity: O(m log m) for sorting `m` restrictions, then O(m) for the two passes — dominated by the sort.

 */

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>(Arrays.asList(restrictions));
        list.add(new int []{1,0});
        list.add(new int []{n,n-1}); // last building
        list.sort((a,b) -> a[0] - b[0]); //sort according to building

        //left to right pass
        for(int i = 1 ; i< list.size() ;i++){
            int d = list.get(i)[0] - list.get(i-1)[0]; //calculating the height difference
            list.get(i)[1] = Math.min(list.get(i)[1],list.get(i-1)[1] + d);
        }

        //right to left pass
        for(int i = list.size() -2 ;i >= 0 ;i--){
            int d = list.get(i+ 1)[0] - list.get(i)[0]; //calculating the height difference
            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i + 1)[1] + d);

        }

        int ans = 0 ;
        //find the max peak
        for(int i = 0 ; i < list.size() ;i++){
            ans = Math.max(ans,list.get(i)[1]);
            if( i > 0){
                int d = list.get(i)[0] - list.get(i - 1)[0];
                int h1 = list.get(i-1)[1];
                int h2 = list.get(i)[1];
                int peak = (h1 + h2 + d)/2;
                ans = Math.max(ans,peak); 
            }
        }



        return ans;
        
    }
}