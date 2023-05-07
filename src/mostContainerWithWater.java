public class mostContainerWithWater {
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        long startTime = System.nanoTime();

        int ans = maxArea(height);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;


        System.out.println("Ans--> " + ans + " Time---> " + totalTime/1000);
    }

    public static int maxArea(int[] height){
        int start  = 0 ;
        int end = height.length -1 ;
        int maxArea = 0 , currentArea = 0;

        while (start < end) {
            currentArea = Math.min(height[start],height[end]) * (end - start);
            if(currentArea > maxArea) maxArea = currentArea;
            if(height[start] < height[end]) start++;
            else if(height[start] > height[end]) end--;
            else{
                start++;
                end--;
            }

        }
        return maxArea;
    }
}
