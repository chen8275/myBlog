package com.zking;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by Administrator on 2018/12/5.
 */

@SpringBootApplication
@ServletComponentScan("com.zking.config")
@EnableTransactionManagement
@EnableSwagger2
public class AppLication{
    public static void main(String[] args) {
        SpringApplication.run(AppLication.class, args);
    }
    

    
    
}
