package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/03
 */
public class Map02Test {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","tom");
        System.out.println("main map:"+map);

        resetMap(map);

        System.out.println("end map:" + map);


        Map<MapKey,MapKey> objMap = new HashMap<>();
        MapKey obj = new MapKey("tom");
        System.out.println("objMap:"+objMap);

        MapKey obj2 = new MapKey("tom");
        objMap.put(obj2, obj2);

        MapKey obj3 = new MapKey("jack");
        objMap.put(obj3, obj3);

        System.out.println("objMap:"+objMap);

        System.out.println(obj == obj2);
        System.out.println(obj.equals(obj2));
    }

    private static void resetMap(Map<String, Object> map) {
        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","jack");

        map = map2;
        System.out.println("resetMap map:"+map);
    }
}

class MapKey{
    private String name;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        MapKey key = (MapKey) obj;
        if(!this.getName().equals(key.getName()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    public MapKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MapKey{" +
                "name='" + name + '\'' +
                '}';
    }
}
