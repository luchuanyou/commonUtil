package mapstruct;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/21
 */
public class convertTest {
    public static void main(String[] args) {

        /*for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            SourceDto source = new SourceDto("tom"+i, 12, "上海");
            TargetDto target = Converter.INSTANCE.source2target(source);
            System.out.println(target);
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) / 1000);
        }*/


        SourceDto source = new SourceDto("tom", 12, "上海");
        source.setType("1");
        source.setId("999999999999999");
        TargetDto target = Converter2.INSTANCE.source2target(source);
        System.out.println(target);
    }
}
