package com.registration.anime_list;

import com.registration.anime_list.Entity.Anime;
import com.registration.anime_list.Entity.User;
import com.registration.anime_list.Entity.UserAnime;
import com.registration.anime_list.Entity.UserAnimeId;
import com.registration.anime_list.repos.AnimeRepository;
import com.registration.anime_list.repos.UserRepository;
import com.registration.anime_list.repos.UserTitlesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepoTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTitlesRepository userTitlesRepository;
    @Autowired
    private AnimeRepository animeRepository;

    @Test
    public void findByUsernameTest() {
        userRepository.save(getUser());

        Assertions.assertNotNull(userRepository.findByUsername(getUser().getUsername()));
    }

    @Test
    public void addUserAnimeTest() {
        User user = userRepository.save(getUser());
        Anime anime = animeRepository.save(getAnime());

        UserAnimeId userAnimeId = new UserAnimeId(user.getId(), anime.getId());
        UserAnime ua = new UserAnime(userAnimeId, "просмотрено", user, anime);

        userTitlesRepository.save(ua);

        Assertions.assertTrue(userTitlesRepository.existsById(userAnimeId));

    }

    private User getUser() {
        return new User("makaka", "12345", "Nick", "Fuggers", "", "ar12@gmail.com");
    }

    private Anime getAnime() {
        Anime anime = new Anime();
        anime.setId(1L);
        anime.setTitle("Indiana Jeeez");
        return anime;
    }

}
