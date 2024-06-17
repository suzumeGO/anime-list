package com.registration.anime_list.services;

import com.registration.anime_list.Entity.AnimeDTO;
import com.registration.anime_list.proxy.AnimeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeProxy animeProxy;

    public AnimeDTO getAnimeList(int page) {
        return animeProxy.getAnime(page);
    }

}
