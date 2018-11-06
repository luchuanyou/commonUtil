package com.lcy.util;


import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class RegexUtil {
    /**
     * 手机号正则表达式
     */
    private static final String MOBILE_REGEX = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
    /**
     * 18位身份证正则表达式
     */
    private static final String ID_CARD_REGEX_18 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
    /**
     * 15位身份证正则表达式
     */
    private static final String ID_CARD_REGEX_15 = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$";


    /**
     * 校验手机号格式
     *
     * @param mobile
     * @return true：正确，false：错误
     */
    public static boolean checkIsMobile(String mobile) {
        Pattern pattern = Pattern.compile(MOBILE_REGEX);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    /**
     * 校验身份证格式
     *
     * @param idCard
     * @return true：正确，false：错误
     */
    public static boolean checkIsIdCard(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return false;
        }
        Pattern pattern = null;
        if (idCard.length() == 18) {
            pattern = Pattern.compile(ID_CARD_REGEX_18, Pattern.CASE_INSENSITIVE);
        } else if (idCard.length() == 15) {
            pattern = Pattern.compile(ID_CARD_REGEX_15, Pattern.CASE_INSENSITIVE);
        } else {
            return false;
        }
        Matcher matcher = pattern.matcher(idCard);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("=====================" + checkIsMobile("137610142570"));
        System.out.println("=====================" + checkIsIdCard("130430199205110570"));
    }
}
