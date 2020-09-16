package com.aboelela924.springbootfileupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    private Map<String, Object> result = new HashMap<>();

    @RequestMapping("/uploadFile")
    public Map<String, Object> upload(@RequestParam("attach")MultipartFile file) throws IOException{
        System.out.println("File Name is: " + file.getName());
        System.out.println("File type is: " + file.getContentType());

        String filePath = "E:/";
        file.transferTo(new File(filePath+file.getOriginalFilename()));
        result.put("success", true);
        return result;
    }

}
