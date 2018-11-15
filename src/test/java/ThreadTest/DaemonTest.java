package ThreadTest;

/**
 * 守护线程、非守护线程（用户线程）
 * 默认创建的线程是用户线程，用户线程之间都是独立的，彼此互不影响，不会因为父线程结束而子线程中断的情况。
 * 守护线程会依赖父线程，如果父线程结束后，子线程立刻结束，守护线程里面创建的线程都是守护线程。
 */
public class DaemonTest {
    public static void main(String[] args) {
        System.out.println("main thread begin ");

        ChildThread t1 = new ChildThread();
        ChildThread t2 = new ChildThread();

        //设置守护线程
        /*t1.setDaemon(true);
        t2.setDaemon(true);*/

        t1.start();
        t2.start();

        System.out.println("main thread over ");
    }
}

class ChildThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--child thead begin");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(Thread.currentThread().getName() + "--child thead over");
    }
}