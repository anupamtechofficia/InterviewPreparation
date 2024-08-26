import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class ThreadPractice {


    static class MyThread extends Thread {
        int threadNumber;

        MyThread(int threadNumber){
            this.threadNumber = threadNumber;
        }

        public void run()  {
            try {
                sleep(1000);

            } catch (Exception e){
                System.out.println(e);
            }
            System.out.println(String.format("Thread %d running", threadNumber));
        }

    }

    static class MyThread1 implements Callable<Integer> {
        int threadNumber;

        MyThread1(int threadNumber){
            this.threadNumber = threadNumber;
        }

        public Integer call()  {
            try {
                sleep(1000);

            } catch (Exception e){
                System.out.println(e);
            }
            return threadNumber;
        }

    }




    public static void main(String[] args)
    {
      /*  ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i = 0 ;i< 10 ;i ++){
            es.execute(new MyThread(i));
        }
        es.shutdown();*/

        ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i = 0 ;i< 10 ;i ++){
            Future<Integer> future = es.submit(new MyThread1(i));
        }
        es.shutdown();

        System.out.println("done");
    }


}
