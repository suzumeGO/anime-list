package com.registration.anime_list.controllers;

import com.registration.anime_list.Entity.Anime;
import com.registration.anime_list.Entity.User;
import com.registration.anime_list.services.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @PostMapping("/addAnime")
    @PreAuthorize("hasRole('USER')")
    public String addAnime(@RequestParam("selectedAnime") String selectedAnime, @AuthenticationPrincipal UserDetails userDetails) {
        String[] parts = selectedAnime.split(":");
        Long animeId = Long.parseLong(parts[0]);
        String status = parts[1];
        Anime anime = animeService.findAnimeById(animeId).get();
        animeService.saveAnimeToUser((User) userDetails, anime, status);
        return "redirect:/anime";
    }

}
