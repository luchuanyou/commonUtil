package map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/16
 */
public class SetTest {
    public static void main(String[] args) {
        getValue();
    }

    public static void getValue() {
        Set set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");

        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
