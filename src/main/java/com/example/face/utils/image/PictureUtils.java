package com.example.face.utils.image;

import sun.misc.BASE64Encoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PictureUtils {

    /**
     * 图片转base64编码
     * @param imgPath
     * @author Nm
     * @date 2020/8/5
     * */
    public static String convertFileToBase64(String imgPath) {
        byte[] data = null;
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Str = encoder.encode(data);
        return base64Str;
    }
}
