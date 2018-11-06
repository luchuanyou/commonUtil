package com.lcy.util.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;

/**
 * 图片旋转
 */
public class ImageRotateUtil {
    private static final Logger logger = LoggerFactory.getLogger(ImageRotateUtil.class);

    public static void main(String args[]) {
        rotateImage(null, "jpg");
    }

    /**
     * 旋转图片为指定角度
     *
     * @param bytes  图片字节流
     * @param format 图片格式
     * @return
     */
    public static byte[] rotateImage(byte[] bytes, String format) {
        try {
            //获取旋转角度
            int angel = getRotateAngleForPhoto(bytes);
            logger.info("图片旋转角度,getRotateAngleForPhoto angel:{}", angel);
            if (angel == 0 || angel == 360) {
                return bytes;
            }
            //开始图片旋转操作
            BufferedImage src = ImageUtil.bytesToBufferedImage(bytes);
            int src_width = src.getWidth(null);
            int src_height = src.getHeight(null);
            Rectangle rect_des = calcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angel);

            BufferedImage bi = new BufferedImage(rect_des.width, rect_des.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bi.createGraphics();

            g2.translate((rect_des.width - src_width) / 2, (rect_des.height - src_height) / 2);
            g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);

            g2.drawImage(src, 0, 0, src_width, src_height, Color.LIGHT_GRAY, null);
            g2.dispose();
            // 将图片保存在原目录并加上前缀
//            ImageIO.write(bi, "jpg", new File("D:\\pdf\\img\\img_bat.jpg"));
            return ImageUtil.bufferedImageToBytes(bi, "jpg");
        } catch (Exception e) {
            logger.error("旋转图片为指定角度系统异常,rotateImage Exception bytes:{}", bytes, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 图片翻转时，计算图片翻转到正常显示需旋转角度
     */
    public static int getRotateAngleForPhoto(byte[] bytes) {
        int angel = 0;
        try {
            InputStream is = new ByteArrayInputStream(bytes);
            //核心对象操作对象
            Metadata metadata = ImageMetadataReader.readMetadata(is, bytes.length);
            //获取所有不同类型的Directory，如ExifSubIFDDirectory, ExifInteropDirectory, ExifThumbnailDirectory等，这些类均为ExifDirectoryBase extends Directory子类
            //分别遍历每一个Directory，根据Directory的Tags就可以读取到相应的信息
            int orientation = 0;
            Iterable<Directory> iterable = metadata.getDirectories();
            for (Iterator<Directory> iter = iterable.iterator(); iter.hasNext(); ) {
                Directory dr = iter.next();
                if (dr.getString(ExifIFD0Directory.TAG_ORIENTATION) != null) {
                    orientation = dr.getInt(ExifIFD0Directory.TAG_ORIENTATION);
                }
                /*Collection<Tag> tags = dr.getTags();
                for (Tag tag : tags) {
               System.out.println(tag.getTagName() + "： " + tag.getDescription());
            }*/
            }
            if (orientation == 0 || orientation == 1) {
                angel = 360;
            } else if (orientation == 3) {
                angel = 180;
            } else if (orientation == 6) {
                angel = 90;
            } else if (orientation == 8) {
                angel = 270;
            }
        } catch (Exception e) {
            logger.error("计算图片翻转到正常显示需旋转角度系统异常,getRotateAngleForPhoto Exception bytes:{}", bytes, e);
            throw new RuntimeException(e);
        }
        return angel;
    }

    /**
     * 计算旋转参数
     */
    public static Rectangle calcRotatedSize(Rectangle src, int angel) {
        // if angel is greater than 90 degree,we need to do some conversion.
        if (angel > 90) {
            if (angel / 9 % 2 == 1) {
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }

        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_height));
        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        return new Rectangle(new Dimension(des_width, des_height));
    }
}
