package http.netty.jk;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: 平安好医生sha1工具类
 * @Author: lucy
 * @date: 2019/08/15
 */
public class PAJKSHAUtil {
    /**
     * sha1加密
     * @param data 加密数据
     * @param key 密钥
     * @param salt 随机值
     * @return
     * @throws Exception
     */
    public static String sha1HString(String data, String key, String salt) throws Exception {
        if (data != null) {
            data = data.trim();
        }

        if (key != null) {
            key = key.trim();
        }

        if (salt != null) {
            salt = salt.trim();
        }

        if (data != null && data.length() != 0) {
            if (key != null && key.length() != 0) {
                byte[] byteData = data.getBytes("utf-8");
                byte[] byteKey = key.getBytes("utf-8");
                byte[] byteSalt = salt != null && salt.length() > 0 ? salt.getBytes("utf-8") : null;
                return sha1HString(byteData, byteKey, byteSalt);
            } else {
                throw new NullPointerException("sha1HString: key is NULL or EMPTY");
            }
        } else {
            throw new NullPointerException("sha1HString: data is NULL or EMPTY");
        }
    }

    public static String sha1HString(byte[] data, byte[] key, byte[] salt) throws Exception {
        if (data != null && data.length != 0) {
            if (key != null && key.length != 0) {
                byte[] bytes = digest(data, key, salt, "HmacSHA1");
                return PAJKDESUtil.toString(bytes);
            } else {
                throw new NullPointerException("sha1HString: key is NULL or EMPTY");
            }
        } else {
            throw new NullPointerException("sha1HString: data is NULL or EMPTY");
        }
    }

    private static byte[] digest(byte[] data, byte[] key, byte[] salt, String algo) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key, algo);

        try {
            Mac mac = Mac.getInstance(algo);
            mac.init(keySpec);
            if (salt != null && salt.length != 0) {
                mac.update(data);
                return mac.doFinal(salt);
            } else {
                return mac.doFinal(data);
            }
        } catch (InvalidKeyException e) {
            throw new Exception("digest failed: InvalidKeyException, keylength=(" + key.length + ")", e);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("digest failed: NoSuchAlgorithmException(" + algo + ")", e);
        }
    }
}
