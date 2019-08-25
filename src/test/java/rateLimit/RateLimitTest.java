package rateLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimitTest {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        ExecutorService service = Executors.newFixedThreadPool(10);

        RateLimiter rateLimiter = RateLimiter.create(2);//限速每秒2个

        while (true){
            System.out.println(ai.get());
            if(ai.incrementAndGet() == 200){
                break;
            }
            service.submit(new Runnable() {
                @Override
                public void run() {
//                    rateLimiter.acquire();
                    System.out.println("等待时间：" + rateLimiter.acquire());
                    System.out.println("======="+Thread.currentThread().getName());
                }
            });
        }
        System.out.println("结束了=========");
        while (true){

        }
    }
}
