package com.lcy.util.image;

import java.util.*;

/**
 * 排序
 */
public class SortUtil {
    public static void main(String[] args) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("ff","ff");
        params.put("dd","dd");
        params.put("ddf","ddf");
        params.put("ee","ee");
        params.put("bb","bb");
        System.out.println(dictionarySort(params));
    }
    public static String dictionarySort(Map<String,Object> map){
        Collection<String> keyset= map.keySet();
        List<String> list = new ArrayList<String>(keyset);

        //对key键值按字典升序排序
        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if(i != 0){
                sb.append("&");
            }
            sb.append(list.get(i));
            sb.append("=");
            sb.append(map.get(list.get(i)));
        }
        return sb.toString();
    }
}
