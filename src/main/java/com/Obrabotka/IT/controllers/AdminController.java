package com.Obrabotka.IT.controllers;

import com.Obrabotka.IT.entity.Role;
import com.Obrabotka.IT.entity.User;
import com.Obrabotka.IT.repository.RoleRepository;
import com.Obrabotka.IT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/admin")
    public String userList(@AuthenticationPrincipal User user,
                           Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        model.addAttribute("user",user);
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@AuthenticationPrincipal User user,
                              @RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        if (action.equals("give_doctor")) {
            User userNewRole = userService.get(userId);
            //if (!userNewRole.getgetRoles().equals(new Role(3L,"ROLE_ADMIN")))
            //{
                userNewRole.getRoles().clear();
                userNewRole.getRoles().add(new Role(2L, "ROLE_DOCTOR"));
                userService.saveWith(userNewRole);
            //}
        }
        if (action.equals("delete_doctor")) {
                User userNewRole = userService.get(userId);
            if (!userNewRole.getRoles().toString().equals("ROLE_ADMIN")) {
                userNewRole.getRoles().clear();
                userNewRole.getRoles().add(new Role(1L, "ROLE_USER"));
                userService.saveWith(userNewRole);
            }
        }
        model.addAttribute("user",user);
        return "redirect:/admin";
    }

    @PostMapping("/admin_registration")
    public String addUserByAdmin(@ModelAttribute("userForm")@Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "admin";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "admin";
        }

        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@AuthenticationPrincipal User user,
                          @PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        model.addAttribute("user",user);
        return "admin";
    }
}
