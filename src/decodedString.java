import java.util.Stack;

public class decodedString {

    static String decodedStringInString(String s1){
        Stack<Integer> counts  = new Stack<>();
        Stack<String>  str   = new Stack<>();
        int index = 0;
        String res = "";

        while(index < s1.length()){
            char current = s1.charAt(index);
            if(Character.isDigit(current)){
                int count = 0 ;
                while(Character.isDigit(s1.charAt(index))){
                    count = 10 * count  + s1.charAt(index) - '0';
                    index++;
                }
                counts.push(count);

            }else if (current == '['){
                   str.push(res);
                   res = "";
                   index++;

            }else if(current == ']'){
                StringBuilder sb = new StringBuilder(str.pop());
                int resultCount = counts.pop();
                for(int j=1;j<=resultCount;j++) sb.append(res);
                res = sb.toString();
                index++;

            }else {
                res += current;
                index++;

            }
        }

        return res;

    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String ans = decodedStringInString(s1);
        System.out.println("string "+ans);
    }
}
