package com.registration.anime_list.repos;

import com.registration.anime_list.Entity.UserAnime;
import com.registration.anime_list.Entity.UserAnimeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTitlesRepository extends JpaRepository<UserAnime, UserAnimeId> {
}
