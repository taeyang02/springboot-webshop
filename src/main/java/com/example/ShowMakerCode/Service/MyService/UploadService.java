package com.example.ShowMakerCode.Service.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UploadService {
    @Autowired
    HttpServletRequest request;


    public String posst(MultipartFile file){
        File file1 = new File("");
        String x = file1.getAbsolutePath()+"\\src\\main\\resources\\static\\images\\";
        SimpleDateFormat sdf=new SimpleDateFormat("ddMMYYYYhhmmss");
        String dateString=sdf.format(new Date());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()).substring(0,StringUtils.cleanPath(file.getOriginalFilename()).indexOf("."))+dateString+".png";
        try {
            Path path = Paths.get(x+fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Upload Thất Bại");
            return null;
        }
        return fileName;
    }
}
