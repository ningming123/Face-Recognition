package com.example.face.recognition.controller;

import com.example.face.recognition.model.FaceDetect;
import com.example.face.recognition.service.FaceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/face")
public class FaceRecognitionController {
    @Autowired
    private FaceRecognitionService faceService;

    @RequestMapping("/detect")
    public FaceDetect detect(HttpServletRequest request, HttpServletResponse response){
        return  faceService.detect("E://2.jpg");
    }

}
