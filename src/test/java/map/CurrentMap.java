package map;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/26
 */
public class CurrentMap {
    public static void main(String[] args) {
        ConcurrentMap map = new ConcurrentHashMap();
        map.putIfAbsent("name","tom");
        System.out.println(map);
        map.putIfAbsent("name","jack");
        System.out.println(map);
    }
}
