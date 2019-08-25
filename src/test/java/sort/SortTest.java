package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User(i);
            list.add(u);
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
