package local;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/27
 */
public class NewInstanceTest {

    public static void main(String[] args) {
        try {
            Map accountInfo = new HashMap<>();
            String group = "C177";
            List reportPushList = new ArrayList<>();
            ScheduledExecutorService pool = Executors.newScheduledThreadPool(20);


            Class<?> clazz = Class.forName("local.ReportPushBatchZTOTask");
//            Constructor<?> constructor = clazz.getConstructor(Map.class, String.class, List.class, ScheduledExecutorService.class);
//            Runnable r = (Runnable) constructor.newInstance(accountInfo, group, reportPushList, pool);

            Constructor<?> constructor = clazz.getConstructor(String.class, String.class);
            Runnable r = (Runnable) constructor.newInstance(group, group);

            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
