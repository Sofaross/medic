package com.Obrabotka.IT.controllers;


import com.Obrabotka.IT.entity.Laboratory;
import com.Obrabotka.IT.entity.User;
import com.Obrabotka.IT.service.LaboratoryService;
import com.Obrabotka.IT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;

    @GetMapping("/laboratory")
    public String userList(@AuthenticationPrincipal User user,
                           Model model) {
        model.addAttribute("allLab", laboratoryService.allLaboratory());
        model.addAttribute("lab",user);
        return "laboratory";
    }
    @GetMapping("/laboratory/{type_analysisId}")
    public String getData(@AuthenticationPrincipal Laboratory laboratory,
                          @PathVariable("type_analysisId") String data,Model model){
        model.addAttribute("type_analysisId",laboratoryService.dataList(data));
        model.addAttribute("labotatory",laboratory);
        return "laboratory";
    }
}
