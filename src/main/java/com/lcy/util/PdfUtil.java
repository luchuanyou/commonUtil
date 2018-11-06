package com.lcy.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 *
 */
public class PdfUtil {
    /**
     * 获取pdf转图片Base64
     *
     * @param pdfUrl pdf文件地址
     * @return
     */
    public static String convertPdf2Image(String pdfUrl) {
        try {
            // 创建URL
            URL url = new URL(pdfUrl);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();

            PDDocument doc = PDDocument.load(is);
            List pages = doc.getDocumentCatalog().getAllPages();
            for (int i = 0; i < pages.size(); i++) {
                PDPage page = (PDPage) pages.get(i);
                BufferedImage image = page.convertToImage();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", baos);
                baos.flush();

                String data = new String(Base64.encodeBase64(baos.toByteArray()), "utf-8");
                return data;
            }
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
