package com.lcy.util;

/**
 * 身份证工具类
 */
public class IdCardUtil {
    /**
     * 根据身份编号获取生日
     *
     * @param idCard 身份编号
     * @return 生日(yyyyMMdd)
     */
    public static String getBirthFromIdCard(String idCard) {
        if (idCard.length() == 18) {
            return idCard.substring(6, 14);
        } else {
            return "19" + idCard.substring(6, 12);
        }
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard
     * @return
     */
    public static String getSexFromIdCard(String idCard) {
        //性别
        int idxSexStart = idCard.length() - 2;
        String idxSexStr = idCard.substring(idxSexStart, idxSexStart + 1);
        System.out.println("===============idxSexStr" + idxSexStr);
        int idxSex = Integer.parseInt(idxSexStr) % 2;
//        String sex = (idxSex == 1) ? "M" : "F";
        String sex = (idxSex == 1) ? "男" : "女";
        return sex;
    }

    public static void main(String[] args) {
        System.out.println("=====================" + getBirthFromIdCard("130430199205110570"));
        System.out.println("=====================" + getBirthFromIdCard("310112621126214"));

        System.out.println("==================getSexFromIdCard===" + getSexFromIdCard("130430199205110570"));
        System.out.println("==================getSexFromIdCard===" + getSexFromIdCard("310112621126214"));
    }
}
