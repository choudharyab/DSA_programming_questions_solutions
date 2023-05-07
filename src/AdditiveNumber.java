import java.math.BigInteger;

public class AdditiveNumber {
    public static void main(String[] args) {
        String s = "199100199";
        boolean ans = isAdditiveNumber(s);
        System.out.println(ans);
    }

    public static boolean isAdditiveNumber(String s){

        for(int i =1 ;i< s.length();i++){
            for(int j= i+1 ;j < s.length()-i+1;j++){
                String first = s.substring(0,i);
                String second = s.substring(i,j);
                if(isValid(j,first,second,s)){
                    return true;
                }
            }
        }


        return  false ;
    }

    public  static boolean isValid(int start , String  first , String second , String s){
        if(start == s.length()) return true;
        if(first.charAt(0) =='0' && first.length() > 1) return false;
        if(second.charAt(0) == '0' && second.length() > 1) return false;

        BigInteger f = new BigInteger(first);
        BigInteger se = new BigInteger(second);
        BigInteger sum = f.add(se);
        String strSum = sum.toString();
        if(start + strSum.length() > s.length()) return false;

        if(!s.substring(start ,start + strSum.length()).equals(strSum)) return false;

        return isValid(start + strSum.length(),second,strSum,s);


    }
}


/*
* s = 112358
* 1 1 2 3 5  8  n = 6
* i + i+1  => i + 2      when i =0 ;   1 + 1 => 2
*                        when i = 1 ;  1+ 2
*
* */