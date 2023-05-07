package Permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<List<Integer>> permute(int [] nums){
        List<List<Integer>> ans = new ArrayList<>();
        recursionCall(0,nums,ans);
        return ans;
    }

    public static  void recursionCall(int index , int [] nums , List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i =0 ;i< nums.length;i++){
                ds.add(nums[i]);
            }
            if(!ans.contains(ds)) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        for(int i = index ;i< nums.length;i++){
            swap(i,index,nums);
            recursionCall(index +1 , nums,ans);
            swap(i,index,nums);
        }


    }

    public static void swap(int i , int j ,int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }
}
