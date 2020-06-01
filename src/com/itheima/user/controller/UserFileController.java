package com.itheima.user.controller;

import com.itheima.common.Result;
import com.itheima.user.dto.UploadFileDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.itheima.util.StaticParams.DEFAULT_IMAGE_SAVE_PATH_NETWORK;
import static com.itheima.util.StaticParams.DEFAULT_IMAGE_SAVE_PATH_REAL;

/**
  * 文件接口
  *
  * @author: qinjie
 **/
@RestController
@RequestMapping("/files")
public class UserFileController {
    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(file==null){
            return Result.error("文件为空");
        }
        //保存头像文件
        // 生成新的文件名
        String filename = System.currentTimeMillis() + file.getOriginalFilename();
        String realPath = DEFAULT_IMAGE_SAVE_PATH_REAL + filename;
        String network = DEFAULT_IMAGE_SAVE_PATH_NETWORK + filename;
        File dest = new File(realPath);
        dest.setReadable(true, false);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        //保存文件
        file.transferTo(dest);

        return Result.ok("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1590996063&di=61a61f4a3f9a69c650d52e9010656193&src=http://file02.16sucai.com/d/file/2014/1021/3a6943761bf142b41742813f386c98ce.jpg");
    }
}
