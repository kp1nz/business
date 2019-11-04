package com.kp1nz.controller.backend;

import com.kp1nz.common.ServerResponse;
import com.kp1nz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kp1nz
 * @create 2019-01-08 21:16
 */
@Controller
@RequestMapping(value = "/manage/product")
public class UploadController {
    @Autowired
    IProductService productService;

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(){
        return "upload";//逻辑视图   前缀+逻辑视图+后缀
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse upload2(@RequestParam(value = "upload_file",required = false) MultipartFile file){

        String path = "C:\\Workbench\\ftpfile";
        return productService.upload(file,path);
    }
}
