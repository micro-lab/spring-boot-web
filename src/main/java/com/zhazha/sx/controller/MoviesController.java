package com.zhazha.sx.controller;

import java.util.List;

import com.zhazha.sx.bean.Movie;
import com.zhazha.sx.bean.User;
import com.zhazha.sx.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MoviesController {

    @Autowired
    private MovieDao movieDao;

    @RequestMapping("/showAllMovie")
    public String movie(HttpServletRequest request, Model model) {

        List<Movie> movies = movieDao.getMovies();

        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute("user", user);

        model.addAttribute("movies", movies);
	    return "page/movies";
    }


}
