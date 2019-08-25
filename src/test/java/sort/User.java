package sort;

public class User implements Comparable<User>{
    private String name;
    private int age;
    private Boolean isSuccess;

    public User() {
    }

    public User(int age) {
        this.age = age;
    }

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

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {
//        if(this.getAge() > o.getAge()){
        if(this.getAge() < o.getAge()){
            return 1;
        }
        return -1;
    }
}
