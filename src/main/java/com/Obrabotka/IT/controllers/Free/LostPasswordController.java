package com.Obrabotka.IT.controllers.Free;

import com.Obrabotka.IT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LostPasswordController {

    @GetMapping("/lostPassword")
    public String first( Model model) {
        return "lostPassword";
    }
}
