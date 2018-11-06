package com.lcy.util.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 图片处理工具
 */
public class ImageUtil {
    private static final Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    public static void main(String[] args) {
//        byte[] result = getImageBytes("http://192.168.1.112:8888/group1/M00/00/0D/wKgBcFurWLOAXVlCAACj38FRJWc114.PNG");
        byte[] result = getImageBytes("http://mmbiz.qpic.cn/mmbiz_png/88BQiaSkmtzl1KfOAyBumiboicpHeNCdbLDpQezonp8WkAt4D0RGqgMXAkh5aicRpE256lprqCyZRDUN74k5jwNPhg/0");
        System.out.println(result);
    }

    /**
     * 获取图片字节流
     *
     * @param imageUrl 图片地址
     * @return
     */
    public static byte[] getImageBytes(String imageUrl) {
        try {
            // 创建URL
            URL url = new URL(imageUrl);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            ByteArrayOutputStream data = new ByteArrayOutputStream();
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 关闭流
            is.close();
            return data.toByteArray();
        } catch (Exception e) {
            logger.error("获取图片字节流失败,getImageBytes Exception imageUrl:{}", imageUrl, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 字节流转图片
     *
     * @param bytes
     * @return
     */
    public static BufferedImage bytesToBufferedImage(byte[] bytes) {
        try {
            InputStream is = new ByteArrayInputStream(bytes);//将b作为输入流；
            return ImageIO.read(is);
        } catch (Exception e) {
            logger.error("字节流转图片系统异常,BufferedImage Exception", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 图片转字节流
     *
     * @param bi
     * @param format
     * @return
     */
    public static byte[] bufferedImageToBytes(BufferedImage bi, String format) {
        try {
            ByteArrayOutputStream data = new ByteArrayOutputStream();
            ImageIO.write(bi, format, data);
            return data.toByteArray();
        } catch (IOException e) {
            logger.error("图片转字节流系统异常,bufferedImageToBytes Exception", e);
            throw new RuntimeException(e);
        }
    }
}
