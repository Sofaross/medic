package com.Obrabotka.IT.controllers;

import com.Obrabotka.IT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    @Autowired
    private com.Obrabotka.IT.repository.UserRepository UserRepository;

    @GetMapping("/doctor")
    public String first( Model model) {
        return "doctor";
    }
}
