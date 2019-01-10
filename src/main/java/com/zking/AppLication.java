package com.zking;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

/**
 * Created by Administrator on 2017/5/5.
 */

@SpringBootApplication
@ServletComponentScan("com.zking.config")
public class AppLication {
    public static void main(String[] args) {
        SpringApplication.run(AppLication.class, args);
    }
}
