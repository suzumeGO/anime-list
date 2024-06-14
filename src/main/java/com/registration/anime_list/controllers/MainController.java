package com.registration.anime_list.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/login")
    public String getAuthPage() {
        return "login";
    }
    @GetMapping("/anime")
    public String getAnimeList() {
        return "animeList";
    }

    @GetMapping("/myList")
    public String getMyList() {
        return "page";
    }

}
