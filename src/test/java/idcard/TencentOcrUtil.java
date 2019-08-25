package idcard;

import com.alibaba.fastjson.JSONObject;
import com.lcy.util.http.HttpClientUtil;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesResponse;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRResponse;

import java.util.HashMap;

public class TencentOcrUtil {
    public static void main(String[] args) {
        try {
            /*String url = "https://ocr.tencentcloudapi.com/";

            String action = "IDCardOCR";
            String imageUrl = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&hs=0&pn=1&spn=0&di=212850&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=3987907653%2C720009510&os=3586525006%2C165335113&simid=4093363352%2C542483519&adpicid=0&lpn=0&ln=793&fr=&fmq=1566705823248_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fc%2F53cdd1f7c1f21.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fks52_z%26e3Bftgw_z%26e3Bv54_z%26e3BvgAzdH3FfAzdH3Fks52_wjmvadl0a8adoig2_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0&islist=&querylist=&force=undefined";
            String version = "2018-11-19";
            String region = "ap-beijing";
            url = url + "?Action=" + action + "&ImageUrl=" + imageUrl + "&Version=" + version + "&Region=" + region;

            System.out.println(url);
            String result = HttpClientUtil.doPost(url, new HashMap<>(), "UTF-8");
            System.out.println("result++++++++++++" + result);*/

            Credential cred = new Credential("AKIDTyIXXMgZrui7Rlooa6XlkY8XkljZnk28", "zlHWWHoxqTry60d3FC3DWov8E6k7EMTM");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

//            String region = "ap-guangzhou";
//            String region = "ap-hongkong";
            String region = "ap-shanghai";
            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);

            JSONObject json = new JSONObject();
            json.put("CardSide", "FRONT");
            json.put("ImageUrl", "https://up.enterdesk.com/edpic/28/bc/80/28bc80d62c84ea7797197a6d7cb03394.jpg");
//            json.put("ImageUrl", "https://up.enterdesk.com/edpic/3a/d1/66/3ad1668da63c67a9dc421238938dfb8c.jpg");

//            String params = "{\"ImageUrl\":\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566750288590&di=03b776310ee386c277c3740019c1546a&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fc%2F53cdd1f7c1f21.jpg\",\"CardSide\":\"FRONT\"}";
            String params = json.toJSONString();
            IDCardOCRRequest req = IDCardOCRRequest.fromJsonString(params, IDCardOCRRequest.class);

            IDCardOCRResponse resp = client.IDCardOCR(req);

            System.out.println(IDCardOCRRequest.toJsonString(resp));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败了");
        }
    }
}
