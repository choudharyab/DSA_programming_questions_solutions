package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorRunner {
    public static void main(String[] args) {
        Executor executor =  Executors.newFixedThreadPool(10);
        for(int i=0;i<=100;i++){
            executor.execute(new NumberPrinter(i));
        }

    }
}
