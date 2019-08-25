package temp;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

/**
 * @项目名称: commonUtil
 * @文件名称: temp 版本号：1.0
 * @Description:
 * @Author lucy
 * @创建日期: 2019年01月28日
 */
public class TestDemo2 {
    public static void main(String[] args) {
        try {
            String key = "12345678";
//            String data = encode(key,"D00001");
//            String data = encode(key,"S0000000000_1");
            String data = encode(key,"HK000000000_1");
            System.out.println(data);

//            String result = decode(key, data);
            String result = decode(key, data);
            System.out.println("result:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected static String decode(String paramString1, String  paramString2) throws Exception {
        byte[] ps = a(paramString2);
        byte[] bs = paramString1.getBytes();
        DESKeySpec dks = new DESKeySpec(bs);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        Key secretKey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
        AlgorithmParameterSpec paramSpec = iv;
        cipher.init(2, secretKey, paramSpec);
        return new String(cipher.doFinal(ps));
    }
    protected static String decode(String paramString1, byte[]  paramString2) throws Exception {
        byte[] ps = paramString2;
        byte[] bs = paramString1.getBytes();
        DESKeySpec dks = new DESKeySpec(bs);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        Key secretKey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
        AlgorithmParameterSpec paramSpec = iv;
        cipher.init(2, secretKey, paramSpec);
        return new String(cipher.doFinal(ps));
    }

    protected static String  encode(String paramString1, String paramString2) throws Exception {
//        byte[] ps = a(paramString2);
        byte[] ps = paramString2.getBytes();
        System.out.println(new String(ps));
        byte[] bs = paramString1.getBytes();
        DESKeySpec dks = new DESKeySpec(bs);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        Key secretKey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
        AlgorithmParameterSpec paramSpec = iv;
        cipher.init(1, secretKey, paramSpec);
        return a(cipher.doFinal(ps));
    }
    private static byte[] b = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63, -1, 63, 52,
            53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34,
            35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
    public static byte[] a(String paramString) {
        if (paramString == null)
            return null;
        int i;
        if ((i = paramString.length()) % 4 != 0)
            throw new IllegalArgumentException("Base64 string length must be 4*n");
        if (paramString.length() == 0)
            return new byte[0];
        int j = 0;
        if (paramString.charAt(i - 1) == '=')
            j++;
        if (paramString.charAt(i - 2) == '=')
            j++;
        byte[] arrayOfByte = new byte[j = i / 4 * 3 - j];
        for (int k = 0; k < i; k += 4) {
            int m = k / 4 * 3;
            int n = paramString.charAt(k);
            int i1 = paramString.charAt(k + 1);
            int i2 = paramString.charAt(k + 2);
            int i3 = paramString.charAt(k + 3);
            n = b[n] << 18 | b[i1] << 12 | b[i2] << 6 | b[i3];
            arrayOfByte[m] = (byte) (n >> 16 & 0xFF);
            if (k < i - 4) {
                arrayOfByte[(m + 1)] = (byte) (n >> 8 & 0xFF);
                arrayOfByte[(m + 2)] = (byte) n;
            } else {
                if (m + 1 < j)
                    arrayOfByte[(m + 1)] = (byte) (n >> 8 & 0xFF);
                if (m + 2 < j)
                    arrayOfByte[(m + 2)] = (byte) n;
            }
        }
        return arrayOfByte;
    }
    private static char[] a = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '+', '/' };
    public static String a(byte[] paramArrayOfByte) {
        int i = 0;
        if (paramArrayOfByte == null)
            return null;
        StringBuffer localStringBuffer = new StringBuffer((paramArrayOfByte.length - 1) / 3 << 6);
        for (int j = 0; j < paramArrayOfByte.length; j++) {
            i |= paramArrayOfByte[j] << 16 - (j % 3 << 3) & 255 << 16 - (j % 3 << 3);
            if ((j % 3 == 2) || (j == paramArrayOfByte.length - 1)) {
                localStringBuffer.append(a[((i & 0xFC0000) >>> 18)]);
                localStringBuffer.append(a[((i & 0x3F000) >>> 12)]);
                localStringBuffer.append(a[((i & 0xFC0) >>> 6)]);
                localStringBuffer.append(a[(i & 0x3F)]);
                i = 0;
            }
        }
        if (paramArrayOfByte.length % 3 > 0)
            localStringBuffer.setCharAt(localStringBuffer.length() - 1, '=');
        if (paramArrayOfByte.length % 3 == 1)
            localStringBuffer.setCharAt(localStringBuffer.length() - 2, '=');
        return localStringBuffer.toString();
    }
}
