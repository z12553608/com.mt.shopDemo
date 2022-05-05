package com.meituan.catering.management;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//手动开启事务
@EnableSwagger2Doc
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
