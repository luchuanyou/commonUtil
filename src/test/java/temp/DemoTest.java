package temp;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/16
 */
public class DemoTest {
    public static void main(String[] args) {
        Map<String,String> accountInfo = new HashMap();
        accountInfo.put("name3","cNdfs");
        boolean nAccount = StringUtils.startsWithIgnoreCase(accountInfo.get("name"), "N") || StringUtils.startsWithIgnoreCase(accountInfo.get("name"), "CN");
        System.out.println("nAccount:"+nAccount);
    }



}
