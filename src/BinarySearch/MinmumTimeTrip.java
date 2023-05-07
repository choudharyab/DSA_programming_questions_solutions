package BinarySearch;
/* https://leetcode.com/problems/minimum-time-to-complete-trips/description/*/
public class MinmumTimeTrip {
    static long minimumTime(int [] time , int totalTrips){
        long start = 0 ;
        long end = (long) 1e9;
        long ans = end ;

        while (start < end){
            long mid = start + (end - start)/2;
            long count = 0;
            for(int i = 0 ;i< time.length;i++){
                count += mid/time[i];
            }

            if(count >= totalTrips){
                ans = Math.min(ans , mid);
                end = mid ;
            }else{
                start = mid +1;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int [] time ={10000};
        int totalTrips = 10000000;
        long ans = minimumTime(time,totalTrips);
        System.out.println(ans);
    }
}
