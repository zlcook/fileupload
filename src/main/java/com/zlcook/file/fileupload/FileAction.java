package com.zlcook.file.fileupload;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by zhouliang6 on 2017/10/25.
 */
@RestController
@RequestMapping(value = "/")
public class FileAction {

    @RequestMapping(value="upload", method= RequestMethod.POST)
    public String handleFileUpload(MultipartHttpServletRequest request, Model model, String name, String testName){
        MyStatus status = new MyStatus();
         Iterator<String> iterator = request.getFileNames();
        while (iterator.hasNext()) {
            String fileName = iterator.next();
            MultipartFile multipartFile = request.getFile(fileName);
            String originName=multipartFile.getOriginalFilename();
            try {
                //保存路径
                String savePath= ConfUtils.getSavePath();
                File saveFile = new File(savePath,originName);
                if( !saveFile.exists())
                    saveFile.mkdirs();
                multipartFile.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                status.setStatus(0);
                status.setMessage("上传失败!");
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status.getStatus());
        jsonObject.addProperty("message",status.getMessage());
        return jsonObject.toString();
    }
}
