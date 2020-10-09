package com.example.face.utils.facerecognition;

public class StatusCodeUtils {

    public static String getEmotionName(String code) {
        switch (code) {
            case "angry":
                return "愤怒";
            case "disgust":
                return "厌恶";
            case "fear":
                return "恐惧";
            case "happy":
                return "高兴";
            case "sad":
                return "伤心";
            case "surprise":
                return "惊讶";
            case "neutral":
                return "无情绪";
            default: return "";
        }
    }

    public static String getFaceShap(String code) {
        switch (code) {
            case "square":
                return "正方形";
            case "triangle":
                return "三角形";
            case "oval":
                return "椭圆";
            case "heart":
                return "心形";
            case "round":
                return "圆形";
            default: return "";
        }
    }

    public static String getGenderName(String code) {
        switch (code) {
            case "male":
                return "男性";
            case "female":
                return "女性";
            default: return "";
        }
    }
}
