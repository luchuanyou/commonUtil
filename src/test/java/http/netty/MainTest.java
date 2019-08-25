package http.netty;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/16
 */
public class MainTest {
    public static void main(String[] args) {
        String url = "http://172.16.4.159:9091/report/error.action?name=jack&age=11";
//        String url = "http://www.baidu.com?company=cl253";
        System.out.println(url);
        HttpAsyncClientUtil.sendGet(url,new ResponseHandler());
    }
}
