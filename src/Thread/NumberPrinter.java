package Thread;

//step 1 implement Runnable
public class NumberPrinter implements Runnable {

    //step 3
    private int number;

    public NumberPrinter(int number){
        this.number = number;
    }

    //step 2
    @Override
    public void run(){
        System.out.println(number + ": " +Thread.currentThread().getName());

    }
}
