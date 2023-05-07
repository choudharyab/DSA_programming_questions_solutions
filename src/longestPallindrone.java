public class longestPallindrone {
    public static void main(String[] args) {
        String s = "(";
        int count = longestValidParentheses(s);
        System.out.println(count);

    }

    public static  int longestValidParentheses(String s) {
        int maxLen = 0 ;
        int start = 0 ;
        int diff = 0 ;
        //scanning from left to right
        for(int i = 0 ; i< s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                diff++;
            }else {
                diff--;
            }

            if(diff < 0) {
                diff = 0;
                start = i +1;
            }

            if(diff == 0){
                maxLen = Math.max(maxLen ,i-start+1);
            }
        }


        int end = s.length() -1 ;
        diff = 0 ;
        //scanning from left to right
        for(int i = s.length() -1 ; i >= 0;i--){
            char ch = s.charAt(i);
            if(ch == ')'){
                diff++;
            }else {
                diff--;
            }

            if(diff < 0) {
                diff = 0;
                end = i - 1;
            }

            if(diff == 0){
                maxLen = Math.max(maxLen , end -i+1);
            }
        }

        return maxLen;

    }
}
