package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class ListTest {
    //lambda表达式语法：[参数] -> [函数主体]
    //Stream的是通过函数式编程方式实现的在集合类上进行复杂操作的工具。
    //collect是一个收集器，将流中的元素累积成一个汇总结果收集到不同的对象中。如：toList【List<T>】，toSet【Set<T>】
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");
        list.add("c");

        foreachTest(list);

//        filterTest(list);
        
//        sortedTest(list);

//        mapTest(list);

        String[] strs = new String[]{"b","a"};
//        filter(strs);
    }

    private static void filter(String[] strs) {
        System.out.println(strs.length);
        String a = "";
        Arrays.asList(strs).stream().filter((str) -> ("a".equals(str))).forEach((str) -> System.out.println(str));

    }

    private static void mapTest(List<String> list) {
        //map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素。还有一些场景，是一对多映射关系的，这时需要 flatMap。

        List<String> newList = list.stream().map(n -> n + ".bat").collect(Collectors.toList());
        System.out.println(list);//[a, d, c]
        System.out.println(newList);//[a.bat, d.bat, c.bat]

        newList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(newList);//[A, D, C]

        Map<String, String> map = list.stream().collect(Collectors.toMap(String::toUpperCase, str -> str + "-value"));
        System.out.println("map:"+map);
}

    private static void sortedTest(List<String> list) {

        List<String> newList = list.stream().sorted((str1, str2) -> (str1.compareTo(str2))).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(newList);
    }



    private static void filterTest(List<String> list) {
        list.stream().filter((str) -> ("a".equals(str))).forEach((str) -> System.out.println(str));

        Predicate<? super String> equalsFilter = (str) -> ("b".equals(str));
        list.stream().filter(equalsFilter).forEach((str) -> System.out.println(str));
    }

    private static void foreachTest(List<String> list) {
        list.forEach((str) -> System.out.println(str));
        System.out.println("========");
        list.forEach(System.out::println);
    }
}
