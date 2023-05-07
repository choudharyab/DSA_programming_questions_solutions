import java.util.ArrayList;

public class houseRobber {

    static int solve(ArrayList<Integer> arr){
        int n = arr.size();
        int prev = arr.get(0);
        int prev2 = 0;

        for(int i=1 ;i<n ;i++){
            int pick = arr.get(i);
            if(i > 1) pick+= prev;

            int notPicked = 0 + prev2;

            int curr = Math.max(pick,notPicked);
            prev2 = prev;
            prev = curr;
        }

        return prev;

    }
    public static void main(String[] args) {
        int[] arr =  {1,2,3,1};
        int n = arr.length;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i !=0) arr1.add(arr[i]);
            if(i != n-1) arr2.add(arr[i]);
        }

        int ans1 = solve(arr1);
        int ans2 = solve(arr2);

        System.out.println("max " + Math.max(ans1,ans2));
    }
}
