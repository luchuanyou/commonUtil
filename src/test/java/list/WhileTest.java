package list;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/25
 */
public class WhileTest {
    public static void main(String[] args) {
        int num = 1;
        while (true){
            if(num < 5){
                System.out.println("num:"+num);
                ++num;
                continue;
            }
            System.out.println("结束");
            break;
        }
    }
}
