package enums;

/**
 * @项目名称: commonUtil
 * @文件名称: enums 版本号：1.0
 * @Description:
 * @Author lucy
 * @创建日期: 2019年01月18日
 */
public class EnumMain {
    public static void main(String[] args) {
        //获取字段名
        System.out.println(EnumTest.ACCOUNT_WHITE_TEMPLATE.name());
        //获取字段值
        System.out.println(EnumTest.ACCOUNT_WHITE_TEMPLATE.getIndex());

        System.out.println(ResultEnum.PARAM_IS_NULL.getMessage("hello"));
        //获取字段名称
        System.out.println(ResultEnum.SUCCESS.name());
    }
}
