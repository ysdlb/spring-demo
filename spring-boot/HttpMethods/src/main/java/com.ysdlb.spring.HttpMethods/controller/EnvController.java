package com.ysdlb.spring.HttpMethods.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@ResponseBody
public class EnvController {
    public EnvController() {
        System.out.println("EnvController init");
    }

    @Autowired
    private Environment environment;

    @RequestMapping(method = RequestMethod.GET, path = "show")
    public String obtainEnvironment() {
        StandardServletEnvironment standardServletEnvironment = (StandardServletEnvironment) environment;
        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>(8);
        Iterator<PropertySource<?>> iterator = standardServletEnvironment.getPropertySources().iterator();
        while (iterator.hasNext()) {
            PropertySource<?> source = iterator.next();
            Map<String, String> m = new HashMap<String, String>(128);
            String name = source.getName();
            Object o = source.getSource();
            if (o instanceof Map) {
                for (Map.Entry<String, Object> entry : ((Map<String, Object>) o).entrySet()) {
                    String key = entry.getKey();
                    m.put(key, standardServletEnvironment.getProperty(key));
                }
            }
            map.put(name, m);
        }
        return JSON.toJSONString(map);

    }
}
