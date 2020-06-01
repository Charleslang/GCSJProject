package com.itheima.user.dto;

import org.springframework.web.multipart.MultipartFile;

/**
  * 上传文件
  *
  * @author: qinjie
 **/
public class UploadFileDTO {
    /**
     * 文件
     */
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
