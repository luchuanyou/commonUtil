package thread.subThread;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/28
 */
public class Test02 {
    public static void main(String[] args) {
        ParentThread t = new SubThread();
        t.start();
    }
}
