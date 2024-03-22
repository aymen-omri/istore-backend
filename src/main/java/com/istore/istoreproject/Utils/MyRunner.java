package com.istore.istoreproject.Utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.istore.istoreproject.Requests.RegisterRequest;
import com.istore.istoreproject.Services.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {

        RegisterRequest user = new RegisterRequest();
        user.setUsername("admin");
        user.setEmail("");
        user.setPassword("123456789");

        userService.createAdmin(user);
    }

}
