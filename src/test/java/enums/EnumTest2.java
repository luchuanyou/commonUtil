package enums;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/14
 */
public enum  EnumTest2 {
    HUAI_YANG_COUNTRY("HN","ZK","HY"),
    TAI_KANG_COUNTRY("HN","ZK","TK");

    private String[] keys;
    EnumTest2(String... keys) {
        this.keys = keys;
    }

    public String value(String... keys){
        System.out.println(Arrays.toString(keys));
        System.out.println(Arrays.toString(this.keys));
        return Arrays.toString(keys);
    }

    public static void main(String[] args) {
        String result = EnumTest2.TAI_KANG_COUNTRY.value();
        System.out.println("result:"+result);
    }
}
