package com.registration.anime_list.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity(name = "titles")
@NoArgsConstructor
public class Anime {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "anime",
            cascade = CascadeType.ALL)
    private Set<UserAnime> animeUsers;


}
