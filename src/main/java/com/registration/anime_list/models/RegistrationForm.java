package com.registration.anime_list.models;

import com.registration.anime_list.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String email;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), firstName, secondName, patronymic, email);
    }

}
