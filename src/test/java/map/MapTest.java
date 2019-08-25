package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @项目名称:
 * @Description:
 * @Author luchuanyou
 * @创建日期: 2018年10月22日
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", "value4");

        //遍历
        iteratorMap1(map);
        System.out.println("==============");
        iteratorMap2(map);
        System.out.println("==============");
        iteratorMap3(map);
    }

    /**
     * 遍历map
     * 第一种：普通使用，二次取值
     * @param map
     */
    public static void iteratorMap1(Map<String,String> map){
        for (String key : map.keySet()) {
            System.out.println("key:"+key+",value:"+map.get(key));
        }
    }
    /**
     * 遍历map
     * 第二种：推荐，尤其是容量大时
     * @param map
     */
    public static void iteratorMap2(Map<String,String> map){
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }
    }
    /**
     * 遍历map
     * 第三种：不能遍历key
     * @param map
     */
    public static void iteratorMap3(Map<String,String> map){
        for (String value : map.values()) {
            System.out.println("value:"+value);
        }
    }
}
