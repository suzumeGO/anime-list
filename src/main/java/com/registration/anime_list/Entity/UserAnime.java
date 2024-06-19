package com.registration.anime_list.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "user_titles")
@NoArgsConstructor
@AllArgsConstructor
public class UserAnime {
    @EmbeddedId
    private UserAnimeId userAnimeId;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("user")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("anime")
    @JoinColumn(name = "title_id")
    private Anime anime;

}
