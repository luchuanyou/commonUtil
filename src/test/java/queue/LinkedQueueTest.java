package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        try {
            queue.put("hello");

            System.out.println("===start===");
            System.out.println(queue.take());
            System.out.println("===over===");

            System.out.println("result:"+queue.take());
            System.out.println("========");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
