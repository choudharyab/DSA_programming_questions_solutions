//https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=problem-list-v2&envId=sliding-window
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0 ;
        int zeroCount = 0 ;
        int maxLength =  0;
        

        for(int right = 0 ;  right < n ;right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            

            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength,right - left +1);




        }

        return maxLength;
        
    }
}


/*
| right | nums[right] | zeroCount  | left | window          | maxLen |
| ----- | ----------- | ---------- | ---- | --------------- | ------ |
| 0     | 1           | 0          | 0    | [1]             | 1      |
| 1     | 1           | 0          | 0    | [1,1]           | 2      |
| 2     | 1           | 0          | 0    | [1,1,1]         | 3      |
| 3     | 0           | 1          | 0    | [1,1,1,0]       | 4      |
| 4     | 0           | 2          | 0    | [1,1,1,0,0]     | 5      |
| 5     | 0           | 3 → shrink | 3    | [0,0,0,1,1,1,1] | 6      |

 */