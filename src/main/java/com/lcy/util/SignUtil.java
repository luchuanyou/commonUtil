package com.lcy.util;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/23
 */
public class SignUtil {
    public static void main(String[] args) {
        RequestParams dto = new RequestParams();
        dto.setName("jack");
        dto.setAge(23);
        dto.setPassword("123456");
        dto.setMobile("1234567");

        String result = getSortString(dto);
        System.out.println(result);
    }

    private static String getSortString(RequestParams dto) {
        if(dto == null){
            return null;
        }
        TreeMap<String, Object> treeMap = new TreeMap<>();

        if(StringUtils.isNotBlank(dto.getName())){
            treeMap.put("name", dto.getName());
        }
        if(StringUtils.isNotBlank(dto.getPassword())){
            treeMap.put("password", dto.getPassword());
        }
        if(dto.getAge() != null){
            treeMap.put("age", dto.getAge());
        }
        if(StringUtils.isNotBlank(dto.getMobile())){
            treeMap.put("mobile", dto.getMobile());
        }

        StringBuffer sb = new StringBuffer();
//        for (Map.Entry entry : treeMap.entrySet()){
//            sb.append(entry.getKey());
//            sb.append(entry.getValue());
//        }

        treeMap.entrySet().forEach(entry -> {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        });
        return sb.toString();
    }

    static class RequestParams{
        private String name;
        private Integer age;
        private String password;
        private String mobile;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
