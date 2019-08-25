package thread.subThread;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/28
 */
public class SubThread extends ParentThread {
    @Override
    public void run() {
        System.out.println("SubThread run");
    }
}
