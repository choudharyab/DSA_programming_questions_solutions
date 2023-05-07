public class lcsPallindromeSubString {

    static String intermediatePalindrome(String s , int left ,int right){
        if(left > right) return null;
        while(left >=0 && right < s.length() && s.charAt(left)== s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);

    }
    static  String longestPalindrome(String s) {
        int n = s.length();
        String longest = s.substring(0,1);
        for(int i =0 ;i<n-1;i++){

            String palindrome = intermediatePalindrome(s,i,i);
            if(palindrome.length() >= longest.length()){
                longest = palindrome;
            }
            palindrome = intermediatePalindrome(s,i,i+1);
            if(palindrome.length() >= longest.length()){
                longest = palindrome;
            }
        }
        return longest;

    }


    public static void main(String[] args) {

        String s1 = "babad";
        longestPalindrome(s1);
        System.out.println("Ans "+longestPalindrome(s1));

    }
}
