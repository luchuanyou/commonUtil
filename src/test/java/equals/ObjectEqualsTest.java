package equals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectEqualsTest {
    public static void main(String[] args) {
//        removeObj();
        defaultIntValue();
    }

    private static void defaultIntValue() {
        User user = new User();
        System.out.println(user.getAge() == 0);//true
    }

    private static void removeObj() {
        List<User> list = new ArrayList<>();
        List<User> list2 = new ArrayList<>();
        Map map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("tom"+i);
            list.add(user);
            map.put(user,user);
            if(i==2){
                list2.add(user);
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i).equals(list2.get(0)));
            System.out.println(map.get(list.get(i)));
            if(i==2){
                map.remove(list.get(i));
            }
        }
        System.out.println(map);
    }
}


class User{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}