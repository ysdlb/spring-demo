package com.ysdlb.spring.userlog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ysdlb.spring.userlog.entity.MoneyPo;
import com.ysdlb.spring.userlog.mapper.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class MyController {
    @Autowired
    private MoneyMapper moneyMapper;
    private Random random = new Random();


    @GetMapping("")
    public String index() {
        MoneyPo po = new MoneyPo();
        po.setName("mybatis plus user");
        po.setMoney((long) random.nextInt(12343));
        po.setIsDeleted(0);
        List<MoneyPo> list =
                moneyMapper.selectList(new QueryWrapper<MoneyPo>().lambda().eq(MoneyPo::getName, po.getName()));
        return "hello";
    }
}

