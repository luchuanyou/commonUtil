package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/05/08
 */
public class SqlList {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 10000; i++) {
            list.add("id_" + i);
        }
        String result = getSqlStrByList(list, 1000, "id");
        System.out.println(result);
    }

    /**
     * columnName IN (sqhList)
     * IN函数最大支持1000条，超过需要进行拆分处理，例如：id in(...) or id in(...)
     * @param sqhList
     * @param splitNum
     * @param columnName
     * @return
     */
    private static String getSqlStrByList(List sqhList, int splitNum, String columnName) {
        if (splitNum > 1000) // 因为数据库的列表sql限制，不能超过1000.
            return null;
        StringBuffer sql = new StringBuffer("");
        if (sqhList != null) {
            sql.append(" ").append(columnName).append(" IN ( ");
            for (int i = 0; i < sqhList.size(); i++) {
                sql.append("").append(sqhList.get(i) + ",");
                if ((i + 1) % splitNum == 0 && (i + 1) < sqhList.size()) {
                    sql.deleteCharAt(sql.length() - 1);
                    sql.append(" ) OR ").append(columnName).append(" IN (");
                }
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" )");
        }
        return sql.toString();
    }
}
