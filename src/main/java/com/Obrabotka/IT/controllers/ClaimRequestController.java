package com.Obrabotka.IT.controllers;


import com.Obrabotka.IT.entity.RequestRegistration;
import com.Obrabotka.IT.entity.Role;
import com.Obrabotka.IT.entity.User;
import com.Obrabotka.IT.repository.RequestRegistrationUserRepository;
import com.Obrabotka.IT.repository.UserRepository;
import com.Obrabotka.IT.service.LaboratoryService;
import com.Obrabotka.IT.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class ClaimRequestController {
    @Autowired
    RequestService requestService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RequestRegistrationUserRepository requestRepository;
    @Autowired
    LaboratoryService laboratoryService;

    @GetMapping("/claim_request")
    public String OperationList(@AuthenticationPrincipal RequestRegistration requests,
                                Model model) {
        model.addAttribute("allRequest", requestService.findAllRequest());
        model.addAttribute("requests", requests);
        return "claim_request";
    }
    @PostMapping("/claim_request")
    public String AddRequest(@AuthenticationPrincipal User user,
                             @RequestParam(required = true, defaultValue = "" ) Long requestId,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             Model model) {

        if (action.equals("accept")) {
            RequestRegistration requests = requestRepository.findById(requestId).get();
            User newUser = new User();
            newUser.setFirst_name(requests.getFirst_name());
            newUser.setLast_name(requests.getLast_name());
            newUser.setEmail(requests.getEmail());
            newUser.setPhone(requests.getPhone());
            newUser.setPassword(requests.getPassword());
            newUser.setUsername(requests.getUsername());
            newUser.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            requestService.deleteReq(requestId);
            userRepository.save(newUser);
        }
        if (action.equals("reject")){
            requestService.deleteReq(requestId);
        }

        return "claim_request";
    }
}