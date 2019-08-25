package thread.subThread;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/28
 */
public class ParentThread extends Thread {
    @Override
    public void run() {
        System.out.println("ParentThread run");
    }
}
