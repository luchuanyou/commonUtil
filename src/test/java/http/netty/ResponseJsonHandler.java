package http.netty;


import com.alibaba.fastjson.JSONObject;

public class ResponseJsonHandler implements CallbackHandler<Object> {
    @Override
    public void failed(Exception e) {
        e.printStackTrace();
        System.out.println("faile...");
    }

    @Override
    public void completed(Object callback) {
        try {
            JSONObject response = (JSONObject) callback;
            System.out.println("返回结果:" + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelled() {
        System.out.println("cancel...");
    }
}
