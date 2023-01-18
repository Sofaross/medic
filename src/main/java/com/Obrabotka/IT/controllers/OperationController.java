package com.Obrabotka.IT.controllers;

import com.Obrabotka.IT.entity.Laboratory;
import com.Obrabotka.IT.repository.LaboratoryRepository;
import com.Obrabotka.IT.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperationController {
//    @Autowired
//    private LaboratoryService laboratoryService;
//    @Autowired
//    private RequestRepository requestRepository;
//    @Autowired
//    private LaboratoryRepository laboratoryRepository;
//    public int idOperation;
//
//    @GetMapping("/send_request")
//    public String OperationList(@AuthenticationPrincipal Laboratory operations,
//                           Model model) {
//        model.addAttribute("allOperation", laboratoryService.findAllOperation());
//        model.addAttribute("operations",operations);
//        return "send_request";
//    }

//    @PostMapping("/send_request")
//    public String AddRequest(@AuthenticationPrincipal User user,
//                             @RequestParam(required = true, defaultValue = "" ) Long operationId,
//                             @RequestParam(required = true, defaultValue = "" ) String action,
//                             Model model) {
//
//        if (action.equals("request")) {
//            Laboratory laboratory = laboratoryRepository.findById(operationId).get();
//            Requests requests = new Requests();
//            requests.set(laboratory.getScheduleLabsId());
//            requests.setTime(laboratory.getTime());
//            requests.setUser(user.getUsername());
//            requestRepository.save(requests);
//        }
//        return "redirect:/send_request";
//    }
}
