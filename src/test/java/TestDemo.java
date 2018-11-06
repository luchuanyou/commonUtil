import java.math.BigDecimal;

/**
 * @项目名称: img
 * @文件名称: PACKAGE_NAME 版本号：1.0
 * @Description:
 * @Author luchuanyou
 * @创建日期: 2018年10月10日
 * <p/>
 * Copyrights © 2018 上海淘略数据处理有限公司 All rights reserved.
 * <p/>
 * 注意：本内容仅限于上海淘略数据处理有限公司信息技术部内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class TestDemo {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("-1");
        int num = b.compareTo(BigDecimal.ZERO);
        System.out.println("num:"+num);
    }
}
