package com.atguigu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: EduApplication
 * @Description: TODO
 * @Author: 张欢
 * @Date 2021/2/17 12:33
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
@EnableSwagger2
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
