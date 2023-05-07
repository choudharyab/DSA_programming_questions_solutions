public class powerThree {
    public static void main(String[] args) {
        int n = 16;
        boolean isPower = isPowerOfThree(n);
        System.out.println(isPower);
    }

    static boolean isPowerOfThree(int n){
        return (n != 0) && ((n & (n - 1)) == 0);
    }
}
