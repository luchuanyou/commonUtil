package string;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/17
 */
public class BaseTest {
    public static void main(String[] args) {
        Long n = new Long(1);
        Long n2 = new Long(1);
        System.out.println(n == n2);
        System.out.println(n.equals(n2));

        UTest u = new UTest();
        u.setId(1L);

        UTest u2 = new UTest();
        u2.setId(1L);

        System.out.println(u.getId() == u2.getId());
        System.out.println(u.getId().equals(u2.getId()));
    }
}

class UTest{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}