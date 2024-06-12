package com.registration.anime_list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/login")
    public String auth() {
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
