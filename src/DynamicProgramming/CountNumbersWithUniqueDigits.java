//https://leetcode.com/problems/count-numbers-with-unique-digits/description/
/*solve with backtrack */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        boolean [] used = new boolean[10]; //0-9
        return 1 + solve(0,n,used); 
    }

    private int solve(int length , int n , boolean [] used){
        if( length == n) return 0;
        int count = 0 ;

        for(int digit = 0 ; digit<= 9 ;digit++){
            if(used[digit]) continue;
            if(length == 0 && digit == 0) continue;
            used[digit] = true;
            count += 1;
            count += solve(length + 1,n, used);
            used[digit] = false;
        }
        return count;
    }
}

/*Permutation */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int ans = 10; // for n = 1 we have 10 unique options
        int unique = 9 ;
        int available = 9;

        for(int i = 2 ; i <=n && available > 0 ;i ++){
            unique *= available;
            ans += unique;
            available--; 
        }

        return ans;

    }
}