package com.registration.anime_list;

import com.registration.anime_list.Entity.User;
import com.registration.anime_list.repos.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepoTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void findByUsernameTest() {
        userRepository.save(getUser());

        Assertions.assertNotNull(userRepository.findByUsername(getUser().getUsername()));
    }

    private User getUser() {
        return new User("makaka", "12345", "Nick", "Fuggers", "", "ar12@gmail.com");
    }

}
