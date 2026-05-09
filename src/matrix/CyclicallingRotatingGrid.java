/*## Walkthrough with a Concrete Example

Let's use this **4×4 grid** with **k = 1**:

```
 1  2  3  4
 5  6  7  8
 9 10 11 12
13 14 15 16
```

---
## Step 1: How Many Layers?

```
numLayers = min(4, 4) / 2 = 2
```
So we have **Layer 0** (outer ring) and **Layer 1** (inner ring).
<br>

## Step 2: Process Layer 0 (Outer Ring)

**Boundaries:**
```
top=0, bottom=3, left=0, right=3
```

### Extract — Walk 4 sides:

```
Top row    (row=0, col 0→3):   [1,  2,  3,  4]
Right col  (col=3, row 1→3):   [8, 12, 16]
Bottom row (row=3, col 2→0):   [15, 14, 13]
Left col   (col=0, row 2→1):   [9,  5]
```

**Unrolled Layer 0:**
```
index: [ 0   1   2   3   4   5   6   7   8   9  10  11  12  13]
value: [ 1   2   3   4   8  12  16  15  14  13   9   5   ... ]
```

Wait, let me count all elements: top(4) + right(3) + bottom(3) + left(2) = **12 elements**

```
index: [ 0   1   2   3   4   5   6   7   8   9  10  11]
value: [ 1   2   3   4   8  12  16  15  14  13   9   5]
```

### Rotate (k=1, L=12, shift = 1%12 = 1):

```
Original: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5]
           ^
           shift=1, so chop here

Rotated:  [2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 1]
            └──────────────────────────────┘  └──┘
                   elements[1..11]           elements[0..0]
```

### Write Back (same traversal order):

```
Top row    → grid[0][0..3]  = 2,  3,  4,  8
Right col  → grid[1..3][3]  = 12, 16, 15
Bottom row → grid[3][2..0]  = 14, 13,  9
Left col   → grid[2..1][0]  =  5,  1
```

**Grid after Layer 0:**
```
 2  3  4  8
 1  6  7 12
 5 10 11 16
 9 14 15 15   ← wait let's be precise
```

Let me map it cell by cell:

```
idx  val  →  cell
 0    2   →  grid[0][0]
 1    3   →  grid[0][1]
 2    4   →  grid[0][2]
 3    8   →  grid[0][3]
 4   12   →  grid[1][3]
 5   16   →  grid[2][3]
 6   15   →  grid[3][3]
 7   14   →  grid[3][2]
 8   13   →  grid[3][1]
 9    9   →  grid[3][0]
10    5   →  grid[2][0]
11    1   →  grid[1][0]
```

**Grid after Layer 0 done:**
```
 2  3  4  8
 1  6  7 12
 5 10 11 16
 9 13 14 15
```

---

## Step 3: Process Layer 1 (Inner Ring)

**Boundaries:**
```
top=1, bottom=2, left=1, right=2
```

### Extract — Walk 4 sides:

```
Top row    (row=1, col 1→2):  [6, 7]
Right col  (col=2, row 2→2):  [11]
Bottom row (row=2, col 1→1):  [10]
Left col   (col=1, row 1→1):  []   ← (bottom-1=1, top+1=2, no iterations)
```

**Unrolled Layer 1:**
```
index: [0   1   2   3]
value: [6   7  11  10]
```

### Rotate (k=1, L=4, shift = 1%4 = 1):

```
Original: [6,  7, 11, 10]
Rotated:  [7, 11, 10,  6]
```

### Write Back:

```
idx  val  →  cell
 0    7   →  grid[1][1]
 1   11   →  grid[1][2]
 2   10   →  grid[2][2]
 3    6   →  grid[2][1]
```

---

## Final Result

```
Before:          After k=1 CCW rotation:
 1  2  3  4        2  3  4  8
 5  6  7  8   →    1  7 11 12
 9 10 11 12        5  6 10 16
13 14 15 16        9 13 14 15
```

---

## Visual Summary of What Happened

```
OUTER RING shifted CCW by 1:        INNER RING shifted CCW by 1:

 1→ 2→ 3→ 4                              6→ 7
          ↓                              ↑     ↓
 5       8  (was 4)                      10   11
 ↑                                       ↑     ↓
 9      12  (was 8)                       └─10─┘
 ↑          ↓                           (10 stays, ring rotates)
13← 14← 15← 16
```

Every element just **steps one position forward** along the ring — that's all cyclic rotation is! 🎯*/
// /https://leetcode.com/problems/cyclically-rotating-a-grid/?envType=daily-question&envId=2026-05-09

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int numLayers = Math.min(m,n) / 2 ;

        for (int layer = 0; layer < numLayers; layer++) {
            // Step 1: Extract the layer into a list
            List<Integer> elements = extractLayer(grid, layer, m, n);

            // Step 2: Rotate the list
            int L = elements.size();
            int shift = k % L;
            List<Integer> rotated = new ArrayList<>();
            // Counter-clockwise = shift elements left by k (head moves to tail)
            for (int i = shift; i < L; i++) rotated.add(elements.get(i));
            for (int i = 0; i < shift; i++) rotated.add(elements.get(i));

            // Step 3: Write back
            writeLayer(grid, layer, m, n, rotated);
        }

        return grid;
    
        
    }

    
    // Traverse layer counter-clockwise: Top → Left → Bottom → Right
    private List<Integer> extractLayer(int[][] grid, int layer, int m, int n) {
        List<Integer> res = new ArrayList<>();

        int top = layer, bottom = m - 1 - layer;
        int left = layer, right = n - 1 - layer;

        // Top row: left → right
        for (int col = left; col <= right; col++)
            res.add(grid[top][col]);

        // Right col: top+1 → bottom
        for (int row = top + 1; row <= bottom; row++)
            res.add(grid[row][right]);

        // Bottom row: right-1 → left
        for (int col = right - 1; col >= left; col--)
            res.add(grid[bottom][col]);

        // Left col: bottom-1 → top+1
        for (int row = bottom - 1; row >= top + 1; row--)
            res.add(grid[row][left]);

        return res;
    }

    private void writeLayer(int[][] grid, int layer, int m, int n, List<Integer> vals) {
        int top = layer, bottom = m - 1 - layer;
        int left = layer, right = n - 1 - layer;
        int idx = 0;

        for (int col = left; col <= right; col++)
            grid[top][col] = vals.get(idx++);

        for (int row = top + 1; row <= bottom; row++)
            grid[row][right] = vals.get(idx++);

        for (int col = right - 1; col >= left; col--)
            grid[bottom][col] = vals.get(idx++);

        for (int row = bottom - 1; row >= top + 1; row--)
            grid[row][left] = vals.get(idx++);
    }

}