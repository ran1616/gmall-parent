package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.product.service.FileUploadService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public String upload(MultipartFile multipartFile) {

        try {


            // 创建minio的客户端对象
            MinioClient minioClient = MinioClient.builder()
                    .endpoint("http://192.168.100.50:9000")
                    .credentials("admin", "admin123456")
                    .build();

            // 判断bucket是否存在
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("gmall").build());
            if (!found) {

                // 创建一个bucket
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("gmall").build());

            }

            // 上传文件
            String uuidFileName = UUID.randomUUID().toString().replace("-", "");
            String originalFilename = multipartFile.getOriginalFilename();      // 获取文件的原始名称  xxxx.jpg
            String extFileName = FilenameUtils.getExtension(originalFilename);
            String fileName = uuidFileName + "." + extFileName;
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket("gmall")
                    .object(fileName)            // 对象名称
                    .stream(multipartFile.getInputStream(), multipartFile.getSize(), -1)
                    .build());

            // 获取访问地址
            String fileUrl = "http://192.168.100.50:9000/gmall/" + fileName;

            return fileUrl;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
