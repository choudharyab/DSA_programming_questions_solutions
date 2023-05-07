package Permutation;

import java.util.ArrayList;

/**
 * understanding logic how below code works with example
 *  arr = [1,2,3,4,5,6]  target =4  In how many ways target can be made
 *  let take element or ignore element
 *   ""/4 -> 1/3 -> 11/2 ->111/1 -> 1111/0
 *   ""/4 -> 1/3 -> 11/2 -> 112/0
 * **/
public class Dice {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int target = 4;
//        totalCombination(arr,target,"");
   //     totalCombinationS(arr,target,"");
       System.out.println(totalCombinationS(arr,target,""));
    }

    static void totalCombination(int[] arr , int target,String up){
        if(target == 0) {
            System.out.println(up);
            return ;
        }

        for(int i=1 ;i<=arr.length && i<=target;i++){
            totalCombination(arr,target-i,up+i);
        }
    }

    static ArrayList<String> totalCombinationS(int[] arr ,int target, String up){
         if(target == 0){
             ArrayList<String> list = new ArrayList<>();
             list.add(up);
             return list;
         }

         ArrayList<String> list = new ArrayList<>();
         for(int i = 1; i <= arr.length && i <= target;i++){
             list.addAll(totalCombinationS(arr,target-i,up+i));
         }
         return list;
    }


}
