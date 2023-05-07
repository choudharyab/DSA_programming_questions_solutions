package Thread;

//step 1  extends  Thread or implement Runnable
public class HelloWorldPrinter implements   Runnable {

    //step 2
    @Override
    public void run(){
        System.out.println("Hello World Thread " + Thread.currentThread().getName());
    }


}
