package thread;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/15
 */
public class Thread02Test {
    public static void main(String[] args) {
        synClazz clazz = new synClazz();
        synClazz clazz2 = new synClazz();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//                sync("1","11");
//                sync2("1","11");
                clazz.sync("1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                sync2("2","22");
//                sync2("2","22");
                clazz2.sync("1");
            }
        });

        t.start();
        t2.start();
        while (true){

        }
    }

    /**
     * 用户锁
     * @param id
     * @param name
     */
    public static void sync(String id, String name){
        synchronized (id){
            try {
                System.out.println(id);
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 全局锁
     * @param id
     * @param name
     */
    public synchronized static void sync2(String id, String name){
        try {
            System.out.println(id);
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class synClazz{
    public synchronized void sync(String id){
        try {
            System.out.println(id);
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}