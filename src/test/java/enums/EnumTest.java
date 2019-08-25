package enums;

/**
 * @项目名称: commonUtil
 * @文件名称: enums 版本号：1.0
 * @Description:
 * @Author lucy
 * @创建日期: 2019年01月18日
 */
public enum  EnumTest {
    SYSTEM_WHITE_TEMPLATE(2),
    ACCOUNT_WHITE_TEMPLATE(1),
    ACCOUNT_AUDIT_PASS_TEMPLATE(0);



    private final int index;

    EnumTest(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
