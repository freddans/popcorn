package com.freddans.popcorn.controllers;

import com.freddans.popcorn.entities.Movie;
import com.freddans.popcorn.entities.TvShow;
import com.freddans.popcorn.entities.User;
import com.freddans.popcorn.services.MovieService;
import com.freddans.popcorn.services.TvShowService;
import com.freddans.popcorn.services.UserService;
import com.freddans.popcorn.services.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {

    private MovieService movieService;
    private UserService userService;
    private TvShowService tvShowService;

    @Autowired
    public WebController(MovieService movieService, UserService userService, TvShowService tvShowService) {
        this.movieService = movieService;
        this.userService = userService;
        this.tvShowService = tvShowService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerAccount(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/index")
    public String indexPage(Model model) {
        List<Movie> latestMovies = movieService.findTenMostRecentAddedMovies();
        List<TvShow> latestTvShows = tvShowService.findTenMostRecentAddedTvShows();
        User userDetails = userService.findUserInfo();
        model.addAttribute("userinfo", userDetails);
        model.addAttribute("mostrecentmovies", latestMovies);
        model.addAttribute("mostrecenttvshows", latestTvShows);
        return "index";
    }

    @PostMapping("/register")
    public String createUser(User user) {
        String result = userService.createUserWeb(user);
        if (result.equals("User was saved")) {
            return "redirect:/index";
        } else {
            return result;
        }
    }

    @GetMapping("/mydetails")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public String getMyDetails(Model model) {
        User userDetails = userService.findUserInfo();
        model.addAttribute("userinfo", userDetails);
        return "mydetails";
    }

    @GetMapping("/firstpage")
    public String firstPage() { return "firstpage"; }
}
