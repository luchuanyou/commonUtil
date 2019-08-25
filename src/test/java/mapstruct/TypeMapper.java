package mapstruct;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/27
 */
public class TypeMapper {
    public int asInt(String num) {
        return Integer.parseInt(num);
    }

    public long asLong(String num) {
        return Long.parseLong(num);
    }
}
