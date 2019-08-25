package enums;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/05/05
 */
public class SingleEnumTest {
    public static void main(String[] args) {
        SingleEnum en = null;
        switch (en){
            case ERROR:
                System.out.println("error");
            case RETRY:
                System.out.println("retry");
        }
    }
}
