package com.registration.anime_list.proxy;

import com.registration.anime_list.Entity.AnimeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "anime",
url = "localhost:8080")

public interface AnimeProxy {
    @GetMapping("/anime") AnimeDTO getAnime(@RequestParam int page);

}
