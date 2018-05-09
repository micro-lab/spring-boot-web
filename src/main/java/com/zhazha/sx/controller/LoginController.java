package com.zhazha.sx.controller;

import com.zhazha.sx.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String root(Model model) {
        return "page/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @ModelAttribute User user, Model model) {
        if (user.getName().equals("zs") && user.getPassword().equals("zs")) {
            logger.info("登陆成功!");
            request.getSession().setAttribute("user", user);

            return "page/index";

        }
        logger.info("登陆失败!");
        return "page/login";
    }

    @RequestMapping("/index")
    public String index2(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "page/index";
    }

}
