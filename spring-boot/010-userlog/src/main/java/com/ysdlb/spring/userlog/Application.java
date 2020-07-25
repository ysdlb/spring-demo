package com.ysdlb.spring.userlog;

import com.ysdlb.spring.userlog.utils.MoneyRepository;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by @author yihui in 14:41 19/12/26.
 */
@SpringBootApplication
@MapperScan("com.ysdlb.spring.userlog.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
