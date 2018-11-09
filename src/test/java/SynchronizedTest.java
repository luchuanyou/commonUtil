import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 同步锁
 */
public class SynchronizedTest {
    public static void main(String[] args) {

//        ExecutorService service = Executors.newFixedThreadPool(5);
        ExecutorService service = Executors.newCachedThreadPool();
        /*Suser user = new Suser();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    //同一个对象才会锁
                    user.lock();
                }
            });
        }*/

        /*for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    //不同的对象之间不会锁
                    Suser user2 = new Suser();
                    user2.lock();
                }
            });
        }*/

        /*for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    //静态方法锁定的是整个对象
                    Suser.staticLock();
                }
            });
        }*/

        List<Future<?>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<?> futre = service.submit(new Runnable() {
                @Override
                public void run() {
                    //静态方法锁定的是整个对象
                    System.out.println(Suser.staticLock());;
                }
            });
            list.add(futre);
        }
        service.shutdown();

        System.out.println("================1,"+list.size());
        for (Future<?> future : list) {
            System.out.println("================2");
            try {
                System.out.println("============="+future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
                service.shutdown();
                return;
            }
        }
        service.shutdown();
    }
}
class Suser{
    private String name;
    public synchronized void lock(){
        try {
//            Thread.sleep(1000L);
            System.out.println("====wait===");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static String staticLock(){
        try {
//            for (int i = 0; i < 2; i++) {
//                Thread.sleep(1000L);
//                System.out.println("====wait==="+i);
//            }
            if(new Random().nextBoolean()){
                int num = 1 / 0;
            }
            for (int i = 999999999; i > 0; i--)
                ;
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return Thread.currentThread().getName();
    }
}