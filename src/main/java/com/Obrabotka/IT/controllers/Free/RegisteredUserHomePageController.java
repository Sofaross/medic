package com.Obrabotka.IT.controllers.Free;

import com.Obrabotka.IT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisteredUserHomePageController {

    @Autowired
    private UserRepository UserRepository;

    @GetMapping("/")
    public String first( Model model) {
        return "homePage";
    }

}
