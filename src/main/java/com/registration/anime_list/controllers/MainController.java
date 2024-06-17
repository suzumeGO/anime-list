package com.registration.anime_list.controllers;

import com.registration.anime_list.services.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final AnimeService animeService;

    @GetMapping("/login")
    public String getAuthPage() {
        return "login";
    }
    @GetMapping("/anime")
    public String getAnimeList(Model model) {
        model.addAttribute("animeList", animeService.getAnimeList(1).data());
        return "animeList";
    }

    @GetMapping("/myList")
    public String getMyList() {
        return "page";
    }

}
