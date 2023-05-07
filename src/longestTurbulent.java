public class longestTurbulent {
    public static void main(String[] args) {
       // int [] arr = {9,4,2,10,7,8,8,1,9};
        int [] arr = {2,0,2,4,2,5,0,1,2,3};
        int ans = longestTurbulent_constant(arr);
        System.out.println("Ans----> " + ans);
    }

    public static int longestTurbulent_constant(int[] arr){
        int n = arr.length;
        int smaller = 1 , greater = 1;
        int result = 1 ;

        for(int i = 1 ;i< n ;i++){
            int smaller1 = 1 , greater1 = 1;
            if(arr[i] > arr[i-1]){
                greater1 = smaller + 1;
            }else if(arr[i] < arr[i-1]) {
                smaller1 = greater + 1;
            }
            result = Math.max(result , Math.max(greater1,smaller1));
            smaller = smaller1;
            greater = greater1;
        }
        return result;
    }

    public static int longestTurbulent(int[] arr) {
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1 ; dec[0] = 1 ; int max = 1;

        for(int i=1;i< n ;i++){
            inc[i] = 1;
            dec[1] = 1;

            if(arr[i] < arr[i-1]){
                dec[i] = inc[i-1] + 1;
            }else if(arr[i] > arr[i-1]){
                inc[i] = dec[i-1] + 1;
            }

            max = Math.max(max,Math.max(inc[i],dec[i]));
        }

        return max;

    }
}
