package string;

import enums.ResultEnum;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/05/05
 */
public class String02Test {
    public static void main(String[] args) {
        String logContent = String.format("springAirlinesFilter收到请求:account:%s,msg:%s,phone:%s,extno:%s,monthseq:%s,needstatus:%s,startSendTime:%s,delay:%s,timestamp:%s,IP:%s",
                "account", 1, 1, 1, 1, 1,
                1, 1, 1, 1);
        System.out.println(logContent);

        logContent = String.format("通道提交响应,remoteMsgId:%s, clientMsgId:%s, 网关:%s, 未回resp个数:%s，返回结果:%s", "remoteMessageId", "messageId", "this.realSpNumber", "sbmCount", "result");
        System.out.println(logContent);
        logContent = String.format("deppon pull report account:%s,llen:%s","account",null);
        System.out.println(logContent);

        String key = "key:0.5";
        int type = Integer.parseInt(key.substring(key.length() - 1));
        System.out.println("type:"+type);

        int num = 4;
        if(1==getNum01(num)){

        }else if (1==getNum02(num)){

        }else {
            getNum03(num);
        }
    }

    private static int getNum01(int num) {
        System.out.println("1-"+num);
        return num;
    }
    private static int getNum02(int num) {
        System.out.println("2-"+num);
        return num;
    }
    private static int getNum03(int num) {
        System.out.println("3-"+num);
        return num;
    }
}
