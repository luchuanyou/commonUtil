/**
 * @项目名称: img
 * @文件名称: PACKAGE_NAME 版本号：1.0
 * @Description:
 * @Author luchuanyou
 * @创建日期: 2018年10月31日
 * <p/>
 * Copyrights © 2018 上海淘略数据处理有限公司 All rights reserved.
 * <p/>
 * 注意：本内容仅限于上海淘略数据处理有限公司信息技术部内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class ObjTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("jack");

        User user2 = new User();
        user2.setName("jack");

        User user3 = user;
        System.out.println(user == user2);
        System.out.println(user.equals(user2));
        System.out.println(user == user3);
    }
}

class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
