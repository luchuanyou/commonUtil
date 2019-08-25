package clone;

import java.util.Arrays;

/**
 * @项目名称: commonUtil
 * @文件名称: clone 版本号：1.0
 * @Description: 复制的类必须实现Cloenable接口
 * 复制分为浅复制和深复制
 * @Author lucy
 * @创建日期: 2019年01月18日
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            SubCloen obj = new SubCloen("tom");

            SubCloen obj2 = (SubCloen) obj.clone();
            obj2.setName("jack");

            System.out.println("obj:"+obj);
            System.out.println("obj2:"+obj2);
            System.out.println(obj.equals(obj2));

            System.out.println(Arrays.toString(args));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class SubCloen implements Cloneable{
    private String name;

    public SubCloen(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubCloen{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}