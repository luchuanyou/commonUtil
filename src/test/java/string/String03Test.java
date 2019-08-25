package string;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/05/10
 */
public class String03Test {
    public static void main(String[] args) {
        Num num = new Num();
        System.out.println(num.getNum());
        if(num.getNum() == 0){
            System.out.println("默认值");
        }

        int[] arr = new int[10];
        System.out.println(arr[0]);

        String mobile = "13761014257";
        System.out.println(mobile.substring(1,7));


        Boolean bo = new Boolean(true);
        System.out.println(bo);
        bo = new Boolean(false);
        System.out.println(bo);
    }
}

class Num{
    private int num;

    public int getNum() {
        return num;
    }

    public Num() {
    }

    public void setNum(int num) {
        this.num = num;
    }
}
