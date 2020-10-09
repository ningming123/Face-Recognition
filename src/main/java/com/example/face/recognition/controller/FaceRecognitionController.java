package com.example.face.recognition.controller;

import com.example.face.recognition.model.FaceDetect;
import com.example.face.recognition.service.FaceRecognitionService;
import com.example.face.utils.json.JsonResult;
import com.example.face.utils.json.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/face")
public class FaceRecognitionController {
    @Autowired
    private FaceRecognitionService faceService;
    @Value("${server.file.imagePath}")
    private String imagePath;

    @PostMapping("/upload")
    public JsonResult uploadFile(@RequestParam("uploadFile") MultipartFile file) {
        File dir = new File(imagePath);
        //若此目录不存在，则创建
        if ( !dir.exists()){
            dir.mkdir();
        }
        if (file.isEmpty()) {
            return JsonResultUtil.error("上传文件为空") ;
        }
        String newPath = imagePath+file.getOriginalFilename();
        //创建文件路径
        File dest = new File(newPath);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        //判断文件是否已经存在
        if (dest.exists()) {
            FaceDetect faceDetect = faceService.detect(newPath);
            return JsonResultUtil.ok("上传成功,请稍等",faceDetect);
        }
        try {
            //上传文件
            file.transferTo(dest);
        } catch (IOException e) {
            return JsonResultUtil.error("上传失败");
        }
        //人脸检测
        FaceDetect faceDetect = faceService.detect(newPath);
        return JsonResultUtil.ok("上传成功，请稍等",faceDetect);
    }

}
