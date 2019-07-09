package com.juniors.controller;

import lombok.Cleanup;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Juniors
 */@RestController
public class FileUploadController {

     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

     @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req){

         //
         String realPath = req.getSession().getServletContext().getRealPath("/static/uploadFile/");
         String format = sdf.format(new Date());
         File floder = new File(realPath + format);
         if (!floder.isDirectory()){
             floder.mkdirs();
         }

         String oldName = uploadFile.getOriginalFilename();
         String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
         try {
             uploadFile.transferTo(new File(floder,newName));
             String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
                     + "/static/uploadFile/" + format + newName;
             return filePath;
         } catch (IOException e) {
             e.printStackTrace();
         }
         return "上传失败!";
     }
}
