package random;

import java.util.Random;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/04/19
 */
public class RandomTest {
    public static void main(String[] args) {
//        defaultValue();
        limitValue();
    }

    private static void limitValue() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(1);//范围[0,n-1]
            System.out.println();
        }
    }

    private static void defaultValue() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextLong());
        }
    }
}
