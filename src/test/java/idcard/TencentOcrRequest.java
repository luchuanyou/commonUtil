package idcard;

import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesRequest;

public class TencentOcrRequest extends DescribeZonesRequest {
    private String Action;
    private String Version = "2018-11-19";
    private String Region = "ap-beijing";
    private String ImageBase64;
    private String ImageUrl;

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getImageBase64() {
        return ImageBase64;
    }

    public void setImageBase64(String imageBase64) {
        ImageBase64 = imageBase64;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
