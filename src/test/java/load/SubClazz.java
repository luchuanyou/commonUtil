package load;

/**
 * @Description: 加载顺序，静态代码块先加载，父类的优先于子类加载
 * @Author: lucy
 * @date: 2019/06/27
 */
public class SubClazz extends ParentClazz{
    private String name = "tom";
    {
        System.out.println("SubClazz {}");
    }
    static {
        System.out.println("SubClazz static{}");
    }

    public SubClazz() {
        super();
        System.out.println("SubClazz SubClazz()");
    }
}
