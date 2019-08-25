package exception;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/04/15
 */
public class ExceptionTest {
    public static void main(String[] args) {
        int num = 1;
        try {
            num = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            num = 2/0;
        } finally {
            System.out.println("=====over===");
        }
    }
}
