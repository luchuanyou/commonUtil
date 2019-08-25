package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/14
 */
public class MapTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("c");
        list.add("b");
//        list.forEach((val) -> System.out.println(val));

        list.forEach((val) -> System.out.println(val));

    }
}
