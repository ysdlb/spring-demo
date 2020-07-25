package com.ysdlb.spring.mybatisplus;

import com.ysdlb.spring.mybatisplus.dao.MoneyRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by @author yihui in 14:41 19/12/26.
 */
@SpringBootApplication
@MapperScan("com.ysdlb.spring.mybatisplus.mapper")
public class Application {

    public Application(MoneyRepository moneyRepository) {
        moneyRepository.testDemo();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
