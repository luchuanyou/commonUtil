package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/16
 */
public class Map03Test {
    public static void main(String[] args) {
        initMap();
    }

    private static void initMap() {
        Map map = new HashMap<>(16);
        System.out.println("start");
        map.forEach((key, val) -> System.out.println(key+":"+val));
        System.out.println("end");
    }
}
