import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumAdvanced {

    public  static  int fourSumCount(int[] nums1 ,int[] nums2,int[] nums3,int[] nums4){
        Map<Integer ,Integer> map = new HashMap<Integer,Integer>();
        for(int a : nums1){
            for(int b : nums2){
                int sum = a + b;
                map.put(sum,map.getOrDefault(sum,0) +1);
            }
        }
        int res = 0;
        for(int a : nums3){
            for(int b : nums4){
                int sum = -a - b;
                res += map.getOrDefault(sum,0);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        int ans = fourSumCount(nums1,nums2,nums3,nums4);
        System.out.println("Ans-----> "+ ans);
    }
}
