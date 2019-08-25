package list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/04/08
 */
public class ListTest {
    public static void main(String[] args) {
//        stringToList();
//        fixedList();
//        print();
        listToJson();
    }

    private static void listToJson() {
        JSONObject json = new JSONObject();
        json.put("name", "tom");
        json.put("age", 12);
        List list = new ArrayList();
        list.add(json);
        System.out.println(JSON.toJSONString(list));

    }

    private static void print() {
        List list = new ArrayList();
        list.add("aaa");

        list.add(Pattern.compile("test"));
        list.add(Pattern.compile("test"));

        System.out.println(list);
        list.remove(Pattern.compile("test"));
        System.out.println(list);
    }

    private static void fixedList() {
        List list = new ArrayList(3);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }

    private static void stringToList() {
        String str = "[{'account':'jack','srcCode':'123'},{'account':'tom','srcCode':'122'}]";
        List list = Arrays.asList(str);
        List<Map> jsons = JSON.parseArray(str, Map.class);
        System.out.println(jsons);
        System.out.println(jsons.get(1).get("name"));
    }
}
