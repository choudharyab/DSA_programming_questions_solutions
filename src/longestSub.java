import java.util.HashMap;

public class longestSub {


    static int longestSub(String str ,int n){
        if(n ==0 ) return  0;
        HashMap<Character,Integer> seen  = new HashMap<Character,Integer>();
        int maxLength = 0 ;
        int start = 0 ;
        for(int end =0 ;end< n ;end++){
            if(seen.containsKey(str.charAt(end))){

                start = Math.max(start ,seen.get(str.charAt(end))+1);
            }

            seen.put(str.charAt(end),end);
            maxLength = Math.max(maxLength,end-start+1);

        }

        return maxLength;

    }



    public static void main(String[] args) {
        String s ="abcabcbb";
        int n = s.length();
        int ans = longestSub(s,n);
        System.out.println("Printing "+ans);
    }
}
