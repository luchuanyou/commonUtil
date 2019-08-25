package synch;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/26
 */
public class Test01 {
    static Map<String,Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int num = 0;
        while (true){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    add("1");
                }
            });
            t.start();
            num ++;
            if(num > 1000){
                break;
            }
        }


        int num2 = 0;
        while (true){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    add("2");
                }
            });
            t.start();
            num2 ++;
            if(num2 > 1000){
                break;
            }
        }
    }

    public synchronized static void add (String id){
        map.put(id, map.get(id) == null ? 0 : map.get(id) +1);
        System.out.println(map);
    }
}
