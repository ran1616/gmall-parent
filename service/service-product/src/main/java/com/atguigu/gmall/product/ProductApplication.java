package com.atguigu.gmall.product;

import com.atguigu.gmall.common.anno.EnableMinioClient;
import com.atguigu.gmall.common.anno.EnableSwagger2Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gmall.product.mapper")
@EnableMinioClient
@EnableSwagger2Configuration
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
