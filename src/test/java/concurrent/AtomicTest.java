package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
//        System.out.println(ai.incrementAndGet());//1
        System.out.println(ai.getAndIncrement());//0
        System.out.println(ai.get());
    }
}
