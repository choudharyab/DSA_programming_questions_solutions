public class longestMountain {
//https://leetcode.com/problems/longest-mountain-in-array/
    static int findingLongestMountain(int[] arr,int n ){
        int max = 0 ;
        for(int i=1 ;i<n-1;i++){
            for(int j= i ;(j<i+1 && (i+1 <= n));j++){
                int currentCount = 0;
                if(arr[j-1] < arr[j] && arr[j] > arr[j+1]){
                    currentCount =+1;
                    if(currentCount > max){
                        max = currentCount;
                    }
                }

            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
        int n = arr.length;
        int ansArray = findingLongestMountain(arr,n);
        System.out.println("Ans " + ansArray);
    }
}
