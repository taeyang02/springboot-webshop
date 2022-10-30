package com.example.ShowMakerCode.Constant;

import org.springframework.stereotype.Service;

@Service
public class AlertService {
    public String success(String title,String value){
        return "swal(\""+ title+"\", \""+value+"\", \"success\");";
    }
    public String warning(String title,String value){
        return "swal(\""+ title+"\", \""+value+"\", \"warning\");";
    }
    public String error(String title,String value){
        return "swal(\""+ title+"\", \""+value+"\", \"error\");";
    }
    public String info(String title,String value){
        return "swal(\""+ title+"\", \""+value+"\", \"info\");";
    }
}
