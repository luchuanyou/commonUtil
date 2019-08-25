package concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @项目名称: commonUtil
 * @文件名称: concurrent 版本号：1.0
 * @Description:
 * @Author lucy
 * @创建日期: 2019年01月12日
 */
public class CurrentHashMapTest {
    public static void main(String[] args) {
        putIfAbsent();
    }

    private static void putIfAbsent() {
        ConcurrentHashMap<String, AtomicInteger> countMap = new ConcurrentHashMap<>();
        int count = 2;
        AtomicInteger countVal = countMap.putIfAbsent("testKey", new AtomicInteger(count));
        if (countVal != null) {
            countVal.addAndGet(count);
        }
        System.out.println(countVal);
        System.out.println(countMap);

        countVal = countMap.putIfAbsent("testKey", new AtomicInteger(-1));
        countVal.decrementAndGet();
        System.out.println(countVal);
        System.out.println(countMap);
    }
}
