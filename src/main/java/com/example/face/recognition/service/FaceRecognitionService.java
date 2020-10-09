package com.example.face.recognition.service;

import com.baidu.aip.face.AipFace;
import com.example.face.recognition.model.FaceDetect;
import com.example.face.utils.date.DateUtil;
import com.example.face.utils.image.PictureUtils;
import com.example.face.utils.facerecognition.StatusCodeUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

@Service
public class FaceRecognitionService {

    @Value("${server.file.imagePath}")
    private String imagePath;

    public static final String APP_ID = "11749711";
    public static final String API_KEY = "AONDr7sNICyEQNgc0OgkPuUe";
    public static final String SECRET_KEY = "KLb2VBtWQHGdQKb7mt3qUugwppYF1FMs";

    public FaceDetect detect(String imagePath){
        File image = new File(imagePath);
        if(!image.exists())
            return null;
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        HashMap<String,String> options = new HashMap<String,String>();
        //识别参数
        options.put("face_field","beauty,age,gender,eye_status,emotion,quality,face_shape");
        // 人脸检测
        JSONObject res = client.detect( PictureUtils.convertFileToBase64(imagePath), "BASE64",  options);

        //将json信息存入对象，便于持久化，另外该json对象没有序列化，无法传递到前台页面
        if(!"SUCCESS".equals(res.getString("error_msg"))){
            return new FaceDetect();
        }
        FaceDetect face = new FaceDetect();
        face.setError_msg(res.getString("error_msg"));
        face.setError_code(res.getInt("error_code"));
        face.setTimestamp(DateUtil.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));

        JSONArray faceList = res.getJSONObject("result").getJSONArray("face_list");
        JSONObject result = faceList.getJSONObject(0);
        face.setAge(result.getInt("age"));
        face.setBeauty(result.getDouble("beauty"));
        face.setEmotion(StatusCodeUtils.getEmotionName(result.getJSONObject("emotion").getString("type")));
        face.setGender(StatusCodeUtils.getGenderName(result.getJSONObject("gender").getString("type")));
        face.setFace_shape(StatusCodeUtils.getFaceShap(result.getJSONObject("face_shape").getString("type")));

        return face;
    }

}
