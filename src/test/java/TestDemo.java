import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String str = "";
        if(!str.equals("")){
            System.out.println("else1");
        }else if(str.equals("")){
            System.out.println("else2");
        }else {
            System.out.println("else");
        }

        List list= new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        Iterator it = list.iterator();
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        System.out.println("========list:"+list);

        Pattern nonRegPattern = Pattern.compile("[\\pP\\p{Punct}\\￥\\s*|\t|\r|\n]+");
        Matcher sdf = nonRegPattern.matcher("fdsad fdsa");
        System.out.println("===========sdf:========="+sdf.toString());
        System.out.println(sdf.replaceAll(""));
    }
}
