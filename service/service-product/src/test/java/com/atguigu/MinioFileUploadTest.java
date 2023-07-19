package com.atguigu;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.FileInputStream;

public class MinioFileUploadTest {

    public static void main(String[] args) {

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
            FileInputStream fileInputStream = new FileInputStream("D://Downlouds//11.png") ;
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket("gmall")
                    .object("1.png")            // 对象名称
                    .stream(fileInputStream, fileInputStream.available() , -1)
                    .build()) ;

            // 获取访问地址
            String fileUrl = "http://192.168.100.50:9000/gmall/1.png" ;
            System.out.println(fileUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}