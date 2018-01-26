package com.zhazha.sx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhazha.sx.bean.Movies;
import com.zhazha.sx.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MoviesController {
	@RequestMapping("/movie")
    public String movie(HttpServletRequest request, Model model) {
        List<Movies> mlist = new ArrayList<Movies>();

        Movies move= new Movies();
        move.setId(1);
        move.setName("芳华");
        move.setPerformerId(1);
        move.setMainPerformerName("黄轩");
        move.setHasMosaic("无码");
        move.setReleaseTime(new Date());
        move.setTorrentFile("~~~~~~~~~");
        mlist.add(move);

        Movies move1= new Movies();
        move1.setId(2);
        move1.setName("前任3");
        move1.setPerformerId(2);
        move1.setMainPerformerName("韩庚");
        move1.setHasMosaic("无码");
        move1.setReleaseTime(new Date());
        move1.setTorrentFile("~~~~~~~~~");
        mlist.add(move1);

        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute("user", user);

        model.addAttribute("movies", mlist);
	    return "page/basic_table";
    }


}
