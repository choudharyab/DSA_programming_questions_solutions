import java.util.*;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSumArr = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for(int j=i+1;j<nums.length-2;j++) {
                int left = j + 1;
                int right = nums.length - 1;
               // long sum = nums[i] + nums[j];
                while (left < right) {
                    List<Integer> addSum = new ArrayList<>();
                    System.out.println("i===> "+nums[i]);
                    long ab = nums[i] + nums [j];
                    System.out.println("j===> "+ ab);
                     ab = ab+ nums[left];

                    System.out.println("l===> "+ab);
                    ab = ab+ nums[right];
                    System.out.println("i===> "+ab);
                    long sum = nums[i] + nums[j];
                     sum = sum + nums[left] + nums[right];
                    if (target == sum) {
                        addSum.add(nums[i]);
                        addSum.add(nums[j]);
                        addSum.add(nums[left]);
                        addSum.add(nums[right]);
                        if(!fourSumArr.contains(addSum)){
                            fourSumArr.add(addSum);
                        }
                       // fourSumArr.add(addSum);
                        left++;right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                  //  fourSumArr.add(addSum);
                }
            }

        }
        return fourSumArr;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        Arrays.sort(arr);
        int target = 0;
        List<List<Integer>> arrSum = new ArrayList<>();
        arrSum =  fourSum(arr,target);
        System.out.println("arrSum----> " + arrSum);

    }
}
