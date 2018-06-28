package com.zhazha.sx.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

@Controller
public class TestController {
    @ResponseBody //
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(HttpServletRequest request, HttpServletResponse respone) {

        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map.size());
        for (String key : map.keySet()) {
            System.out.println(key + ":" + Arrays.toString(map.get(key)));
        }


        return "{\"name\":\"zs\",\"gf\":[\"lucy\",\"lily\"]}";
    }
}