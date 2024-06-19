package com.registration.anime_list.services;

import com.registration.anime_list.Entity.*;
import com.registration.anime_list.proxy.AnimeProxy;
import com.registration.anime_list.repos.AnimeRepository;
import com.registration.anime_list.repos.UserTitlesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeProxy animeProxy;
    private final AnimeRepository animeRepository;
    private final UserTitlesRepository userTitlesRepository;

    public AnimeDTO getAnimeList(int page) {
        return animeProxy.getAnime(page);
    }
    public Optional<Anime> findAnimeById(Long id) {
        return animeRepository.findById(id);
    }

    public void saveAnimeToUser(User user, Anime anime, String status) {
        UserAnimeId userAnimeId = new UserAnimeId(user.getId(), anime.getId());
        UserAnime userAnime = new UserAnime();
        userAnime.setAnime(anime);
        userAnime.setUserAnimeId(userAnimeId);
        userAnime.setStatus(status);
        userTitlesRepository.save(userAnime);
    }
}
