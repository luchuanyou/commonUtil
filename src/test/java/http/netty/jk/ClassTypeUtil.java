package http.netty.jk;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/08/15
 */
public class ClassTypeUtil {
    public static final String STRING = "java.lang.String";
    public static final String INTEGER = "java.lang.Integer";
    public static final String INT = "int";
    public static final String LONG_OBJECT = "java.lang.Long";
    public static final String LONG = "long";
    public static final String DOUBLE_OBJECT = "java.lang.Double";
    public static final String DOUBLE = "double";
    public static final String FLOAT_OBJECT = "java.lang.Float";
    public static final String FLOAT = "float";
    public static final String SHORT_OBJECT = "java.lang.Short";
    public static final String SHORT = "short";
    public static final String BOOLEAN_OBJECT = "java.lang.Boolean";
    public static final String BOOLEAN = "boolean";
    public static final String DATE = "java.util.Date";
    public static final String SQL_TIMESTAMP = "java.sql.Timestamp";

    public static boolean isSimpleObject(Object object) {
        String paramType = object.getClass().getName();
        if (STRING.equals(paramType)) {
            return true;
        } else if (BOOLEAN_OBJECT.equals(paramType)) {
            return true;
        } else if (BOOLEAN.equals(paramType)) {
            return true;
        } else if (INTEGER.equals(paramType)) {
            return true;
        } else if (INT.equals(paramType)) {
            return true;
        } else if (LONG_OBJECT.equals(paramType)) {
            return true;
        } else if (LONG.equals(paramType)) {
            return true;
        } else if (FLOAT_OBJECT.equals(paramType)) {
            return true;
        } else if (FLOAT.equals(paramType)) {
            return true;
        } else if (SHORT_OBJECT.equals(paramType)) {
            return true;
        } else if (SHORT.equals(paramType)) {
            return true;
        } else if (DOUBLE_OBJECT.equals(paramType)) {
            return true;
        } else {
            return DOUBLE.equals(paramType);
        }
    }
}
