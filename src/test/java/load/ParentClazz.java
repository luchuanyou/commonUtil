package load;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/27
 */
public class ParentClazz {
    {
        System.out.println("ParentClazz {}");
    }
    static {
        System.out.println("ParentClazz static{}");
    }

    public ParentClazz() {
        super();
        System.out.println("ParentClazz ParentClazz()");
    }

    public void exec(){
        System.out.println("ParentClazz exec");
    }
}
