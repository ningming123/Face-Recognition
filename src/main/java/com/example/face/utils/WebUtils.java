package com.example.face.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {

    public static void out(HttpServletResponse response,String str){
        response.setContentType("test/html;charset=UTF-8");
         try {
             response.getWriter().println(str);
         }catch (IOException e){
             e.printStackTrace();
         }
    }
}
