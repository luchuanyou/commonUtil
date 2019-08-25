package local;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @项目名称: commonUtil
 * @文件名称: local 版本号：1.0
 * @Description:
 * @Author lucy
 * @创建日期: 2019年01月22日
 */
public class LocalTest {
    public static void main(String[] args) {
        try {
            System.out.println(System.getenv("COMPUTERNAME"));
//            getLocalHostName();
            getSystemParams();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getLocalHostName() throws UnknownHostException {
        for (int i = 0; i < 10; i++) {

            long startTime = System.currentTimeMillis();
            InetAddress addr = InetAddress.getLocalHost();
            String ip=addr.getHostAddress().toString(); //获取本机ip
            String hostName=addr.getHostName().toString(); //获取本机计算机名称
            System.out.println(ip);
            System.out.println(hostName);

            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }
    }

    public static void getSystemParams() {
        String name = System.getProperty("java.version", "SH");
        System.out.println(name);

        long time = System.currentTimeMillis();
    }
}
