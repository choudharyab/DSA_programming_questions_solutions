package Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer >> ans = new ArrayList<>();
        ans =combinationSum(candidates,target);
        System.out.println(ans);
    }

    static List<List<Integer>> combinationSum(int [] candidates , int target){
        List < List < Integer >> ans = new ArrayList < > ();
        findCombination (0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    static void  findCombination(int index , int [] candidates ,int target , List<List<Integer>> ans , List<Integer> current){
        if(index == candidates.length){
            if(target == 0) {
                ans.add(new ArrayList<>(current));
            }
            return ;
        }

        if(candidates[index] <= target){
            current.add(candidates[index]);
            findCombination(index  , candidates,target-candidates[index],ans,current);
            current.remove(current.size() -1);
        }
        findCombination(index +1 , candidates,target,ans,current);


    }


}
