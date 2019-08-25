package list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/08
 */
public class SetTest {
    public static void main(String[] args) {
        String[] adds = new String[]{"b","c"};
        Set set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        System.out.println(set.containsAll(Arrays.asList(adds)));
    }
}
