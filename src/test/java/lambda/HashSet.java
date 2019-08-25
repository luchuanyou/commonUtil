package lambda;


import java.util.Set;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/22
 */
public class HashSet {
    public static void main(String[] args) {
        Set<String> set = new java.util.HashSet<>();
        set.add("tom");

        set.forEach(s -> System.out.println(s));
    }
}
