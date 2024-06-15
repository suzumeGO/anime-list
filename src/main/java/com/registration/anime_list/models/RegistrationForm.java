package com.registration.anime_list.models;

import com.registration.anime_list.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    @NotNull
    private String username;
    @NotNull
    @Size(min = 1, max = 8)
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String secondName;
    private String patronymic;
    @NotNull
    private String email;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), firstName, secondName, patronymic, email);
    }

}
