package com.example.face.recognition.service;

import com.baidu.aip.face.AipFace;
import com.example.face.utils.PictureUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;

@Service
public class FaceRecognitionService {
    public static final String APP_ID = "11749711";
    public static final String API_KEY = "AONDr7sNICyEQNgc0OgkPuUe";
    public static final String SECRET_KEY = "KLb2VBtWQHGdQKb7mt3qUugwppYF1FMs";

    public void detect(String imagePath){
        File image = new File(imagePath);
        if(!image.exists())
            return;
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        HashMap<String,String> options = new HashMap<String,String>();
        options.put("face_field","beauty,age");
        // 人脸检测
        JSONObject res = client.detect( PictureUtils.convertFileToBase64(imagePath), "BASE64",  options);
        System.out.println(res.toString(2));
    }


}
