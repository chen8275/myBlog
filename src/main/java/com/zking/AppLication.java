package com.zking;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by Administrator on 2018/12/5.
 */

@SpringBootApplication
@ServletComponentScan("com.zking.config")
@EnableTransactionManagement
@EnableCaching
public class AppLication {
    public static void main(String[] args) {
        SpringApplication.run(AppLication.class, args);
    }
}
