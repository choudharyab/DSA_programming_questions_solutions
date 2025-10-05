//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/?envType=problem-list-v2&envId=sliding-window
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        //first merge list
        List<int[]> mergedLists = new ArrayList<>();
        for(int i = 0 ; i< nums.size();i++){
            for(int num : nums.get(i)){
                mergedLists.add(new int [] {num,i}); //[value,listIndex]
            }
        }

        //sort the list by numbers
        mergedLists.sort(Comparator.comparingInt(a -> a[0]));

        int k = nums.size();
        int left = 0 , coveredLists = 0 ;
        int [] freq = new int[k];
        int [] bestRange = new int [] {mergedLists.get(0)[0],mergedLists.get(mergedLists.size()-1)[0]};
        int minRange = bestRange[1] - bestRange[0] , maxRange = bestRange[1];

        //sliding windows
        for(int right = 0 ; right < mergedLists.size();right++){
            int [] rightPair = mergedLists.get(right);
            int rightVal = rightPair[0];
            int rightIndex = rightPair[1];

            if(freq[rightIndex] == 0) coveredLists++;
            freq[rightIndex]++;

            //all lists are covered with k lists shrink the window
            while(coveredLists == k && left <= right){
                int leftVal = mergedLists.get(left)[0];
                if((rightVal - leftVal ) < minRange){
                    minRange = rightVal - leftVal;
                    bestRange[0] = leftVal;
                    bestRange[1] = rightVal;
                }
                int leftIndex = mergedLists.get(left)[1];
                freq[leftIndex]--;
                if(freq[leftIndex] == 0) coveredLists--;
                left++;
            }

        }

        return bestRange;
        
    }
}

/*
### Example

**Input:**

```
nums = [
  [4,10,15,24,26],
  [0,9,12,20],
  [5,18,22,30]
]
```

**Output:**

```
[20,24]
```

**Explanation:**
Range `[20,24]` contains:

* `24` from list 1
* `20` from list 2
* `22` from list 3

Each list is represented → ✅

---

## 🔹 Intuition (Sliding Window over Merged Sorted List)

### Step 1: Merge all numbers with their list indices

We can’t just slide over each list separately.
So we **merge all numbers into one list** of pairs `(num, listIndex)`, then **sort it** by the numbers.

Example merged list:

```
[(0,1), (4,0), (5,2), (9,1), (10,0), (12,1), (15,0), (18,2), (20,1), (22,2), (24,0), (26,0), (30,2)]
```

---

### Step 2: Sliding Window Technique

Now it becomes a classic **minimum window containing all k types problem** (similar to "minimum window substring").

We’ll use a window `[left, right]` over this merged list and:

* Track how many unique lists are represented.
* Try to minimize the numeric range (`max - min`).

---

### Step 3: Maintain Count and Expand/Shrink Window

1. Expand the window by moving `right` to include new elements.
2. Keep a frequency map of which list indices are inside.
3. When the window covers **all k lists**,

   * Try to **shrink from left** to minimize the range.
4. Track the **smallest range difference**.

---

## ✅ Algorithm Steps

1. **Merge and sort all numbers with their list indices.**
2. **Initialize:**

   * `left = 0`
   * `countMap` (to track how many numbers from each list are in the current window)
   * `coveredLists = 0`
   * `minRange = [−10^5, 10^5]` (initial large range)
3. **Expand right pointer:**

   * Add element into window
   * If new list covered → increment `coveredLists`
4. **When all k lists are covered:**

   * Update smallest range if better
   * Shrink from left (try to remove redundant elements)
5. **Repeat until `right` reaches end.**

## 🕒 Complexity

| Metric    | Complexity                                                      |
| --------- | --------------------------------------------------------------- |
| **Time**  | O(N log N) — sorting all numbers (N = total count of all lists) |
| **Space** | O(N + K) — merged list + frequency array                        |

---

## 🧠 Summary of Intuition

| Step   | Concept                            |
| ------ | ---------------------------------- |
| Merge  | Combine all numbers with list ID   |
| Sort   | So we can slide over numeric order |
| Expand | Include new elements               |
| Shrink | Maintain minimal valid window      |
| Track  | Best (smallest) numeric difference |


 */