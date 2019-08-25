package http.netty.jk;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/08/15
 */
public class PAJKDESUtil {
    /**
     * des加密
     * @param message 加密数据
     * @param key 密钥
     * @return
     */
    public static String encryptHex(String message, String key) {
        try {
            return toString(encrypt(message, key));
        } catch (Throwable e) {
            throw new IllegalArgumentException("encryptHex: message=[" + message + "], key=[" + key + "]");
        }
    }

    public static String toString(byte[] data) {
        if (data == null) {
            return null;
        } else {
            StringBuffer buffer = new StringBuffer();

            for(int i = 0; i < data.length; ++i) {
                String hex = Integer.toHexString(255 & data[i]);
                if (hex.length() == 1) {
                    buffer.append('0');
                }

                buffer.append(hex);
            }

            return buffer.toString();
        }
    }

    public static byte[] encrypt(String message, String key) throws Exception {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        int j = 0;

        for(int var6 = 16; j < 8; keyBytes[var6++] = keyBytes[j++]) {
            ;
        }

        SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");
        IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(1, secretKey, iv);
        byte[] plainTextBytes = message.getBytes("utf-8");
        byte[] cipherText = cipher.doFinal(plainTextBytes);
        return cipherText;
    }
}
