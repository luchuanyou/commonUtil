package com.lcy.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @项目名称: img
 * @文件名称: com.lcy.util 版本号：1.0
 * @Description:
 * @Author luchuanyou
 * @创建日期: 2018年09月29日
 * <p/>
 * Copyrights © 2018 上海淘略数据处理有限公司 All rights reserved.
 * <p/>
 * 注意：本内容仅限于上海淘略数据处理有限公司信息技术部内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class ImageUtils {
    private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    //是否强制按照宽高生成缩略图
    private static Boolean DEFAULT_FORCE = false;
    //默认宽度
    private static final int IMAGE_WIDTH = 100;
    //默认高度
    private static final int IMAGE_HEIGHT = 100;


    /**
     * 根据图片路径生成缩略图
     * @param imageBytes 图片字节
     * @param imageType 图片类型:jpg/png...
     * @param w 缩略图宽
     * @param h 缩略图高
     * @param force 是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
     * @return
     */
    public static byte[] getThumbnailImageBytes(byte[] imageBytes, String imageType, int w, int h, boolean force){
        try {
            InputStream is = new ByteArrayInputStream(imageBytes);
            Image img = ImageIO.read(is);
            if(!force){
                // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                int width = img.getWidth(null);
                int height = img.getHeight(null);
                if((width*1.0)/w < (height*1.0)/h){
                    if(width > w){
                        h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                        logger.debug("change image's height, width:{}, height:{}.",w,h);
                    }
                } else {
                    if(height > h){
                        w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                        logger.debug("change image's width, width:{}, height:{}.",w,h);
                    }
                }
            }
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();
            g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
            g.dispose();

            //Image转bytes
            return imageToBytes(bi,imageType);

        } catch (IOException e) {
            logger.error("generate thumbnail image failed.",e);
        }
        return null;
    }
    
    /**
     * BufferedImage转bytes
     * @param bImage
     * @param format
     * @return
     */
    public static byte[] imageToBytes(BufferedImage bImage, String format) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, format, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
    
    public static byte[] getThumbnailImageBytes(byte[] imageBytes, String imageType){
        return getThumbnailImageBytes(imageBytes,imageType,IMAGE_WIDTH,IMAGE_HEIGHT);
    }
    
    public static byte[] getThumbnailImageBytes(byte[] imageBytes, String imageType,int w, int h){
        return getThumbnailImageBytes(imageBytes,imageType,IMAGE_WIDTH,IMAGE_HEIGHT,DEFAULT_FORCE);
    }
    
    
    public static void main(String[] args) {
        try {
            File file = new File("D:\\pdf\\img\\qqq.jpg");
            InputStream is = new FileInputStream(file);
            String imageType = file.getName().substring(file.getName().lastIndexOf(".") + 1);

            BufferedImage bi = ImageIO.read(file);
            byte[] imageBytes = imageToBytes(bi, imageType);

            ImageUtils.getThumbnailImageBytes(imageBytes,imageType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
