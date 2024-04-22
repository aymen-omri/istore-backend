package com.istore.istoreproject.Utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.istore.istoreproject.Requests.RegisterRequest;
import com.istore.istoreproject.Services.CategoryService;
import com.istore.istoreproject.Services.ConnectivityService;
import com.istore.istoreproject.Services.UserService;
import com.istore.istoreproject.models.Category;
import com.istore.istoreproject.models.Connectivity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {

    private final UserService userService;
    private final CategoryService categoryService;
    private final ConnectivityService connectivityService;

    @Override
    public void run(String... args) throws Exception {

        RegisterRequest user = new RegisterRequest();
        user.setUsername("admin");
        user.setEmail("aymen.omri@istic.ucar.tn");
        user.setPassword("123456789");

        userService.createAdmin(user);


        Category category1 = new Category();
        category1.setName("IPHONE");
        categoryService.addCategory(category1);

        Connectivity connectivity = new Connectivity();
        connectivity.setOption("Connectivity1");

        connectivityService.add(connectivity);

        Connectivity connectivity1 = new Connectivity();
        connectivity1.setOption("Connectivity2");

        connectivityService.add(connectivity1);

    }

}
