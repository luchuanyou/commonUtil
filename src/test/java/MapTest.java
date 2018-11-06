import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: img
 * @文件名称: PACKAGE_NAME 版本号：1.0
 * @Description:
 * @Author luchuanyou
 * @创建日期: 2018年10月22日
 * <p/>
 * Copyrights © 2018 上海淘略数据处理有限公司 All rights reserved.
 * <p/>
 * 注意：本内容仅限于上海淘略数据处理有限公司信息技术部内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","jack");

        list();

    }
    public static void list(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");
        System.out.println(list);
        /*for(String str:list){
            for(String str2:list2){
                if(str.equals(str2)){
                    list.remove(str);
                    break;
                }
            }
        }*/
        System.out.println("==="+list);


        for(int i=0;i<list.size();i++){
            for(String str2:list2){
                if(list.get(i).equals(str2)){
                    list.remove(list.get(i));
                    i--;
                    break;
                }
            }
        }
        System.out.println("====="+list);
    }
}
