package ThreadTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        ThreadTask task = new ThreadTask();

//        service.schedule(task,5, TimeUnit.SECONDS);//延迟delay后执行

        service.scheduleAtFixedRate(task,1,5,TimeUnit.SECONDS);
        System.out.println("===over===");
    }
}

class ThreadTask extends Thread{

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}