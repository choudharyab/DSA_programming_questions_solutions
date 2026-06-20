//https://leetcode.com/problems/candy/description/
/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.


Let's walk through **Candy (LeetCode 135)** — it uses the *exact same* two-pass tightening idea you just saw, just in a slightly different costume.

## The problem

You have `n` children standing in a line, each with a `rating[i]`. You must give each child at least 1 candy, and any child with a higher rating than a neighbor must get more candies than that neighbor. Find the minimum total candies needed.

## Connecting it to the building problem

In the building problem, the rule was: *adjacent heights can differ by at most 1*. Here, the rule is: *if your neighbor has a lower rating, you must have strictly more candies than them*. Both are **local constraints between neighbors** that need to be made globally consistent — and both are solved by sweeping left-to-right, then right-to-left.

## Intuition

Think about *why* one pass isn't enough.

If you only sweep left-to-right: whenever `rating[i] > rating[i-1]`, you set `candy[i] = candy[i-1] + 1`. This correctly handles all "increasing" stretches. But it completely ignores decreasing stretches — a child whose rating is higher than the child *after* them won't get bumped up by anything in this pass.

So you need a second pass, right-to-left, to fix the decreasing stretches: whenever `rating[i] > rating[i+1]`, you need `candy[i] > candy[i+1]`. But you can't just blindly set `candy[i] = candy[i+1] + 1` — what if the left-to-right pass already gave `candy[i]` something bigger (because `rating[i] > rating[i-1]` too)? You must **take the max** of what's already there and what the right-to-left rule demands.

That "take the max instead of overwrite" step is the same spirit as the `min()` tightening in the building problem — each pass enforces one direction's constraint, and you combine both directions to satisfy everyone simultaneously.

## Worked example

`ratings = [1, 0, 2]`

**Initialize:** everyone gets 1 candy → `candy = [1, 1, 1]`

**Left-to-right pass** (fixes "rises"):
- `i=1`: `rating[1]=0`, `rating[0]=1` → not a rise, skip.
- `i=2`: `rating[2]=2 > rating[1]=0` → rise! `candy[2] = candy[1] + 1 = 2`

`candy = [1, 1, 2]`

**Right-to-left pass** (fixes "falls", taking max):
- `i=1`: `rating[1]=0 < rating[2]=2`? No wait — we check `rating[i] > rating[i+1]`. `rating[1]=0`, `rating[2]=2`. `0 > 2`? No. Skip.
- `i=0`: `rating[0]=1 > rating[1]=0`? Yes! So `candy[0] = max(candy[0], candy[1]+1) = max(1, 2) = 2`

`candy = [2, 1, 2]`

**Total = 2 + 1 + 2 = 5**

Sanity check: child 0 (rating 1) has more candy than child 1 (rating 0) ✓. Child 2 (rating 2) has more candy than child 1 (rating 0) ✓. Minimal and valid.


O(n) time, O(n) space (can be optimized to O(1) extra space with a slope-tracking trick, but the two-array version is the one to understand first).

## The shared pattern, made explicit

| | Building problem | Candy problem |
|---|---|---|
| Local rule | `|h[i] - h[i+1]| <= 1` | higher rating ⇒ strictly more candy |
| Left-to-right pass | tighten cap using left neighbor | raise candy using left neighbor (rises) |
| Right-to-left pass | tighten cap using right neighbor | raise candy using right neighbor (falls) |
| Combine | `min()` (cap can only shrink) | `max()` (candy can only grow) |

Once you see this shape — **"a sequence with pairwise neighbor constraints, solved by two directional sweeps that get merged"** — you'll start recognizing it instantly. It shows up under very different surface stories (heights, candies, light/water spreading, valid bracket-like sequences).
 */


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] candy = new int[n];
        Arrays.fill(candy,1);
        
        //left to right pass slighly increasing order
        for(int i = 1 ; i< n ;i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }

        //right to left where failling handle ratings

        for(int i = n - 2 ; i>= 0 ;i--){
            if(ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i],candy[i+1] +1);
            }
        }

        int total = 0;
        for(int i = 0 ; i< candy.length;i++){
            total += candy[i];
        }

        return total;
        
    }
}