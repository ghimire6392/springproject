package com.biswas.springjanweb.user.controller;

import com.biswas.springjanweb.common.enums.Occupation;
import com.biswas.springjanweb.core.config.security.AuthUtil;
import com.biswas.springjanweb.user.entity.User;
import com.biswas.springjanweb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private enum ACTION {
        DELETE("D"), EDIT("E"), NONE("E");

        private String action;
        ACTION(String action) {
            this.action = action;
        }

        public String getAction () {
            return action;
        }
    }

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/user/edit/{id}")
    public String getAllUser(ModelMap map, @PathVariable int id) {
        User editUser = userService.getUserById(id);
        map.put("user", editUser);
        map.put("users", userService.finaAll());
        map.put("occupations", Occupation.values());
        return "user";
    }

    @GetMapping("/user")
    public String getAllUser(ModelMap map,
                             @RequestParam(required = false, defaultValue = "N") String action,
                             @RequestParam(required = false, defaultValue = "0") int id) {

        if (!"N".equals(action)) {
            if (ACTION.DELETE.getAction().equals(action)) {
                //do perform delete operation
                userService.delete(id);
            }

            if (ACTION.EDIT.getAction().equals(action)) {
                //do perform edit operation
            }
        }


        map.put("users", userService.finaAll());
        map.put("occupations", Occupation.values());
        map.put("loggedUser", AuthUtil.getLoggedUser());
        return "user";
    }

    @PostMapping("/user")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user";
    }
}
