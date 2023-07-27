package com.atguigu.gmall.common.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

     String upload(MultipartFile multipartFile);
}
