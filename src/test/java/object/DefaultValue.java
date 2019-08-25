package object;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.beancontext.BeanContextChild;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class DefaultValue {
    public static void main(String[] args) {
        try {
            Obj obj = new Obj();
            obj.setDate(new Date());
            System.out.println(obj);

            Obj newObj = new Obj();
            BeanUtils.copyProperties(newObj,obj);
            System.out.println(newObj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Obj{
    private Integer age1;
    private int age2;
    private Date date;

    public Integer getAge1() {
        return age1;
    }

    public void setAge1(Integer age1) {
        this.age1 = age1;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "age1=" + age1 +
                ", age2=" + age2 +
                ", date=" + date +
                '}';
    }
}
