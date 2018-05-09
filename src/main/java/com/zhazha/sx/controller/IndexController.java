package com.zhazha.sx.controller;

import com.zhazha.sx.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @RequestMapping("/index")
    public String index2(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "page/index";
    }
}
