/**
 * @项目名称: img
 * @文件名称: PACKAGE_NAME 版本号：1.0
 * @Description:
 * @Author luchuanyou
 * @创建日期: 2018年10月22日
 * <p/>
 * Copyrights © 2018 上海淘略数据处理有限公司 All rights reserved.
 * <p/>
 * 注意：本内容仅限于上海淘略数据处理有限公司信息技术部内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class Euclid {
    // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
//        int p = Integer.parseInt(args[0]);
//        int q = Integer.parseInt(args[1]);
        int p = 9;
        int q = 100;
        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }
}
