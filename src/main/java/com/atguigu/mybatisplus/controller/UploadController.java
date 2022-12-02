package com.atguigu.mybatisplus.controller;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.atguigu.mybatisplus.entity.JsonResult;
import com.atguigu.mybatisplus.entity.Stocklist;
import com.atguigu.mybatisplus.entity.Tradehistory;
import com.atguigu.mybatisplus.mapper.TradehistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upfile")
public class UploadController {

    @Autowired
    private TradehistoryMapper tradehistoryMapper;

    @RequestMapping("/test")
    public String test() {
        return "upload";
    }

    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public Object up(String name, @RequestParam(value = "multipartFile") MultipartFile multipartFile)
            throws IllegalStateException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (multipartFile != null) {
            // 设置文件名称
            map.put("nameParam", name);
            // 设置文件名称
            map.put("fileame", multipartFile.getName());
            // 设置文件类型
            map.put("contentType", multipartFile.getContentType());
            // 设置文件大小
            map.put("fileSize", multipartFile.getSize());
            // 创建文件名称
            String fileName = UUID.randomUUID() + "."
                    + multipartFile.getContentType().substring(multipartFile.getContentType().lastIndexOf("/") + 1);
            // 获取到文件的路径信息
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            String filePath = servletRequestAttributes.getRequest().getServletContext().getRealPath("/") + fileName;
            // 打印保存路径
            System.out.println(filePath);
            // 保存文件的路径信息
            map.put("filePath", filePath);
            // 创建文件
            File saveFile = new File(filePath);
            // 文件保存
            multipartFile.transferTo(saveFile);
            // 返回信息
            return map;
        } else {
            return "no file ";
        }
    }

    @RequestMapping(value = "/up2", method = RequestMethod.POST)
    @ResponseBody
    public String up2(@RequestParam(name = "multipartFile") MultipartFile file){
        System.out.println("上传文件，进来了");
        if(file.isEmpty()){
            return "空的，上传失败";
        }
        String name = file.getOriginalFilename();
        System.out.println("name "+name);
        String path = "E:/360Downloads/";
        File filew = new File(path+name);
        try {
            file.transferTo(filew);
            System.out.println("YES");
            return "上传成功！ " + path+name ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "DONT KMOW ";
    }

}
