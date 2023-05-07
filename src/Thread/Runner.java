package Thread;

public class Runner {

    public static void main(String[] args) {
        //System.out.println("Hello world "+ Thread.currentThread().getName());
        //step 3
        for(int i=1 ;i<=100;i++) {


            Thread thread = new Thread(new NumberPrinter(i));
            //step 4
            thread.start();
        }
    }
}
