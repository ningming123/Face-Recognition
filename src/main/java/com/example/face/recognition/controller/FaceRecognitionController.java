package com.example.face.recognition.controller;

import com.example.face.recognition.service.FaceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/face")
public class FaceRecognitionController {
    @Autowired
    private FaceRecognitionService faceService;


    @RequestMapping("/detect")
    public void detect(){
        faceService.detect("");
    }

}
